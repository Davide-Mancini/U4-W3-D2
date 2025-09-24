import com.github.javafaker.Faker;
import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import davidemancini.entities.*;
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
        Random random = new Random();
        EventoDAO eventoDAO = new EventoDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);

       Evento eventoFromDB =  eventoDAO.findById("1babe919-8381-4218-9a74-91b16b1f2cfe");
       Persona persona1 = new Persona("davide","mancini","mancinidavide73@gmail.com",LocalDate.of(1999,03,07), Sesso.MASCHIO);
//        personaDAO.save(persona1);
       Persona persona1FromDB = personaDAO.findById("88417a7d-7a7a-4825-b635-eec7a98f1c00");
       Location locationFromDB = locationDAO.findById("4c691593-d3cd-477b-8086-3531d44d0be5");
//       Evento evento1 = new Evento("serata di beneficenza", LocalDate.of(2025,12,23),"serata di beneficenza per le persone bisognose", TipoEvento.PUBBLICO,200);
       Evento evento2 = new Evento("partita di calcio", LocalDate.of(2025,9,23),"AS Roma - SS lazio",TipoEvento.PUBBLICO,67756,locationFromDB );

       Location location1 = new Location("Stadio Olimpico","Roma", eventoFromDB);
       locationDAO.save(location1);
    eventoDAO.save(evento2);
//     eventoDAO.save(evento3);
//       eventoDAO.findByIdAndDelete(4);
//       eventoDAO.findById(3);
//        for (int i = 0; i < 10; i++) {
//            Evento evento = new Evento(faker.educator().course(),LocalDate.of(random.nextInt(2025,2027),random.nextInt(1,12),random.nextInt(1,28)),faker.company().catchPhrase(), TipoEvento.PUBBLICO,random.nextInt(100000));
//            eventoDAO.save(evento);
//        }

    }
}
