package com.zp.entity;

import java.util.Date;

public class Order {
    private long id;
    private User user;
    private Menu menu;
    private Admin admin;
    private Date date;
    private int state;

    public Order(){}

    public Order(long id, User user, Menu menu, Admin admin, Date date, int state) {
        this.id = id;
        this.user = user;
        this.menu = menu;
        this.admin = admin;
        this.date = date;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
