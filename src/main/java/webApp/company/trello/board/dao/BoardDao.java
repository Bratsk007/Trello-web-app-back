package webApp.company.trello.board.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webApp.company.trello.board.model.Board;

import java.util.List;

@Repository
public interface BoardDao extends JpaRepository<Board, Integer> {

    List<Board> findByUserId(Integer userId);
}
