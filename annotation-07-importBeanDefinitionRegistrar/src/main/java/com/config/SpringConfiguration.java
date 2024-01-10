package com.config;

import com.registrar.CustomerImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * @author wangshenbing
 */
@Configuration
@ComponentScan("com.wangsb.service")
@Import(CustomerImportBeanDefinitionRegistrar.class)
public class SpringConfiguration {
}
