package webApp.company.trello.card.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import webApp.company.trello.card.controller.CardController;
import webApp.company.trello.card.dto.CardMoveRequest;
import webApp.company.trello.card.dto.CardRequest;
import webApp.company.trello.card.dto.CardResponse;
import webApp.company.trello.card.service.CardService;

@RestController
@RequiredArgsConstructor
public class CardControllerImpl implements CardController {
    private final CardService cardService;


    @Override
    public CardResponse getCardById(Integer cardId) {
        return cardService.getCardById(cardId);
    }

    @Override
    public void createCard(Integer listId, CardRequest cardRequest) {
        cardService.createCard(listId, cardRequest);
    }

    @Override
    public void updateCard(Integer cardId, CardRequest cardRequest) {
        cardService.updateCard(cardId, cardRequest);
    }

    @Override
    public void moveCard(Integer cardId, CardMoveRequest cardMoveRequest) {
        cardService.moveCard(cardId, cardMoveRequest);
    }

    @Override
    public void deleteCard(Integer cardId) {
        cardService.deleteCardById(cardId);
    }
}
