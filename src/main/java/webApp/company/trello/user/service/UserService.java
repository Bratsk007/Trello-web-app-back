package webApp.company.trello.user.service;

import webApp.company.trello.user.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(Integer id);
}
