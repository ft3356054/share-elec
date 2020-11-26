package com.sgcc.uap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

import com.alibaba.edas.configcenter.config.ConfigService;

import java.io.StringReader;
import java.util.*;

/**
 * Created by yizhan on 2018/3/26.
 */

public class EDASPropertySourceLocator implements PropertySourceLocator {

    private static final Logger LOGGER = LoggerFactory.getLogger(EDASPropertySourceLocator.class);

    private static final String DIAMOND_PROPERTY_SOURCE_NAME = "edas-config";

    @Override
    public PropertySource<?> locate(Environment environment) {
        CompositePropertySource compositePropertySource = new CompositePropertySource(DIAMOND_PROPERTY_SOURCE_NAME);
        return compositePropertySource;
    }

    private void loadConfiguration(CompositePropertySource compositePropertySource, Environment environment, String dataId, String groupId) {
        try {
            String data = ConfigService.getConfig(dataId, groupId, 3000L);
            Properties properties = new Properties();
            properties.load(new StringReader(data));
            EDASConfigPropertySource propertySource = new EDASConfigPropertySource(dataId, toMap(properties), new Date());
            compositePropertySource.addFirstPropertySource(propertySource);
        } catch (Exception e) {
            LOGGER.error("load edas config error,dataId={},groupId={},e", dataId, groupId, e);
        }

    }

    @SuppressWarnings("unchecked")
	private Map<String, Object> toMap(Properties properties) {
        Map<String, Object> result = new HashMap<>();
        Enumeration<String> keys = (Enumeration<String>) properties.propertyNames();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            Object value = properties.getProperty(key);
            if (value != null) {
                result.put(key, ((String) value).trim());
            } else {
                result.put(key, null);
            }
        }
        return result;
    }
}
