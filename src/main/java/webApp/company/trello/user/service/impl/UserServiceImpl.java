package webApp.company.trello.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webApp.company.trello.user.dao.UserDao;
import webApp.company.trello.user.model.User;
import webApp.company.trello.user.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Optional<User> getUserById(Integer id) {
        return userDao.findById(id);
    }
}
