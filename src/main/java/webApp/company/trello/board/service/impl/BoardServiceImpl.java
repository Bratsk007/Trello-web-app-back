package webApp.company.trello.board.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webApp.company.trello.board.dao.BoardDao;
import webApp.company.trello.board.dto.*;
import webApp.company.trello.board.model.Board;
import webApp.company.trello.board.service.BoardService;
import webApp.company.trello.card.model.Card;
import webApp.company.trello.list.model.Catalog;
import webApp.company.trello.user.dao.UserDao;
import webApp.company.trello.user.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardDao boardDao;
    private final UserDao userDao;

    @Override
    public List<BoardListResponse> getBoardsByUserId(Integer userId) {
        List<Board> boardList = boardDao.findByUserId(userId);
        List<BoardListResponse> responseList = new ArrayList<>();


        for (Board board : boardList) {
            responseList.add(
                    BoardListResponse.builder()
                            .id(board.getId())
                            .title(board.getTitle())
                            .description(board.getDescription())
                            .build()
            );
        }

        return responseList;

    }

    @Override
    public void saveBoard(Board board) {
        boardDao.save(board);
    }

//    @Override
//    public void saveBoard(Integer userId, BoardRequest boardRequest) {
//        Optional<User> user = userDao.findById(userId);
//
//        Board board = Board.builder()
//                .description(boardRequest.getDescription())
//                .title(boardRequest.getTitle())
//                .build();
//
//        if (user.isPresent()) {
//            board.setUser(user.get());
//            boardDao.save(board);
//        }
//
//
//    }

    @Override
    public void updateBoard(Integer boardId, BoardRequest boardRequest) {
        Optional<Board> boardOptional = boardDao.findById(boardId);

        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();

            board.setTitle(boardRequest.getTitle());
            board.setDescription(boardRequest.getDescription());

            boardDao.save(board);
        }
    }

    @Override
    public Board getBoardById(Integer boardId) {

        Optional<Board> optionalBoard = boardDao.findById(boardId);

        if (optionalBoard.isEmpty()) {
            throw new RuntimeException();
        }

        return optionalBoard.get();
    }

    @Override
    public void deleteBoardById(Integer boardId) {
        Optional<Board> optionalBoard = boardDao.findById(boardId);

        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            boardDao.delete(board);
        }
    }


}
