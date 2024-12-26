package webApp.company.trello.board.service;

import webApp.company.trello.board.dto.BoardListResponse;
import webApp.company.trello.board.dto.BoardRequest;

import java.util.List;

public interface BoardService {

    List<BoardListResponse> getBoardsByUserId(Integer userId);


    void saveBoard(Integer userId, BoardRequest boardRequest);

    void updateBoard(Integer boardId, BoardRequest boardRequest);
}
