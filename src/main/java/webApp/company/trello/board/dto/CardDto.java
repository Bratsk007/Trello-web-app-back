package webApp.company.trello.board.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CardDto {
    private Integer id;
    private String title;
    private String description;
}
