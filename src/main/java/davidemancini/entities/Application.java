package davidemancini.entities;

import com.github.javafaker.Faker;
import dao.EventoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Random;

public class Application {
private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d2");
    public static void main(String[] args) {
        Faker faker = new Faker();
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);
        Random random = new Random();

       Evento evento1 = new Evento("serata di beneficenza", LocalDate.of(2025,12,23),"serata di beneficenza per le persone bisognose",TipoEvento.PUBBLICO,200);
       Evento evento2 = new Evento("partita di calcio", LocalDate.of(2025,9,23),"AS Roma - SS lazio",TipoEvento.PUBBLICO,67756);

//     eventoDAO.save(evento3);
//       eventoDAO.findByIdAndDelete(4);
//       eventoDAO.findById(3);
        for (int i = 0; i < 10; i++) {
            Evento evento = new Evento(faker.educator().course(),LocalDate.of(random.nextInt(2025,2027),random.nextInt(1,12),random.nextInt(1,28)),faker.company().catchPhrase(), TipoEvento.PUBBLICO,random.nextInt(100000));
            eventoDAO.save(evento);
        }

    }
}
