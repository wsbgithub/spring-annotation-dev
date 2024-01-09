package com.wangsb.service.impl;

import com.wangsb.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wangshenbing
 * @date 2024/01/08
 **/
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void delete() {
        System.out.println("UserServiceImpl ===> delete user");
    }
}