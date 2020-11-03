package com.zp.entity;

public class Menu {
    private Long id;
    private String name;
    private double price;
    private String flavor;
    private MenuType type;

    public Menu() {}

    public Menu(Long id, String name, double price, String flavor, MenuType type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.flavor = flavor;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }
}
