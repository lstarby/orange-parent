package com.zzsong.study.orange.user.web.configure;

import com.zzsong.study.orange.common.constants.OrangeConstants;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.PropertySourcesLoader;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

/**
 * Created by zzsong on 2017/10/26.
 */
public class LoadAdditionalProperties implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    private ResourceLoader loader = new DefaultResourceLoader();

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        try {
            Resource resource = loader.getResource("classpath:" + OrangeConstants.DEFAULT_CONFIG_NAME);
            PropertySource<?> propertySource = new PropertySourcesLoader().load(resource);
            MutablePropertySources propertySources = applicationEnvironmentPreparedEvent.getEnvironment().getPropertySources();
            propertySources.addLast(propertySource);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
