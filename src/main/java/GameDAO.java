import util.jpa.GenericJpaDao;

import java.sql.Date;
import java.util.List;

public class GameDAO extends GenericJpaDao<Game>{
    /**
     * Constructs a {@code GenericJpaDao} object.
     *
     * @param entityClass the {@link Class} object that represents the entity
     *                    class
     */
    public GameDAO(Class<Game> entityClass) {
        super(Game.class);
    }

    public List<Game> findAfter(int n){
        Date date = Date.valueOf(String.valueOf(n));
        return entityManager.createQuery("SELECT * FROM Game WHERE releaseDate > "+date+";").getResultList();
    }
}
