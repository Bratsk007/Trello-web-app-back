package webApp.company.trello.card.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webApp.company.trello.card.model.Card;

@Repository
public interface CardDao extends JpaRepository<Card, Integer> {
}
