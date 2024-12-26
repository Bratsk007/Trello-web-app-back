package webApp.company.trello.list.model;

import jakarta.persistence.*;
import lombok.*;
import webApp.company.trello.board.model.Board;
import webApp.company.trello.card.model.Card;

import java.util.List;

@Entity
@Table(name = "catalog")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "catalog")
    private List<Card> cardList;
}
