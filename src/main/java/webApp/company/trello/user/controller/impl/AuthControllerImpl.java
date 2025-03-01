package webApp.company.trello.user.controller.impl;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import webApp.company.trello.user.controller.AuthController;
import webApp.company.trello.user.dto.UserAuthResponse;
import webApp.company.trello.user.dto.UserAuthenticatedRequest;
import webApp.company.trello.user.dto.UserRegistrationRequest;
import webApp.company.trello.user.model.User;
import webApp.company.trello.user.service.UserService;
import webApp.company.trello.user.service.UserServiceAuth;

import java.util.Objects;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final UserServiceAuth userServiceAuth;
    private final UserService userService;

    @Override
    public String registerUser(String username, String email, String password) {


        UserRegistrationRequest registrationRequest = UserRegistrationRequest.builder()
                .username(username)
                .email(email)
                .password(password)
                .build();

        UserAuthResponse userAuthResponse = userServiceAuth.registerUser(registrationRequest);

        if (Objects.isNull(userAuthResponse.getUserId())) {
            return "redirect:/register?error";
        }

        return "redirect:/";
    }

    @Override
    public String authenticated(String email, String password, HttpSession session) {

        UserAuthenticatedRequest authenticatedRequest = UserAuthenticatedRequest.builder()
                .email(email)
                .password(password)
                .build();

        UserAuthResponse userFromAuthService = userServiceAuth.authenticated(authenticatedRequest);

        // возвращаем пользователя на страничку ввода логина и пароля, сообщая ему об ошибке
        if (Objects.isNull(userFromAuthService.getUserId())) {
            return "redirect:/?error";
        }

        Optional<User> optionalUser = userService.getUserById(userFromAuthService.getUserId());

        // здесь можно быть уверенным, что пользователь такой существует
        User user = optionalUser.get();
        Hibernate.initialize(user.getBoards());

        session.setAttribute("user", user);
        return "redirect:/home-page";

    }

    @Override
    public String logout(HttpSession session) {

        session.removeAttribute("user");

        return "redirect:/";
    }
}
