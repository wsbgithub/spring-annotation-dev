package com.wangsb;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @author wangshenbing
 * @date 2024/01/11
 **/
public class YamlPropertySourceFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        //1.创建yaml文件解析工厂
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        //2.设置要解析的资源内容
        factoryBean.setResources(resource.getResource());
        //3.把资源解析成properties文件
        Properties properties = factoryBean.getObject();
        //4.返回PropertySource对象
        return (name != null ? new PropertiesPropertySource(name, properties)
                : new PropertiesPropertySource(resource.getResource().getFilename(), properties));

    }
}