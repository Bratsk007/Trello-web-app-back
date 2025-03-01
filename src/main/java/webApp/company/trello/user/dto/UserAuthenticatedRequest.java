package webApp.company.trello.user.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Запрос для аутентификации пользователя")
@Builder
public class UserAuthenticatedRequest {
    @Schema(description = "Почта пользователя")
    private String email;
    @Schema(description = "Пароль пользователя")
    private String password;
}
