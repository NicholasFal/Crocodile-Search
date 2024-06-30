package org.jointheleague.api.crocodile.Crocodile.Search.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocConfig {
   @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
       return new OpenAPI().info(new Info());
   }
}
