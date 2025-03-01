package webApp.company.trello.card.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import webApp.company.trello.card.controller.CardController;
import webApp.company.trello.card.model.Card;
import webApp.company.trello.card.service.CardService;

@Controller
@RequiredArgsConstructor
public class CardControllerImpl implements CardController {
    private final CardService cardService;


    @Override
    public String getCardById(Model model, Integer cardId) {

        Card card = cardService.getCardById(cardId);

        model.addAttribute("card", card);
        return "card-page";

    }

//    @Override
//    public void createCard(Integer listId, CardRequest cardRequest) {
//        cardService.createCard(listId, cardRequest);
//    }
//
//    @Override
//    public void updateCard(Integer cardId, CardRequest cardRequest) {
//        cardService.updateCard(cardId, cardRequest);
//    }
//
//    @Override
//    public void moveCard(Integer cardId, CardMoveRequest cardMoveRequest) {
//        cardService.moveCard(cardId, cardMoveRequest);
//    }
//
//    @Override
//    public void deleteCard(Integer cardId) {
//        cardService.deleteCardById(cardId);
//    }
}
