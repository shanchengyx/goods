package com.gyx.dao.impl;

import com.gyx.dao.UserDAO;
import com.gyx.pojo.User;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id,username,password,email " +
                "from t_user where username = ?";
        User user = queryForOne(sql, username);
        return user;
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email " +
                "from t_user where username = ? and password = ?";
        User user = queryForOne(sql, username, password);
        return user;
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) " +
                "values(?,?,?)";
        int count = update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        return count;
    }

    @Override
    public Integer queryAuthorityById(int id) {
        String sql = "select authority " +
                "from t_manager m " +
                "join t_user u " +
                "on m.user_id = u.id " +
                "where u.id = ?";
        return (Integer) queryForSingleValue(sql, id);
    }
}
