package webApp.company.trello.card.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Запрос на изменение карточки")
@Builder
public class CardMoveRequest {
    private Integer newListId;
}
