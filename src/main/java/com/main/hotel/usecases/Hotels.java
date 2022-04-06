package com.main.hotel.usecases;

import com.main.hotel.entities.Hotel;
import com.main.hotel.persistence.HotelsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Hotels {
    @Inject
    private HotelsDAO hotelsDAO;

    @Getter
    @Setter
    private Hotel hotelToCreate = new Hotel();

    @Getter
    private List<Hotel> allHotels;

    @PostConstruct
    public void init(){
        loadHotels();
    }

    public void loadHotels() {
        this.allHotels = hotelsDAO.loadAll();
    }

    @Transactional
    public String createHotel(){
        this.hotelsDAO.persist(hotelToCreate);

        return "/index";
    }
}
