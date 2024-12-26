package webApp.company.trello.user.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Schema(description = "Запрос для регистрации пользователя")
public class UserRegistrationRequest {
    @Schema(description = "Имя пользователя")
    private String username;
    @Schema(description = "Почта пользователя")
    private String email;
    @Schema(description = "Пароль пользователя")
    private String password;
}
