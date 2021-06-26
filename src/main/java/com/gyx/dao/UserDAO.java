package com.gyx.dao;

import com.gyx.pojo.User;

/**
 * UserDAO
 */
public interface UserDAO {
    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return 查询到的用户
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     *
     * @param username
     * @param password
     * @return 查询到的用户
     */
    User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户
     *
     * @param user
     * @return 影响的行数
     */
    int saveUser(User user);

    /**
     * 根据id查询是否用管理员权限
     *
     * @param id
     * @return
     */
    Integer queryAuthorityById(int id);
}
