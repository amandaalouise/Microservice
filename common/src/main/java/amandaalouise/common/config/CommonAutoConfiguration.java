package amandaalouise.common.config;

import common.src.main.java.amandaalouise.common.exception.CustomErrorDecoder;
import common.src.main.java.amandaalouise.common.exception.GlobalExceptionHandler;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import feign.codec.ErrorDecoder;

/**
 * CommonAutoConfiguration
 */
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(ConfigProperties.class)
@ComponentScan("amandaalouise.common.utils")
@Import(GlobalExceptionHandler.class)
public class CommonAutoConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}