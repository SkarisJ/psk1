package com.main.hotel.mybatis.model;

public class Room {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ROOM.ID
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ROOM.NUMBER
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    private Integer number;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ROOM.HOTEL_ID
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    private Integer hotelId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ROOM.ID
     *
     * @return the value of PUBLIC.ROOM.ID
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ROOM.ID
     *
     * @param id the value for PUBLIC.ROOM.ID
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ROOM.NUMBER
     *
     * @return the value of PUBLIC.ROOM.NUMBER
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ROOM.NUMBER
     *
     * @param number the value for PUBLIC.ROOM.NUMBER
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ROOM.HOTEL_ID
     *
     * @return the value of PUBLIC.ROOM.HOTEL_ID
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    public Integer getHotelId() {
        return hotelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ROOM.HOTEL_ID
     *
     * @param hotelId the value for PUBLIC.ROOM.HOTEL_ID
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }
}