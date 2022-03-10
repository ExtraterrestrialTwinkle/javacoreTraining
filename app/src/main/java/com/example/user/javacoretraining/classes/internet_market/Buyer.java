package com.example.user.javacoretraining.classes.internet_market;

public class Buyer {
    private String name = "Unknown";
    private double debit = 0.0;
    private boolean discount = false;
    private boolean isInBlackList = false;
    private Order order;

    public Buyer(){}

    public Buyer(String name, double debit){
        this.name = name;
        this.debit = debit;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public void setDiscount(){
        this.discount = true;
    }

    public void blacklist(){
        this.isInBlackList = true;
    }

    public boolean isInBlackist(){
        return isInBlackList;
    }

    public boolean isRegularCustomer(){
        return discount;
    }

    public Order buy(Goods product, int quantity){
        order = new Order(this, product, quantity);
        System.out.printf("I want to buy %d %s \n", quantity, product.name);
        return order;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public void pay(double price){
        if (price == 0) {
            order.setState(OrderState.CLOSED);
            System.out.println("Goodbye!");
        } else if (price <= this.debit){
            debit -= price;
            order.setState(OrderState.PAYED);
            System.out.println("I paid for it!");
        } else cancel();
    }

    public void cancel(){
        order.setState(OrderState.CANCELLED);
        System.out.println("I cancel it");
    }
}
