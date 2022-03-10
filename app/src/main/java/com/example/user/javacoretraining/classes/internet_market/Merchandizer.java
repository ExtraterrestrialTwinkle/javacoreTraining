package com.example.user.javacoretraining.classes.internet_market;

import android.os.Build;
import android.support.annotation.RequiresApi;

public class Merchandizer {

    private Order order;

    public void addProductInfo(Goods ... products){
        for (Goods product : products){
            product.add();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public double registerSale(Order order){
        double price = 0;
        this.order = order;
        Buyer buyer = order.getBuyer();
        Goods product = order.getProduct();
        int quantity = order.getQuantity();
        getOrder(buyer, product);
        if(order.getState() != OrderState.APPROVED) {
            closeOrder();
        } else if(product.getQuantity() <= quantity) {
            System.out.printf("Sorry... We don't have so many items of %s \n", product.name);
            } else {
            product.reserved(quantity);
            price = product.price * quantity;
            System.out.printf("Your price is: %f \n", price);
            if(buyer.isRegularCustomer()) {
                price = getDiscount(price);
                System.out.printf("Your price is: %f \n", price);
            }
        }
        buyer.setOrder(order);
        return price;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void checkPayment(Buyer buyer, Order order){
        if(order.getState() == OrderState.PAYED){
            order.getProduct().sold(order.getQuantity());
            order.setState(OrderState.CLOSED);
            buyer.setDiscount();
        } else if (order.getState() == OrderState.CLOSED){
            order.getProduct().cancelled(order.getQuantity());
            System.out.println("Have a nice day!");
        } else{
            buyer.blacklist();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getOrder(Buyer buyer, Goods product){
        if(!product.isRegistered()) {
            System.out.println("We have no such product in our market!");
            order.setState(OrderState.CLOSED);
        } else if (buyer.isInBlackist()) {
            System.out.println("Sorry... You're in a blacklist");
            order.setState(OrderState.CANCELLED);
        } else {
            System.out.println("You can buy it!");
            order.setState(OrderState.APPROVED);
        }
    }

    private double getDiscount(double price){
        return price * 0.9;
    }

    private void closeOrder(){
        order.setState(OrderState.CLOSED);
        System.out.println("Impossible to carry out the operation!");
    }
}
