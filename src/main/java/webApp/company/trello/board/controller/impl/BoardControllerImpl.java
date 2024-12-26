package webApp.company.trello.board.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import webApp.company.trello.board.controller.BoardController;
import webApp.company.trello.board.dto.BoardListResponse;
import webApp.company.trello.board.dto.BoardRequest;
import webApp.company.trello.board.dto.BoardResponse;
import webApp.company.trello.board.service.BoardService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BoardControllerImpl implements BoardController {
    private final BoardService boardService;

    @Override
    public List<BoardListResponse> getBoardsByUserId(Integer userId) {
        return boardService.getBoardsByUserId(userId);
    }

    @Override
    public void saveBoardByUserId(Integer userId, BoardRequest boardRequest) {
        boardService.saveBoard(userId, boardRequest);
    }

    @Override
    public void updateBoard(Integer boardId, BoardRequest boardRequest) {
        boardService.updateBoard(boardId, boardRequest);
    }

    @Override
    public BoardResponse getBoardById(Integer boardId) {
        return boardService.getBoardById(boardId);
    }

    @Override
    public void deleteBoardById(Integer boardId) {
        boardService.deleteBoardById(boardId);
    }


}
