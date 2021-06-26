package com.gyx.service.impl;

import com.gyx.dao.UserDAO;
import com.gyx.dao.impl.UserDAOImpl;
import com.gyx.pojo.User;
import com.gyx.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void register(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        return (userDAO.queryUserByUsername(username) != null);
    }

    @Override
    public boolean isManager(int id) {
        Integer authority = userDAO.queryAuthorityById(id);
        if (authority != null && authority == 1) {
            return true;
        } else {
            return false;
        }
    }
}
