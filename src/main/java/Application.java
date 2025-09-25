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

        //--------------------------------------CREAZIONE DAO--------------------------------------------------
        EventoDAO eventoDAO = new EventoDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);



        //--------------------------------- RIECERCHE E ISTANZE-------------------------------------------------
       Evento eventoFromDB =  eventoDAO.findById("1babe919-8381-4218-9a74-91b16b1f2cfe");
       Evento eventoFromDB2 =  eventoDAO.findById("1babe919-8381-4218-9a74-91b16b1f2cfe");
       Persona persona2 = new Persona("rachele","frascatani","rakfrasc@gmail.com",LocalDate.of(1999,01,13), Sesso.FEMMINA);
//       personaDAO.save(persona2);
       Persona persona2FromDB = personaDAO.findById("70941226-3fd0-42c8-8866-7c4930773d7e");
       Location location1 = new Location("prova","roma",eventoFromDB);
       Location location2 = new Location("prova","milano",eventoFromDB2);
      Location location1formDB = locationDAO.findById("2eef9434-0bb9-4c68-8636-9ee0c23b28d6");
      Location location2formDB = locationDAO.findById("c01528de-bcd7-455c-9d6a-846aa45efa0f");

//       Evento evento2 = new Evento("partita di calcio", LocalDate.of(2025,9,23),"AS Roma - SS lazio",TipoEvento.PUBBLICO,67756,locationFromDB );
       Partecipazione partecipazione1 = new Partecipazione(persona2FromDB,eventoFromDB,Stato.CONFERMATA);
    Concerto concerto1 = new Concerto("gem tour", LocalDate.of(2025,11,24),"concerto gemitaiz",TipoEvento.PUBBLICO,40000,location1formDB,Genere.POP,true);
    Concerto concerto2 = new Concerto("prova",LocalDate.of(2025,12,25),"provaaaaaaa",TipoEvento.PRIVATO,12000, location2formDB,Genere.ROCK,false);

    eventoDAO.save(concerto1);
    eventoDAO.save(concerto2);
    eventoDAO.getConcertiInStreaming(concerto1).forEach(System.out::println);



    }
}
