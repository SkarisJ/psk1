package com.main.hotel.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "ROOM")
@NamedQueries({
        @NamedQuery(name = "Rooms.findAll", query = "select r from Room as r")
})
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int number;
    @ManyToOne
    @JoinColumn(name = "HOTEL_ID")
    private Hotel hotel;
}
