package com.wangsb.service.impl;

import com.wangsb.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author wangshenbing
 * @date 2024/01/08
 **/
@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public void save() {
        System.out.println("执行了 AccountServiceImpl ==> save");
    }
}