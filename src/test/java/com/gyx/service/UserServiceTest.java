package com.gyx.service;

import com.gyx.pojo.User;
import com.gyx.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;


class UserServiceTest {
    private UserService service = new UserServiceImpl();

    @Test
    void regist() {
        service.register(new User(0, "may", "mama", "mama@ra.com"));
    }

    @Test
    void login() {
        User user = service.login(new User(0, "yoydsao", "123456", null));
        System.out.println(user);
    }

    @Test
    void existUsername() {
        boolean isExist = service.existUsername("yotsuba");
        System.out.println(isExist);
    }

    @Test
    void isManager() {
        boolean isManager = service.isManager(24);
        System.out.println(isManager);
    }
}