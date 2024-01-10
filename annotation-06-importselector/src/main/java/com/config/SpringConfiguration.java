package com.config;

import com.component.CustomerImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author wangshenbing
 */
@Configuration
@ComponentScan("com.test")
@Import(CustomerImportSelector.class)
public class SpringConfiguration {
}