package br.com.compasso.brazilianStatesAPI.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Configuration that allows the access to Swagger Editor
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("https://editor.swagger.io")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
