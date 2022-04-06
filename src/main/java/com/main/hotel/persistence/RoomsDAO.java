package com.main.hotel.persistence;

import com.main.hotel.entities.Room;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class RoomsDAO {

    @Inject
    private EntityManager entityManager;

    public List<Room> loadAll() {
        return entityManager.createNamedQuery("Rooms.findAll", Room.class).getResultList();
    }

    public void persist(Room room) {
        entityManager.persist(room);
    }

    public Room findOne(int id) {
        return entityManager.find(Room.class, id);
    }
}
