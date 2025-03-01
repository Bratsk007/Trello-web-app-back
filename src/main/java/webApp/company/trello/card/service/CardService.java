package webApp.company.trello.card.service;

import webApp.company.trello.card.dto.CardMoveRequest;
import webApp.company.trello.card.dto.CardRequest;
import webApp.company.trello.card.dto.CardResponse;
import webApp.company.trello.card.model.Card;

public interface CardService {

    Card getCardById(Integer cardId);

    void createCard(Integer listId, CardRequest cardRequest);

    void updateCard(Integer cardId, CardRequest cardRequest);

    void moveCard(Integer cardId, CardMoveRequest cardMoveRequest);

    void deleteCardById(Integer cardId);

    void saveCard(Card card);
}
