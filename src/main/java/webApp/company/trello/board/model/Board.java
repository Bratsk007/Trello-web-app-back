package webApp.company.trello.board.model;

import jakarta.persistence.*;
import lombok.*;
import webApp.company.trello.list.model.Catalog;
import webApp.company.trello.user.model.User;

import java.util.List;

@Entity
@Table(name = "board")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "board")
    private List<Catalog> catalogList;
}
