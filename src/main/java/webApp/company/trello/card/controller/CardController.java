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

    /**
     * Возвращает страницу с подробной информацией о карточке по её идентификатору.
     *
     * @param model Модель для передачи данных в представление.
     * @param cardId Идентификатор карточки, которую необходимо отобразить.
     * @return Имя представления для отображения карточки.
     */
    @GetMapping("/{cardId}")
    String getCardById(Model model, @PathVariable Integer cardId);

    /**
     * Удаляет карточку по её идентификатору.
     *
     * @param cardId Идентификатор карточки, которую необходимо удалить.
     * @return Ответ {@link ResponseEntity} с пустым телом и статусом HTTP.
     */
    @PostMapping("/{cardId}/delete-card")
    ResponseEntity<Void> deleteCardById(@PathVariable Integer cardId);

    /**
     * Возвращает страницу редактирования карточки по её идентификатору.
     *
     * @param cardId Идентификатор карточки, которую необходимо отредактировать.
     * @param model Модель для передачи данных в представление.
     * @return Имя представления для страницы редактирования карточки.
     */
    @GetMapping("/{cardId}/get-edit-page")
    String getEditPage(@PathVariable Integer cardId, Model model);

    /**
     * Редактирует карточку по её идентификатору, обновляя заголовок и описание.
     *
     * @param cardId Идентификатор карточки, которую необходимо отредактировать.
     * @param title Новый заголовок карточки.
     * @param description Новое описание карточки.
     * @return Строка, представляющая результат операции (например, перенаправление или имя представления).
     */
    @PostMapping("/{cardId}/edit")
    String editCard(@PathVariable Integer cardId, @RequestParam String title, @RequestParam String description);

}
