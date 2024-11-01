///*
//*
//*N Sunil 
//*
//*/
//
//package com.fsuite.BgvApi.db;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.security.Security;
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.codec.binary.Base64;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//
//import jakarta.persistence.EntityManagerFactory;
//
//@Configuration
//public class ActPersistenceContext
//{
//
//
//
//	// UAT Integra C##_USER1 identified by 1234
//	static
//	{
//		Security.addProvider(new BouncyCastleProvider());
//	}
//	
//	private static final String ACT_DB_PROPERTIES="act_db.properties";
//
//	public static final String DRIVER_CLASS = "driverClass";
//	public static final String JDBC_URL = "jdbcUrl";
//	public static final String USER = "user";
//	public static final String PASSWORD = "password";
//	public static final String MIN_POOL_SIZE = "minPoolSize";
//	public static final String MAX_POOL_SIZE = "maxPoolSize";
//	public static final String MAX_IDLE_TIME = "maxIdleTime";
//	public static final String MAX_STATEMENTS = "maxStatements";
//	public static final String IDLE_CONNECTION_TEST_PERIOD = "idleConnectionTestPeriod";
//	public static final String PREFERRED_TEST_QUERY = "preferredTestQuery";
//	public static final String ACQUIRE_RETRY_ATTEMPTS = "acquireRetryAttempts";
//	public static final String ACQUIRE_RETRY_DELAY = "acquireRetryDelay";
//
//	public static final String DIALECT = "hibernate.dialect";
//	public static final String HBM_2_DDL = "hibernate.hbm2ddl.auto";
//	public static final String SHOW_SQL = "hibernate.show_sql";
//	public static final String FORMAT_SQL = "hibernate.format_sql";
//
//	public static final String DATA_SOURCE_PREFIX = "data_source_";
//	public static final String DECRYPT_DATA_SOURCE_PREFIX = "decrypt_data_source_";
//
//	@Bean(destroyMethod = "close")
//	@Qualifier("actDataSource")
//	DataSource dataSource(Environment env) throws Exception
//	{
//		ComboPooledDataSource dataSource = null;
//		dataSource = new ComboPooledDataSource();
//		Properties properties = loadProperties(ACT_DB_PROPERTIES);
//		Properties dataSourceProperties = getDataSourceProperties(properties);
//		for (String property : dataSourceProperties.stringPropertyNames())
//		{
//			BeanUtils.setProperty(dataSource, property, dataSourceProperties.get(property));
//		}
//		dataSource.setProperties(dataSourceProperties);
//		return dataSource;
//	}
//
//
//	private Properties getDataSourceProperties(Properties properties) throws Exception
//	{
//
//		Properties validatedProperties = null;
//		if (properties != null)
//		{
//			validatedProperties = new Properties();
//			String dataSourceKey = null;
//			String dataSourceValue = null;
//			for (String key : properties.stringPropertyNames())
//			{
//				if (key.startsWith(DECRYPT_DATA_SOURCE_PREFIX))
//				{
//					dataSourceKey = key.substring(DECRYPT_DATA_SOURCE_PREFIX.length());
//					dataSourceValue = new String(InterPersistenceContext.decryptPasswordUsingSeed(Base64.decodeBase64(properties.getProperty(key).trim())));
//					validatedProperties.put(dataSourceKey, dataSourceValue);
//				}
//				else if (key.startsWith(DATA_SOURCE_PREFIX))
//				{
//					dataSourceKey = key.substring(DATA_SOURCE_PREFIX.length());
//					dataSourceValue = properties.getProperty(key);
//					validatedProperties.put(dataSourceKey, dataSourceValue);
//				}
//
//			}
//		}
//		return validatedProperties;
//	}
//	
//	private Properties loadProperties(String fileName) throws IOException
//	{
//		Properties properties = new Properties();
//		InputStream in = null;
//		try
//		{
//			in = Thread.currentThread().getContextClassLoader().getResourceAsStream(ACT_DB_PROPERTIES);
//			//in = new FileInputStream(new File(fileName));
//			properties.load(in);
//		}
//		finally
//		{
//			if (in != null)
//			{
//				try
//				{
//					in.close();
//				}
//				catch (Exception ex)
//				{
//				}
//			}
//		}
//		return properties;
//	}
//
//	@Bean
//	@Qualifier("actEntityManagerFactory")
//	LocalContainerEntityManagerFactoryBean entityManagerFactory(@Autowired @Qualifier("actDataSource") DataSource dataSource) throws Exception
//	{
//		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//		entityManagerFactoryBean.setPersistenceUnitName("actBgvEntityManager");
//		Properties properties = loadProperties(ACT_DB_PROPERTIES);
//		entityManagerFactoryBean.setDataSource(dataSource);
//		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//		entityManagerFactoryBean.setPackagesToScan("com.fsuite.BgvApi.act.models");
//		Properties jpaProperties = new Properties();
//		properties = getDataSourceProperties(properties);
//		jpaProperties.put(DIALECT, properties.getProperty(DIALECT));
//		jpaProperties.put(HBM_2_DDL, properties.getProperty(HBM_2_DDL));
//		jpaProperties.put(SHOW_SQL, Boolean.parseBoolean(properties.getProperty(SHOW_SQL)));
//		jpaProperties.put(FORMAT_SQL, Boolean.parseBoolean(properties.getProperty(FORMAT_SQL)));
//		entityManagerFactoryBean.setJpaProperties(jpaProperties);
//		return entityManagerFactoryBean;
//	}
//
//	@Bean
//	@Qualifier("actTransactionManager")
//	JpaTransactionManager transactionManager(@Autowired @Qualifier("actEntityManagerFactory") EntityManagerFactory entityManagerFactory)
//	{
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFactory);
//		return transactionManager;
//	}
//	
//}
