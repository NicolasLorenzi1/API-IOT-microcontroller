package com.tcc.iot_mc_api.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    public static final String[] ENDPOINT_AUTHENTICATION_NOT_REQUIRED = {
        "/api/sensor/cadastro"
    };
}
