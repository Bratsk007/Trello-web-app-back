package webApp.company.trello.user.model;


import jakarta.persistence.*;
import lombok.*;
import webApp.company.trello.board.model.Board;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Board> boards;
}
