package webApp.company.trello.list.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webApp.company.trello.list.dto.CatalogRequest;

@Tag(name = "Сущность лист", description = "API для получения/удаления/обновления списков")
@RequestMapping("/api/lists")
public interface CatalogController {

    @PostMapping("/{boardId}")
    void saveList(@PathVariable Integer boardId, CatalogRequest catalogRequest);

    @PutMapping("/{catalogId}")
    void updateList(@PathVariable Integer catalogId, CatalogRequest catalogRequest);
}
