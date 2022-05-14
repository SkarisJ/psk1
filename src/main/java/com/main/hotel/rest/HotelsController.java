package com.main.hotel.rest;

import com.main.hotel.entities.Hotel;
import com.main.hotel.persistence.HotelsDAO;
import com.main.hotel.rest.contracts.HotelsDto;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/hotels")
public class HotelsController {

    @Inject
    @Setter
    @Getter
    private HotelsDAO hotelsDAO;

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHotelById(@PathParam("id") final int id) {
        Hotel hotel = hotelsDAO.findOne(id);
        if (hotel == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        HotelsDto hotelsDto = new HotelsDto();
        hotelsDto.setName(hotel.getName());
        hotelsDto.setAddress(hotel.getAddress());

        return Response.ok(hotelsDto).build();
    }
    @Path("/post")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createHotel(
            HotelsDto hotelData) {

        if (hotelData.getName() == null || hotelData.getAddress() == null){
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        Hotel hotel = new Hotel();
        hotel.setName(hotelData.getName());
        hotel.setAddress(hotelData.getAddress());

        hotelsDAO.persist(hotel);
        return Response.ok().build();
    }

    @Path("/update/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateHotel(
            @PathParam("id") final int hotelId,
            HotelsDto hotelData) {
        try {
            Hotel existingHotel = hotelsDAO.findOne(hotelId);
            if (existingHotel == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingHotel.setName(hotelData.getName() != null ? hotelData.getName() : existingHotel.getName());
            existingHotel.setAddress(hotelData.getAddress()  != null ? hotelData.getAddress() : existingHotel.getAddress());
            hotelsDAO.update(existingHotel);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
