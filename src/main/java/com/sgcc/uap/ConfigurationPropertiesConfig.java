package com.sgcc.uap;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yizhan on 2018/3/26.
 * EDAS配置类
 */
@ConfigurationProperties(prefix = "prefix")
public class ConfigurationPropertiesConfig {

    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
