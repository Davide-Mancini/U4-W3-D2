package dao;

import davidemancini.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    public void save (Location newLocation){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newLocation);
        transaction.commit();
        System.out.println("la location " +newLocation + " è stata creata");
    }

    public Location findById (String locationId){
        Location found = entityManager.find(Location.class, UUID.fromString(locationId));
        return found;
    }
}
