package hibernate.entities;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "games")
public class Games {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Games{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", developer='" + developer + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Games games = (Games) o;
        return year == games.year && Objects.equals(id, games.id) && Objects.equals(title, games.title) && Objects.equals(developer, games.developer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, developer, year);
    }
}
