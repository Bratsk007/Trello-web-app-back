package webApp.company.trello.user.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import webApp.company.trello.user.dto.UserAuthenticatedRequest;
import webApp.company.trello.user.dto.UserRegistrationRequest;
import webApp.company.trello.user.dto.UserAuthResponse;

@Tag(name = "Аутентификация/регистрация пользователей", description = "API для аутентификации/регистрации пользователей")
@RequestMapping("/api/auth")
public interface AuthController {

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/register")
    UserAuthResponse registerUser(@RequestBody UserRegistrationRequest registrationRequest);

    @Operation(summary = "Аутентификация пользователя")
    @PostMapping("/login")
    UserAuthResponse authenticated(@RequestBody UserAuthenticatedRequest userAuthenticatedRequest);

}
