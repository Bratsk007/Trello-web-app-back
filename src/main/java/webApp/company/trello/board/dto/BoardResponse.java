package webApp.company.trello.board.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import webApp.company.trello.list.model.Catalog;

import java.util.List;

@Data
@AllArgsConstructor
@Schema(description = "Ответ на получение запроса содержимого доски")
@Builder
public class BoardResponse {
    private List<Catalog> catalogList;

}
