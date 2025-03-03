package webApp.company.trello.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import webApp.company.trello.user.dto.UserRegistrationRequest;
import webApp.company.trello.user.dto.UserAuthResponse;

@Tag(name = "Аутентификация/регистрация пользователей", description = "API для аутентификации/регистрации пользователей")
@RequestMapping("/api/v1/auth")
public interface AuthController {

    /**
     * Регистрация пользователя
     *
     * @param username имя пользователя
     * @param email    почта пользователя
     * @param password пароль
     * @return редирект на страницу с вводом логина/пароля или же опять на страницу регистрации, если пользователь ввёл некорректные данные для регистрации
     */
    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/register")
    String registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password);

    /**
     * Аутентификация пользователя по username и password
     *
     * @param email    почта пользователя
     * @param password пароль пользователя
     * @return редирект на домашнюю страницу или же на страницу с вводом логина и пароля, если данные от аккаунта не прошли аутентификацию
     */
    @Operation(summary = "Аутентификация пользователя")
    @PostMapping("/login")
    String authenticated(@RequestParam String email, @RequestParam String password, HttpSession session);

    /**
     * Завершает сеанс текущего пользователя (логаут).
     *
     * @param session Сессия HTTP, которая будет очищена для завершения сеанса пользователя.
     * @return Строка, представляющая результат операции (например, перенаправление на страницу входа или главную страницу).
     * @see HttpSession
     */
    @Operation(summary = "Logout пользователя")
    @PostMapping("/logout")
    String logout(HttpSession session);

}
