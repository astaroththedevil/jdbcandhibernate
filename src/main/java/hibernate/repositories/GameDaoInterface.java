package hibernate.repositories;

import hibernate.entities.Game;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public interface GameDaoInterface{

    void persist(Game game);
    void update (Game game);
    Game findById(Id id, Game game);
    void delete(Game game);
    List<Game> findAll();
    void deleteAll();
}
