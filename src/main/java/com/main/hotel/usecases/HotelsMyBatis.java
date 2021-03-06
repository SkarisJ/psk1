package com.main.hotel.usecases;

import com.main.hotel.mybatis.dao.HotelMapper;
import com.main.hotel.mybatis.model.Hotel;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class HotelsMyBatis {
    @Inject
    private HotelMapper hotelMapper;

    @Getter
    @Setter
    private List<Hotel> allHotels;

    @Getter @Setter
    private Hotel hotelToCreate = new Hotel();

    @PostConstruct
    private void init() {
        allHotels = hotelMapper.selectAll();
    }

    @Transactional
    public String createHotel() {
        hotelMapper.insert(hotelToCreate);
        return "/myBatis/hotels?faces-redirect=true";
    }
}
