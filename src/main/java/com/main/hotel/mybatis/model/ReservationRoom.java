package com.main.hotel.mybatis.model;

public class ReservationRoom {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.RESERVATION_ROOM.RESERVATION_ID
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    private Long reservationId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.RESERVATION_ROOM.RESERVEDROOMS_ID
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    private Integer reservedroomsId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.RESERVATION_ROOM.RESERVATION_ID
     *
     * @return the value of PUBLIC.RESERVATION_ROOM.RESERVATION_ID
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    public Long getReservationId() {
        return reservationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.RESERVATION_ROOM.RESERVATION_ID
     *
     * @param reservationId the value for PUBLIC.RESERVATION_ROOM.RESERVATION_ID
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.RESERVATION_ROOM.RESERVEDROOMS_ID
     *
     * @return the value of PUBLIC.RESERVATION_ROOM.RESERVEDROOMS_ID
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    public Integer getReservedroomsId() {
        return reservedroomsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.RESERVATION_ROOM.RESERVEDROOMS_ID
     *
     * @param reservedroomsId the value for PUBLIC.RESERVATION_ROOM.RESERVEDROOMS_ID
     *
     * @mbg.generated Wed Apr 06 00:45:22 EEST 2022
     */
    public void setReservedroomsId(Integer reservedroomsId) {
        this.reservedroomsId = reservedroomsId;
    }
}