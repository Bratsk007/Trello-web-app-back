package webApp.company.trello.card.service;

import webApp.company.trello.card.dto.CardMoveRequest;
import webApp.company.trello.card.dto.CardRequest;
import webApp.company.trello.card.dto.CardResponse;

public interface CardService {

    CardResponse getCardById(Integer cardId);

    void createCard(Integer listId, CardRequest cardRequest);

    void updateCard(Integer cardId, CardRequest cardRequest);

    void moveCard(Integer cardId, CardMoveRequest cardMoveRequest);

    void deleteCardById(Integer cardId);
}
