package com.main.hotel.persistence;

import lombok.Setter;
import com.main.hotel.entities.Hotel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class HotelsDAO {

    @Inject
    private  EntityManager em;

    public List<Hotel> loadAll() {
        return em.createNamedQuery("Hotels.findAll", Hotel.class).getResultList();
    }

    public Hotel findOne(int id) {
        return em.find(Hotel.class, id);
    }

    public Hotel update(Hotel hotel){
        return em.merge(hotel);
    }

    public void persist(Hotel hotel){
        em.persist(hotel);
    }
}
