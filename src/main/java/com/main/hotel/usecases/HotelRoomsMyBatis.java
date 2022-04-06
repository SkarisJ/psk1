package com.main.hotel.usecases;

import com.main.hotel.mybatis.dao.HotelMapper;
import com.main.hotel.mybatis.dao.RoomMapper;
import com.main.hotel.mybatis.model.Hotel;
import com.main.hotel.mybatis.model.Room;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
public class HotelRoomsMyBatis {
    @Inject
    private RoomMapper roomMapper;

    @Inject
    private HotelMapper hotelMapper;

    @Getter
    @Setter
    private Room roomToCreate = new Room();

    @Getter @Setter
    private Hotel hotel;

    @Getter @Setter
    private List<Room> hotelRooms = new ArrayList<>();


    @PostConstruct
    public void init() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int hotelId = Integer.parseInt(requestParams.get("hotelId"));
        hotel = hotelMapper.selectByPrimaryKey(hotelId);
        hotelRooms = roomMapper.selectRoomsForHotel(hotelId);
    }

    @Transactional
    public String createRoom() {
        roomToCreate.setHotelId(hotel.getId());
        roomMapper.insert(roomToCreate);
        return "/myBatis/rooms?faces-redirect=true&hotelId=" + hotel.getId();
    }
}
