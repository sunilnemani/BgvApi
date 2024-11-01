/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.fsuite.BgvApi.dto.SettingsDTO;

@Configuration
public class SecurityConfig
{

	@Bean
    static PasswordEncoder passwordEncoder() 
	{
        return new BCryptPasswordEncoder();
    }

    @SuppressWarnings("removal")
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
    {
        http.csrf().disable().authorizeHttpRequests((authorize) -> {
            authorize.anyRequest().authenticated();
        }).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService(@Autowired SettingsDTO settingsDTO) 
    {
        UserDetails admin = User.builder().username(settingsDTO.getAuthUserName()).password(passwordEncoder().encode(settingsDTO.getAuthPassword())).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(admin);
    }
}
