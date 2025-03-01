package webApp.company.trello.board.service;

import webApp.company.trello.board.dto.BoardListResponse;
import webApp.company.trello.board.dto.BoardRequest;
import webApp.company.trello.board.dto.BoardResponse;
import webApp.company.trello.board.model.Board;

import java.util.List;

public interface BoardService {

    List<BoardListResponse> getBoardsByUserId(Integer userId);


    void saveBoard(Board board);

    void updateBoard(Integer boardId, BoardRequest boardRequest);

    Board getBoardById(Integer boardId);

    void deleteBoardById(Integer boardId);
}
