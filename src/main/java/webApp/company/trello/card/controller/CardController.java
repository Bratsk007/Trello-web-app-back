package webApp.company.trello.card.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webApp.company.trello.card.dto.CardMoveRequest;
import webApp.company.trello.card.dto.CardRequest;
import webApp.company.trello.card.dto.CardResponse;

@Tag(name = "Сущность карточка", description = "API для получения/удаления/обновления карточек")
@RequestMapping("/api/v1/card")
public interface CardController {

    @GetMapping("/{cardId}")
    String getCardById(Model model, @PathVariable Integer cardId);

    @PostMapping("/{cardId}/delete-card")
    ResponseEntity<Void> deleteCardById(@PathVariable Integer cardId);

    @GetMapping("/{cardId}/get-edit-page")
    String getEditPage(@PathVariable Integer cardId, Model model);

    @PostMapping("/{cardId}/edit")
    String editCard(@PathVariable Integer cardId, @RequestParam String title, @RequestParam String description);

//    @PostMapping("/{listId}")
//    void createCard(@PathVariable Integer listId, CardRequest cardRequest);
//
//    @PutMapping("/{cardId}")
//    void updateCard(@PathVariable Integer cardId, CardRequest cardRequest);
//
//    @PostMapping("/{cardId}/move")
//    void moveCard(@PathVariable Integer cardId, CardMoveRequest cardMoveRequest);
//
//    @DeleteMapping("/{cardId}")
//    void deleteCard(@PathVariable Integer cardId);
}
