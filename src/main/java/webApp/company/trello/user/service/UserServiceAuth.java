package webApp.company.trello.user.service;

import webApp.company.trello.user.dto.UserAuthResponse;
import webApp.company.trello.user.dto.UserAuthenticatedRequest;
import webApp.company.trello.user.dto.UserRegistrationRequest;


public interface UserServiceAuth {
    UserAuthResponse registerUser(UserRegistrationRequest registrationRequest);

    UserAuthResponse authenticated(UserAuthenticatedRequest userAuthenticatedRequest);
}
