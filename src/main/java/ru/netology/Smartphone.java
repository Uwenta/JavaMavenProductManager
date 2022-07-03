package ru.netology;

public class Smartphone extends Product {
    private String maker;

    public Smartphone(int id, String name, int price, String maker) {
        super(id, name, price);
        this.setMaker(maker);

    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        } else {
            return getMaker().contains(search);
        }
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}


