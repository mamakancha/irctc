package com.mamakancha.irctc.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    /* attributes */
    private Integer userID;
    private String name;
    private String email;

    /* relationships */
    private List<Role> roles = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    /* getters and setters */
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

}
