package webApp.company.trello.board.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class CatalogDto {
    private Integer id;
    private String title;
    private List<CardDto> cardDtoList;


}
