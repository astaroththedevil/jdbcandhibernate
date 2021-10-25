package hibernate.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "developer")
    private String developer;

    @Column(name = "year")
    private int year;
}
