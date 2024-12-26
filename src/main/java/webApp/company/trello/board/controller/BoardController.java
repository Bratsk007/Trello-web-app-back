package webApp.company.trello.board.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import webApp.company.trello.board.dto.BoardListResponse;
import webApp.company.trello.board.dto.BoardRequest;

import java.util.List;

@Tag(name = "Сущность доска", description = "API для получения/удаления/изменения доски")
@RequestMapping("/api/boards")
public interface BoardController {

    @GetMapping("/{userId}")
    List<BoardListResponse> getBoardsByUserId(@PathVariable Integer userId);

    @PostMapping("/{userId}")
    void saveBoardByUserId(@PathVariable Integer userId, @RequestBody BoardRequest boardRequest);

    @PutMapping("/{boardId}")
    void updateBoard(@PathVariable Integer boardId, @RequestBody BoardRequest boardRequest);
}
