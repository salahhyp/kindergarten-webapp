package com.daaw.project.SecurityConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {


    @Value("${ipinfo.api.token}")
    private String apiToken;

    public String getApiToken() {
        return apiToken;
    }

}
