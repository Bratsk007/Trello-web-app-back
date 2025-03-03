package webApp.company.trello.card.service;

import webApp.company.trello.card.dto.CardMoveRequest;
import webApp.company.trello.card.dto.CardRequest;
import webApp.company.trello.card.dto.CardResponse;
import webApp.company.trello.card.model.Card;

public interface CardService {

    /**
     * Возвращает карточку по её идентификатору.
     *
     * @param cardId Идентификатор карточки, которую необходимо получить.
     * @return Объект {@link Card}, представляющий запрошенную карточку.
     */
    Card getCardById(Integer cardId);

    /**
     * Создает новую карточку в указанном списке.
     *
     * @param listId Идентификатор списка, в который необходимо добавить карточку.
     * @param cardRequest Объект {@link CardRequest}, содержащий данные для создания карточки.
     */
    void createCard(Integer listId, CardRequest cardRequest);

    /**
     * Обновляет существующую карточку по её идентификатору.
     *
     * @param cardId Идентификатор карточки, которую необходимо обновить.
     * @param cardRequest Объект {@link CardRequest}, содержащий новые данные для обновления карточки.
     */
    void updateCard(Integer cardId, CardRequest cardRequest);

    /**
     * Перемещает карточку в другой список или изменяет её позицию в текущем списке.
     *
     * @param cardId Идентификатор карточки, которую необходимо переместить.
     * @param cardMoveRequest Объект {@link CardMoveRequest}, содержащий данные для перемещения карточки.
     */
    void moveCard(Integer cardId, CardMoveRequest cardMoveRequest);

    /**
     * Удаляет карточку по её идентификатору.
     *
     * @param cardId Идентификатор карточки, которую необходимо удалить.
     */
    void deleteCardById(Integer cardId);

    /**
     * Сохраняет карточку в системе.
     *
     * @param card Объект {@link Card}, представляющий карточку, которую необходимо сохранить.
     */
    void saveCard(Card card);
}
