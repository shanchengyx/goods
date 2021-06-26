package com.gyx.dao.impl;

import com.gyx.dao.UserDAO;
import com.gyx.pojo.User;
import org.junit.jupiter.api.Test;

class UserDAOTest {
    private UserDAO dao = new UserDAOImpl();

    @Test
    void queryUserByUsername() {
        User user = dao.queryUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    void queryUserByUsernameAndPassword() {
        User user = dao.queryUserByUsernameAndPassword("admin", "admin");
        System.out.println(user);
    }

    @Test
    void saveUser() {
        int count = dao.saveUser(new User(0, "yoyo", "123456", "yoyo@ra.com"));
        System.out.println(count);
    }

    @Test
    void queryAuthorityById() {
        Integer authority = dao.queryAuthorityById(29);
        System.out.println(authority);
    }
}