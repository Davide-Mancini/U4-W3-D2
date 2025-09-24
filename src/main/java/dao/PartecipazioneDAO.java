package dao;

import davidemancini.entities.Location;
import davidemancini.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioneDAO {
    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    public void save (Partecipazione newPartecipazione){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPartecipazione);
        transaction.commit();
        System.out.println("la location " +newPartecipazione + " è stata creata");
    }

    public Partecipazione findById (String partecipazioneId){
        Partecipazione found = entityManager.find(Partecipazione.class, UUID.fromString(partecipazioneId));
        return found;
    }
}
