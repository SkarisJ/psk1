package com.main.hotel.usecases;

import com.main.hotel.entities.Hotel;
import com.main.hotel.entities.Room;
import com.main.hotel.persistence.HotelsDAO;
import com.main.hotel.persistence.RoomsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class HotelRooms {
    @Inject
    private HotelsDAO hotelsDAO;

    @Inject
    private RoomsDAO roomsDAO;

    @Getter
    @Setter
    private Hotel hotel;

    @Getter @Setter
    private Room roomToCreate = new Room();

    @PostConstruct
    public void init() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int id = Integer.parseInt(requestParams.get("hotelId"));
        hotel = hotelsDAO.findOne(id);
    }

    @Transactional
    public String createRoom() {
        roomToCreate.setHotel(hotel);
        roomsDAO.persist(roomToCreate);
        return "rooms?faces-redirect=true&hotelId=" + hotel.getId();
    }
}
