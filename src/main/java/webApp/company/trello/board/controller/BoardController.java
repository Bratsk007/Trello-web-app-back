package webApp.company.trello.board.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Сущность доска", description = "API для получения/удаления/изменения доски")
@RequestMapping("/api/v1/board")
public interface BoardController {

    /**
     * Получить доску по id
     *
     * @param boardId id доски
     * @return редирект на страницу с содержимым доски
     */
    @GetMapping("/{boardId}")
    String getBoardById(Model model, @PathVariable Integer boardId);

    /**
     * Создает новую доску с указанным заголовком и описанием.
     *
     * @param title Заголовок доски.
     * @param description Описание доски.
     * @param httpSession Сессия HTTP, используемая для хранения данных пользователя.
     * @return Строка, представляющая результат операции (например, перенаправление или имя представления).
     */
    @PostMapping("/create")
    String createBoard(@RequestParam String title, @RequestParam String description, HttpSession httpSession);

    /**
     * Удаляет доску по её идентификатору.
     *
     * @param session Сессия HTTP, используемая для проверки прав доступа.
     * @param boardId Идентификатор доски, которую необходимо удалить.
     * @return Строка, представляющая результат операции (например, перенаправление или имя представления).
     */
    @PostMapping("/delete/{boardId}")
    String deleteBoard(HttpSession session, @PathVariable Integer boardId);

    /**
     * Возвращает страницу редактирования доски по её идентификатору.
     *
     * @param boardId Идентификатор доски, которую необходимо отредактировать.
     * @param model Модель для передачи данных в представление.
     * @return Имя представления для страницы редактирования доски.
     */
    @GetMapping("/{boardId}/get-edit-page")
    String getEditBoardPage(@PathVariable Integer boardId, Model model);

    /**
     * Редактирует существующую доску по её идентификатору.
     *
     * @param session Сессия HTTP, используемая для проверки прав доступа.
     * @param boardId Идентификатор доски, которую необходимо отредактировать.
     * @param title Новый заголовок доски.
     * @param description Новое описание доски.
     * @return Строка, представляющая результат операции (например, перенаправление или имя представления).
     */
    @PostMapping("/{boardId}/edit")
    String editBoard(HttpSession session, @PathVariable Integer boardId, @RequestParam String title, @RequestParam String description);

    /**
     * Возвращает страницу для создания новой доски.
     *
     * @return Имя представления для страницы создания доски.
     */
    @GetMapping("/page-creating-board")
    default String getPageOfCreatingBoard() {
        return "create-board";
    }

}
