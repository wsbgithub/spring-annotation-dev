package com.wangsb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author wangshenbing
 * @date 2024/01/10
 **/
@Configuration
@Import(JdbcConfig.class)
public class SpringImportConfig {
}