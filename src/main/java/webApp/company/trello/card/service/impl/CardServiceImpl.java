package webApp.company.trello.card.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webApp.company.trello.card.dao.CardDao;
import webApp.company.trello.card.dto.CardMoveRequest;
import webApp.company.trello.card.dto.CardRequest;
import webApp.company.trello.card.dto.CardResponse;
import webApp.company.trello.card.model.Card;
import webApp.company.trello.card.service.CardService;
import webApp.company.trello.list.dao.CatalogDao;
import webApp.company.trello.list.model.Catalog;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardDao cardDao;
    private final CatalogDao catalogDao;

    @Override
    public Card getCardById(Integer cardId) {

        Optional<Card> cardOptional = cardDao.findById(cardId);

        if (cardOptional.isEmpty()) {
            throw new RuntimeException("Card с id " + cardId + " не найден");
        }


        return cardOptional.get();
    }

    @Override
    public void createCard(Integer listId, CardRequest cardRequest) {
        Optional<Catalog> optionalCatalog = catalogDao.findById(listId);

        if (optionalCatalog.isPresent()) {
            Catalog catalog = optionalCatalog.get();

            Card card = Card.builder()
                    .title(cardRequest.getTitle())
                    .description(cardRequest.getDescription())
                    .catalog(catalog)
                    .build();

            catalog.getCardList().add(card);

            cardDao.save(card);
        }


    }

    @Override
    public void updateCard(Integer cardId, CardRequest cardRequest) {
        Optional<Card> optionalCard = cardDao.findById(cardId);

        if (optionalCard.isPresent()) {
            Card card = optionalCard.get();
            card.setTitle(cardRequest.getTitle());
            card.setDescription(cardRequest.getDescription());

            cardDao.save(card);
        }
    }

    @Override
    public void moveCard(Integer cardId, CardMoveRequest cardMoveRequest) {
        Optional<Card> optionalCard = cardDao.findById(cardId);

        if (optionalCard.isPresent()) {
            Optional<Catalog> optionalCatalog = catalogDao.findById(cardMoveRequest.getNewListId());

            if (optionalCatalog.isPresent()) {
                Card card = optionalCard.get();

                Catalog newCatalog = optionalCatalog.get();

                card.getCatalog().getCardList().remove(card);

                card.setCatalog(newCatalog);

                cardDao.save(card);
            }
        }
    }

    @Override
    public void deleteCardById(Integer cardId) {
        Optional<Card> optionalCard = cardDao.findById(cardId);

        if (optionalCard.isPresent()) {
            Card card = optionalCard.get();

            cardDao.delete(card);
        }
    }

    @Override
    public void saveCard(Card card) {
        cardDao.save(card);
    }
}
