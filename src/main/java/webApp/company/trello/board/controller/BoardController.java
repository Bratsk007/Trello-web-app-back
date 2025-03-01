package webApp.company.trello.board.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Сущность доска", description = "API для получения/удаления/изменения доски")
@RequestMapping("/api/v1/board")
public interface BoardController {

//    @GetMapping("/{userId}")
//    List<BoardListResponse> getBoardsByUserId(@PathVariable Integer userId);
//
//    @PostMapping("/{userId}")
//    void saveBoardByUserId(@PathVariable Integer userId, @RequestBody BoardRequest boardRequest);
//
//    @PutMapping("/{boardId}")
//    void updateBoard(@PathVariable Integer boardId, @RequestBody BoardRequest boardRequest);

    /**
     * Получить доску по id
     *
     * @param boardId id доски
     * @return редирект на страницу с содержимым доски
     */
    @GetMapping("/{boardId}")
    String getBoardById(Model model, @PathVariable Integer boardId);

    @PostMapping("/create")
    String createBoard(@RequestParam String title, @RequestParam String description, HttpSession httpSession);

    @PostMapping("/delete/{boardId}")
    String deleteBoard(HttpSession session, @PathVariable Integer boardId);

    @GetMapping("/page-creating-board")
    default String getPageOfCreatingBoard() {
        return "create-board";
    }


//    @DeleteMapping("/{boardId}")
//    void deleteBoardById(@PathVariable Integer boardId);
}
