package webApp.company.trello.user.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import webApp.company.trello.user.controller.AuthController;
import webApp.company.trello.user.dto.UserAuthResponse;
import webApp.company.trello.user.dto.UserAuthenticatedRequest;
import webApp.company.trello.user.dto.UserRegistrationRequest;
import webApp.company.trello.user.service.UserServiceAuth;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final UserServiceAuth userService;

    @Override
    public UserAuthResponse registerUser(UserRegistrationRequest registrationRequest) {
        return userService.registerUser(registrationRequest);
    }

    @Override
    public UserAuthResponse authenticated(UserAuthenticatedRequest userAuthenticatedRequest) {
        return userService.authenticated(userAuthenticatedRequest);
    }
}
