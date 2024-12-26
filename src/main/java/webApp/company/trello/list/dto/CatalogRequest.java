package webApp.company.trello.list.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Запрос на создание списка")
@Builder
public class CatalogRequest {
    private String title;
}
