import com.google.inject.Guice;
import com.google.inject.Injector;
import util.guice.PersistenceModule;

import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String args[]){
        Injector injector = Guice.createInjector(new PersistenceModule("Game"));
        GameDAO gameDao = injector.getInstance(GameDAO.class);
        Game game = Game.builder()
                .releaseDate(new Date())
                .creators("MÁV")
                .genres(Arrays.asList("Horror","Thriller","Hentai"))
                .gameName("Terror on the Train")
                .description("safshaniognioasngivopnasivnafnpapdfanpsfdnapfsnapfa")
                .build();
        gameDao.persist(game);
        System.out.println(game);
        System.out.println(gameDao.findAfter(2000));
    }
}
