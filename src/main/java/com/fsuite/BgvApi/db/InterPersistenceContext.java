package com.fsuite.BgvApi.db;

import java.io.IOException;
import java.io.InputStream;
import java.security.Security;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
public class InterPersistenceContext
{

	static
	{
		Security.addProvider(new BouncyCastleProvider());
	}
	
	private static final String INTER_DB_PROPERTIES="inter_db.properties";
	private static final String ACT_DB_PROPERTIES="act_db.properties";


	private static final String ENCODE_SEED_KEY = "aWZpZ3MxMzVAJF4kXiYpIw==";
	static final String AES_ALGO = "AES";
	private static Cipher ecipher;
	private  static Cipher dcipher;

	

	private static final String DIALECT = "hibernate.dialect";
	private static final String HBM_2_DDL = "hibernate.hbm2ddl.auto";
	private static final String SHOW_SQL = "hibernate.show_sql";
	private static final String FORMAT_SQL = "hibernate.format_sql";

	private static final String DATA_SOURCE_PREFIX = "data_source_";
	private static final String DECRYPT_DATA_SOURCE_PREFIX = "decrypt_data_source_";

	@Bean(destroyMethod = "close")
	@Qualifier("interDataSource")
	@Primary
	DataSource dataSource(Environment env) throws Exception
	{
		ComboPooledDataSource dataSource = null;
		dataSource = new ComboPooledDataSource();
		Properties properties = loadProperties(INTER_DB_PROPERTIES);
		Properties dataSourceProperties = getDataSourceProperties(properties);
		for (String property : dataSourceProperties.stringPropertyNames())
		{
			BeanUtils.setProperty(dataSource, property, dataSourceProperties.get(property));
		}
		dataSource.setProperties(dataSourceProperties);
		return dataSource;
	}

	@Bean
	@Qualifier("interEntityManagerFactory")
	@Primary
	LocalContainerEntityManagerFactoryBean entityManagerFactory(@Autowired @Qualifier("interDataSource") DataSource dataSource) throws Exception
	{
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setPersistenceUnitName("interBgvEntityManager");
		Properties properties = loadProperties(INTER_DB_PROPERTIES);
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.fsuite.BgvApi.inter.models");
		Properties jpaProperties = new Properties();
		properties = getDataSourceProperties(properties);
		jpaProperties.put(DIALECT, properties.getProperty(DIALECT));
		jpaProperties.put(HBM_2_DDL, properties.getProperty(HBM_2_DDL));
		jpaProperties.put(SHOW_SQL, Boolean.parseBoolean(properties.getProperty(SHOW_SQL)));
		jpaProperties.put(FORMAT_SQL, Boolean.parseBoolean(properties.getProperty(FORMAT_SQL)));
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		return entityManagerFactoryBean;
	}

	@Bean
	@Qualifier("interTransactionManager")
	@Primary
	JpaTransactionManager transactionManager(@Autowired @Qualifier("interEntityManagerFactory") EntityManagerFactory entityManagerFactory)
	{
		JpaTransactionManager interTransactionManager = new JpaTransactionManager();
		interTransactionManager.setEntityManagerFactory(entityManagerFactory);
		return interTransactionManager;
	}
	
	//Operational Db
	@Bean(destroyMethod = "close")
	@Qualifier("actDataSource")
	DataSource actDataSource(Environment env) throws Exception
	{
		ComboPooledDataSource dataSource = null;
		dataSource = new ComboPooledDataSource();
		Properties properties = loadProperties(ACT_DB_PROPERTIES);
		Properties dataSourceProperties = getDataSourceProperties(properties);
		for (String property : dataSourceProperties.stringPropertyNames())
		{
			BeanUtils.setProperty(dataSource, property, dataSourceProperties.get(property));
		}
		dataSource.setProperties(dataSourceProperties);
		return dataSource;
	}

	@Bean
	@Qualifier("actEntityManagerFactory")
	LocalContainerEntityManagerFactoryBean actEntityManagerFactory(@Autowired @Qualifier("actDataSource") DataSource dataSource) throws Exception
	{
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setPersistenceUnitName("actBgvEntityManager");
		Properties properties = loadProperties(ACT_DB_PROPERTIES);
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.fsuite.BgvApi.act.models");
		Properties jpaProperties = new Properties();
		properties = getDataSourceProperties(properties);
		jpaProperties.put(DIALECT, properties.getProperty(DIALECT));
		jpaProperties.put(HBM_2_DDL, properties.getProperty(HBM_2_DDL));
		jpaProperties.put(SHOW_SQL, Boolean.parseBoolean(properties.getProperty(SHOW_SQL)));
		jpaProperties.put(FORMAT_SQL, Boolean.parseBoolean(properties.getProperty(FORMAT_SQL)));
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		return entityManagerFactoryBean;
	}

	@Bean
	@Qualifier("actTransactionManager")
	JpaTransactionManager actTransactionManager(@Autowired @Qualifier("actEntityManagerFactory") EntityManagerFactory entityManagerFactory)
	{
		JpaTransactionManager actTransactionManager = new JpaTransactionManager();
		actTransactionManager.setEntityManagerFactory(entityManagerFactory);
		return actTransactionManager;
	}
	
	private Properties getDataSourceProperties(Properties properties) throws Exception
	{

		Properties validatedProperties = null;
		if (properties != null)
		{
			validatedProperties = new Properties();
			String dataSourceKey = null;
			String dataSourceValue = null;
			for (String key : properties.stringPropertyNames())
			{
				if (key.startsWith(DECRYPT_DATA_SOURCE_PREFIX))
				{
					dataSourceKey = key.substring(DECRYPT_DATA_SOURCE_PREFIX.length());
					dataSourceValue = new String(InterPersistenceContext.decryptPasswordUsingSeed(Base64.decodeBase64(properties.getProperty(key).trim())));
					validatedProperties.put(dataSourceKey, dataSourceValue);
				}
				else if (key.startsWith(DATA_SOURCE_PREFIX))
				{
					dataSourceKey = key.substring(DATA_SOURCE_PREFIX.length());
					dataSourceValue = properties.getProperty(key);
					validatedProperties.put(dataSourceKey, dataSourceValue);
				}

			}
		}
		return validatedProperties;
	}
	
	private Properties loadProperties(String fileName) throws IOException
	{
		Properties properties = new Properties();
		InputStream in = null;
		try
		{
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			//in = new FileInputStream(new File(fileName));
			properties.load(in);
		}
		finally
		{
			if (in != null)
			{
				try
				{
					in.close();
				}
				catch (Exception ex)
				{
				}
			}
		}
		return properties;
	}
	
	public static byte[] decryptPasswordUsingSeed(byte[] paswd) throws Exception
	{
		SecretKeySpec key = new SecretKeySpec(Base64.decodeBase64(ENCODE_SEED_KEY), AES_ALGO);
		dcipher = Cipher.getInstance(AES_ALGO);
		dcipher.init(Cipher.DECRYPT_MODE, key);
		return dcipher.doFinal(paswd);
	}

	public static byte[] encryptPasswordUsingSeed(byte[] paswd) throws Exception
	{
		SecretKeySpec key = new SecretKeySpec(Base64.decodeBase64(ENCODE_SEED_KEY), AES_ALGO);
		ecipher = Cipher.getInstance(AES_ALGO);
		ecipher.init(Cipher.ENCRYPT_MODE, key);
		return ecipher.doFinal(paswd);
	}
}
