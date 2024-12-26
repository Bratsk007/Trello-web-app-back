package webApp.company.trello.card.model;


import jakarta.persistence.*;
import lombok.*;
import webApp.company.trello.list.model.Catalog;

import java.util.Objects;

@Entity
@Table(name = "card")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Card card = (Card) object;
        return Objects.equals(id, card.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
