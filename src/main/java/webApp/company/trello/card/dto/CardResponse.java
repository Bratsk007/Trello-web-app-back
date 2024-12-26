package webApp.company.trello.card.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Ответ на запрос получения карточки")
@Builder
public class CardResponse {
    private String title;
    private String description;
}
