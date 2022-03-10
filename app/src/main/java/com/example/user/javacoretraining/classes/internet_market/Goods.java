package com.example.user.javacoretraining.classes.internet_market;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.HashMap;

class Goods {

    protected String name;
    protected double price;
    protected int quantity;
    protected HashMap<String, Integer> assortment = new HashMap<>();
    private boolean isRegistered = false;

    public int getQuantity(){
        return quantity;
    }

    public void add(){
        assortment.put(name, quantity);
        isRegistered = true;
    }

    public boolean isRegistered(){
        return isRegistered;
    }

    // Возвращает зарезервированное количество товара
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int reserved(int quantity){
        this.quantity -= quantity;
        assortment.replace(this.name, this.quantity);
        return quantity;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void cancelled(int quantity){
        this.quantity += quantity;
        assortment.replace(this.name, this.quantity);
    }

    public void sold(int quantity){
        System.out.printf("Congratulations on your purchase: %s %d pcs \n", this.name, quantity);
    }
}

class Fridge extends Goods {
    public Fridge(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

class TV extends Goods {
    public TV(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

class Stove extends Goods {
    public Stove(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}