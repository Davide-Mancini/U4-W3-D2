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
       Persona persona2 = new Persona("rachele","frascatani","rakfrasc@gmail.com",LocalDate.of(1999,01,13), Sesso.FEMMINA);
     personaDAO.save(persona2);
       Persona persona2FromDB = personaDAO.findById("2c92ed06-f444-4ea4-b575-bd2fd4ee582b");
       Location locationFromDB = locationDAO.findById("4c691593-d3cd-477b-8086-3531d44d0be5");
       Location locationFromDB2 = locationDAO.findById("dc32aa44-423f-42bc-9131-0248075784a1");
       Evento evento2 = new Evento("partita di calcio", LocalDate.of(2025,9,23),"AS Roma - SS lazio",TipoEvento.PUBBLICO,67756,locationFromDB );
       Partecipazione partecipazione1 = new Partecipazione(persona2FromDB,eventoFromDB,Stato.CONFERMATA);
    Concerto concerto1 = new Concerto("gem tour", LocalDate.of(2025,11,24),"concerto gemitaiz",TipoEvento.PUBBLICO,40000,locationFromDB2,Genere.POP,true);
    eventoDAO.save(concerto1);
    eventoDAO.getConcertiInStreaming(concerto1).forEach(System.out::println);



    }
}
