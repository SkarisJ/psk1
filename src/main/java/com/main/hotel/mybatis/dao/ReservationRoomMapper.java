package com.main.hotel.mybatis.dao;

import com.main.hotel.mybatis.model.ReservationRoom;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface ReservationRoomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.RESERVATION_ROOM
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    int insert(ReservationRoom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.RESERVATION_ROOM
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    List<ReservationRoom> selectAll();
}