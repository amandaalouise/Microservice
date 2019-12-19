package amandaalouise.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ConfigurationProperties
 */
@ConfigurationProperties(prefix = "amandaalouise")
public class ConfigProperties {

    private Boolean enableNotification;

    public Boolean isEnableNotification() {
        return this.enableNotification;
    }

    public Boolean getEnableNotification() {
        return this.enableNotification;
    }

    public void setEnableNotification(Boolean enableNotification) {
        this.enableNotification = enableNotification;
    }

}