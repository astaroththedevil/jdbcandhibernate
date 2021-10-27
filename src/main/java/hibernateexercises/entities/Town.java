package hibernateexercises.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "towns")
public class Town {

    private Integer id;
    private String name;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "town_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return id.equals(town.id) &&
                name.equals(town.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
