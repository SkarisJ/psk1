package com.main.hotel.persistence;

import com.main.hotel.entities.Reservation;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ReservationsDAO {

    @Inject
    private EntityManager entityManager;

    public List<Reservation> loadAll() {
        return entityManager.createNamedQuery("Reservations.findAll", Reservation.class).getResultList();
    }

    public Reservation findOne(int id) {
        return entityManager.find(Reservation.class, id);
    }

    public void persist(Reservation reservation) {
        entityManager.persist(reservation);
    }
}
