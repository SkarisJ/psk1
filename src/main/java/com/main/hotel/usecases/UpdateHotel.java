package com.main.hotel.usecases;

import com.main.hotel.entities.Hotel;
import com.main.hotel.interceptors.LoggedInvocation;
import com.main.hotel.persistence.HotelsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter
@Setter
public class UpdateHotel implements Serializable {

    private Hotel hotel;

    @Inject
    private HotelsDAO hotelsDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateHotel INIT CALLED");
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int hotelId = Integer.parseInt(requestParams.get("hotelId"));
        this.hotel = hotelsDAO.findOne(hotelId);
    }

    @Transactional
    @LoggedInvocation
    public String updateHotel() {
        try{
            hotelsDAO.update(this.hotel);
        } catch (OptimisticLockException e) {
            return "/HotelDetails.xhtml?faces-redirect=true&hotelId=" + this.hotel.getId() + "&error=optimistic-lock-exception";
        }
        return "/index";
    }
}
