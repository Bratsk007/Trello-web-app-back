package webApp.company.trello.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Schema(description = "Ответ на запрос регистрации/аутентификации")
public class UserAuthResponse {
    @Schema(description = "Результат выполнения запроса")
    private String message;
    @Schema(description = "id, которое возвращается при успешном выполнении операции")
    private Integer userId;
}
