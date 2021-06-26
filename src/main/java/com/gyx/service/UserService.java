package com.gyx.service;

import com.gyx.pojo.User;

public interface UserService {
    /**
     * 注册用户
     *
     * @param user
     */
    void register(User user);

    /**
     * 注册用户
     *
     * @param user
     * @return user
     */
    User login(User user);

    /**
     * 检查用户名是否存在
     *
     * @param username
     * @return
     */
    boolean existUsername(String username);

    /**
     * 查询用户是否使管理员
     *
     * @param id 用户id
     * @return
     */
    boolean isManager(int id);
}
