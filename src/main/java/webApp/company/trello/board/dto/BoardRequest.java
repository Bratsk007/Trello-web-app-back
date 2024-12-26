package webApp.company.trello.board.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Запрос на создание доски")
public class BoardRequest {
    private String title;
    private String description;
}
