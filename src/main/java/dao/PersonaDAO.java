package dao;

import davidemancini.entities.Location;
import davidemancini.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDAO {
    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    public void save (Persona newPersona){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPersona);
        transaction.commit();
        System.out.println("la location " +newPersona + " è stata creata");
    }

    public Persona findById (String personaId){
        Persona found = entityManager.find(Persona.class, UUID.fromString(personaId));
        return found;
    }
}
