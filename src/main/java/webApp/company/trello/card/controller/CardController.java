package webApp.company.trello.card.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import webApp.company.trello.card.dto.CardMoveRequest;
import webApp.company.trello.card.dto.CardRequest;
import webApp.company.trello.card.dto.CardResponse;

@Tag(name = "Сущность карточка", description = "API для получения/удаления/обновления карточек")
@RequestMapping("/api/cards")
public interface CardController {

    @GetMapping("/{cardId}")
    CardResponse getCardById(@PathVariable Integer cardId);

    @PostMapping("/{listId}")
    void createCard(@PathVariable Integer listId, CardRequest cardRequest);

    @PutMapping("/{cardId}")
    void updateCard(@PathVariable Integer cardId, CardRequest cardRequest);

    @PostMapping("/{cardId}/move")
    void moveCard(@PathVariable Integer cardId, CardMoveRequest cardMoveRequest);

    @DeleteMapping("/{cardId}")
    void deleteCard(@PathVariable Integer cardId);
}
