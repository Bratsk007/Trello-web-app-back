package webApp.company.trello.list.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webApp.company.trello.list.dto.CatalogRequest;

@Tag(name = "Сущность лист", description = "API для получения/удаления/обновления списков")
@RequestMapping("/api/v1/catalog")
public interface CatalogController {

//    @PostMapping("/{boardId}")
//    void saveList(@PathVariable Integer boardId, CatalogRequest catalogRequest);
//
//    @PutMapping("/{catalogId}")
//    void updateList(@PathVariable Integer catalogId, CatalogRequest catalogRequest);
//
//    @DeleteMapping("/{listId}")
//    void deleteList(@PathVariable Integer listId);

    @GetMapping("/{catalogId}/add-card-page")
    String getAddCardPage(@PathVariable Integer catalogId, Model model);

    @PostMapping("/{catalogId}/add-card")
    String addCardToCatalog(@PathVariable Integer catalogId,
                            @RequestParam String cardTitle,
                            @RequestParam String cardDescription);

    @GetMapping("/{boardId}/add-catalog-page")
    String getAddCatalogPage(@PathVariable Integer boardId, Model model);


    @PostMapping("/{boardId}/create-catalog")
    String createCatalog(@PathVariable Integer boardId, @RequestParam String title);
}
