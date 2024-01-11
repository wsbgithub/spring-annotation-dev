package com.config;

import com.wangsb.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * spring的配置类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Configuration
@PropertySource(value="classpath:jdbc.yml",factory = YamlPropertySourceFactory.class)
@Import(JdbcConfig.class)
public class SpringConfiguration {
}
