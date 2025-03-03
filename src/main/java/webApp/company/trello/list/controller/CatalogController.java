package webApp.company.trello.list.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webApp.company.trello.list.dto.CatalogRequest;

@Tag(name = "Сущность лист", description = "API для получения/удаления/обновления списков")
@RequestMapping("/api/v1/catalog")
public interface CatalogController {

    /**
     * Возвращает страницу для добавления новой карточки в указанный каталог.
     *
     * @param catalogId Идентификатор каталога, в который будет добавлена карточка.
     * @param model Модель для передачи данных в представление.
     * @return Имя представления для страницы добавления карточки.
     */
    @GetMapping("/{catalogId}/add-card-page")
    String getAddCardPage(@PathVariable Integer catalogId, Model model);

    /**
     * Добавляет новую карточку в указанный каталог.
     *
     * @param catalogId Идентификатор каталога, в который добавляется карточка.
     * @param cardTitle Заголовок новой карточки.
     * @param cardDescription Описание новой карточки.
     * @return Строка, представляющая результат операции (например, перенаправление или имя представления).
     */
    @PostMapping("/{catalogId}/add-card")
    String addCardToCatalog(@PathVariable Integer catalogId,
                            @RequestParam String cardTitle,
                            @RequestParam String cardDescription);

    /**
     * Возвращает страницу для добавления нового каталога в указанную доску.
     *
     * @param boardId Идентификатор доски, в которую будет добавлен каталог.
     * @param model Модель для передачи данных в представление.
     * @return Имя представления для страницы добавления каталога.
     */
    @GetMapping("/{boardId}/add-catalog-page")
    String getAddCatalogPage(@PathVariable Integer boardId, Model model);

    /**
     * Создает новый каталог в указанной доске.
     *
     * @param boardId Идентификатор доски, в которую добавляется каталог.
     * @param title Заголовок нового каталога.
     * @return Строка, представляющая результат операции (например, перенаправление или имя представления).
     */
    @PostMapping("/{boardId}/create-catalog")
    String createCatalog(@PathVariable Integer boardId, @RequestParam String title);

    /**
     * Удаляет каталог по его идентификатору.
     *
     * @param catalogId Идентификатор каталога, который необходимо удалить.
     * @return Ответ {@link ResponseEntity} с пустым телом и статусом HTTP.
     */
    @PostMapping("/{catalogId}/delete-catalog")
    ResponseEntity<Void> deleteCatalog(@PathVariable Integer catalogId);

    /**
     * Возвращает страницу редактирования каталога по его идентификатору.
     *
     * @param catalogId Идентификатор каталога, который необходимо отредактировать.
     * @param model Модель для передачи данных в представление.
     * @return Имя представления для страницы редактирования каталога.
     */
    @GetMapping("/{catalogId}/get-edit-page")
    String getEditPage(@PathVariable Integer catalogId, Model model);

    /**
     * Редактирует каталог по его идентификатору, обновляя заголовок.
     *
     * @param catalogId Идентификатор каталога, который необходимо отредактировать.
     * @param title Новый заголовок каталога.
     * @return Строка, представляющая результат операции (например, перенаправление или имя представления).
     */
    @PostMapping("/{catalogId}/edit")
    String editCatalog(@PathVariable Integer catalogId, @RequestParam String title);
}
