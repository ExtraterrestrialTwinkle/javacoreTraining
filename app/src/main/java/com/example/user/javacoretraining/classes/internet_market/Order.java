package com.example.user.javacoretraining.classes.internet_market;

enum OrderState {
    OPENED,
    CLOSED,
    APPROVED,
    PAYED,
    CANCELLED
}

class Order{
    private OrderState state = OrderState.OPENED;
    private Goods product;
    private Buyer buyer;
    private int quantity;

    public Order(Buyer buyer, Goods product, int quantity) {
        this.buyer = buyer;
        this.product = product;
        this.quantity = quantity;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Goods getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderState getState(){
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }
}