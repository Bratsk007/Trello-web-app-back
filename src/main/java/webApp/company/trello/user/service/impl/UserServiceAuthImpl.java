package webApp.company.trello.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webApp.company.trello.user.dao.UserDao;
import webApp.company.trello.user.dto.UserAuthResponse;
import webApp.company.trello.user.dto.UserAuthenticatedRequest;
import webApp.company.trello.user.dto.UserRegistrationRequest;
import webApp.company.trello.user.model.User;
import webApp.company.trello.user.service.UserServiceAuth;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceAuthImpl implements UserServiceAuth {
    private final UserDao userDao;


    @Override
    public UserAuthResponse registerUser(UserRegistrationRequest registrationRequest) {

        Optional<User> optionalUser = userDao.findByEmail(registrationRequest.getEmail());

        if (optionalUser.isPresent()) {
            return UserAuthResponse.builder()
                    .message("Пользователь с таким логином уже существует")
                    .userId(null)
                    .build();
        } else {
            User user = User.builder()
                    .email(registrationRequest.getEmail())
                    .password(registrationRequest.getPassword())
                    .username(registrationRequest.getUsername())
                    .build();

            return UserAuthResponse.builder()
                    .message("Пользователь успешно зарегистрирован")
                    .userId(userDao.save(user).getId())
                    .build();

        }

    }

    @Override
    public UserAuthResponse authenticated(UserAuthenticatedRequest userAuthenticatedRequest) {
        Optional<User> optionalUser = userDao.findByEmail(userAuthenticatedRequest.getEmail());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (user.getPassword().equals(userAuthenticatedRequest.getPassword())) {
                return UserAuthResponse.builder()
                        .message("Вход выполнен успешно")
                        .userId(user.getId())
                        .build();
            } else {
                return UserAuthResponse.builder()
                        .message("Неверный логин или пароль")
                        .userId(null)
                        .build();
            }
        } else {
            return UserAuthResponse.builder()
                    .message("Неверный логин или пароль")
                    .userId(null)
                    .build();
        }
    }


}
