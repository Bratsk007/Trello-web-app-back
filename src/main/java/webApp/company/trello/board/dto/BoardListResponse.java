package webApp.company.trello.board.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Ответ на получение запроса всех досок пользователя")
@Builder
public class BoardListResponse {
    @Schema(description = "id доски")
    private Integer id;
    @Schema(description = "Заголовок доски")
    private String title;
    @Schema(description = "Описание доски")
    private String description;
}
