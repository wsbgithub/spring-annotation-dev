package com.wangsb.config.log;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author wangshenbing
 * @date 2024/01/08
 **/
@Component
public class LogUtil {
    public void log() {
        System.out.println("LogUtil===>log");
    }
}