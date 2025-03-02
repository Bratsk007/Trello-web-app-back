package webApp.company.trello.board.controller.impl;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import webApp.company.trello.board.controller.BoardController;
import webApp.company.trello.board.model.Board;
import webApp.company.trello.board.service.BoardService;
import webApp.company.trello.user.dao.UserDao;
import webApp.company.trello.user.model.User;

import java.util.List;
import java.util.Objects;


@RequiredArgsConstructor
@Controller
public class BoardControllerImpl implements BoardController {
    private final BoardService boardService;
    private final UserDao userDao;


//    @Override
//    public List<BoardListResponse> getBoardsByUserId(Integer userId) {
//        return boardService.getBoardsByUserId(userId);
//    }
//
//    @Override
//    public void saveBoardByUserId(Integer userId, BoardRequest boardRequest) {
//        boardService.saveBoard(userId, boardRequest);
//    }
//
//    @Override
//    public void updateBoard(Integer boardId, BoardRequest boardRequest) {
//        boardService.updateBoard(boardId, boardRequest);
//    }

    @Override
    public String getBoardById(Model model, Integer boardId) {

        Board board = boardService.getBoardById(boardId);
        Hibernate.initialize(board.getCatalogList());

        model.addAttribute("board", board);
        return "board-page";
    }

    @Override
    public String createBoard(String title, String description, HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (Objects.isNull(user)) {
            return "redirect:/";
        }


        Board newBoard = Board.builder()
                .title(title)
                .description(description)
                .build();

        user.getBoards().add(newBoard);
        newBoard.setUser(user);

        User save = userDao.save(user);

        session.setAttribute("user", save);

        return "redirect:/home-page";
    }

    @Override
    public String deleteBoard(HttpSession session, Integer boardId) {

        User user = (User) session.getAttribute("user");

        if (Objects.isNull(user)) {
            return "redirect:/";
        }

        Board board = boardService.getBoardById(boardId);


        user.getBoards().remove(board);
        User save = userDao.save(user);

        session.setAttribute("user", save);

        return "redirect:/home-page";
    }

    @Override
    public String getEditBoardPage(Integer boardId, Model model) {
        Board board = boardService.getBoardById(boardId);

        model.addAttribute("board", board);
        return "edit-board";
    }

    @Override
    public String editBoard(HttpSession session, Integer boardId, String title, String description) {

        User user = (User) session.getAttribute("user");

        if (Objects.isNull(user)) {
            return "redirect:/";
        }

        Board board = boardService.getBoardById(boardId);
        user.getBoards().remove(board);
        board.setTitle(title);
        board.setDescription(description);
        user.getBoards().add(board);
        boardService.saveBoard(board);

        return "redirect:/api/v1/board/" + board.getId();
    }


//    @Override
//    public void deleteBoardById(Integer boardId) {
//        boardService.deleteBoardById(boardId);
//    }


}
