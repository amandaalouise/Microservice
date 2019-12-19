package amandaalouise.common.config;

import amandaalouise.common.notification.NotificationSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * NotificationAutoConfiguration
 */
@Configuration
@ConditionalOnProperty(name = "amandaalouise.enableNotification", havingValue = "true")
@ComponentScan("amandaalouise.common.notification")
@PropertySource("classpath:application.properties")
@EnableBinding(NotificationSource.class)
public class NotificationAutoConfiguration {

}