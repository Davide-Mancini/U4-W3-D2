package dao;

import davidemancini.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventoDAO {
    //ATTRIBUTI
    private EntityManager entityManager;
    //COSTRUTTORE
    public EventoDAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    //METODI
    public void save(Evento newEvento){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newEvento);
        transaction.commit();
        System.out.println("Evento " + newEvento +" è stato salvato");
    }

    public Evento findById(String eventoId){
    Evento trovato = entityManager.find(Evento.class, UUID.fromString(eventoId));
        System.out.println("ecco l'evento che hai cercato: " + trovato);
    return trovato;
    }

    public void findByIdAndDelete (String eventoId){
        Evento trovato = this.findById(eventoId);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(trovato);
        transaction.commit();
        System.out.println("Evento " + trovato + " è stato eliminato");
    }
}
