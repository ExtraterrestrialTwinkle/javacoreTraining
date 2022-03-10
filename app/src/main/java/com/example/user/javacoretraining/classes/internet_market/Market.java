package com.example.user.javacoretraining.classes.internet_market;

import android.os.Build;
import android.support.annotation.RequiresApi;

/*
      VII

      Задача на взаимодействие между классами. Разработать систему «Интернет-магазин».
      Товаровед добавляет информацию о Товаре. Клиент делает и оплачивает Заказ на Товары.
      Товаровед регистрирует Продажу и может занести неплательщика в «черный список».
     */
public class Market {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args){
        Merchandizer bob = new Merchandizer();

        Goods tvLg = new TV("Lg", 100, 15.6);
        Goods tvSamsung = new TV("Samsung", 150, 20.768);
        Goods fridgeHansa = new Fridge("Hansa", 20, 45.9);
        Goods fridgeLiebherr = new Fridge("Liebherr", 15, 102.987);
        Goods stoveGorenje = new Stove("Gorenje", 50, 68.9);
        Goods stoveMechta = new Stove("Mechta", 150, 13.2);

        bob.addProductInfo(tvLg, tvSamsung, fridgeHansa, fridgeLiebherr, stoveGorenje);

        Buyer peter = new Buyer("Peter", 200.900);

        Order order1 = peter.buy(stoveMechta, 12);
        double price1 = bob.registerSale(order1);
        peter.pay(price1);
        bob.checkPayment(peter, order1);

        Order order2 = peter.buy(fridgeHansa, 34);
        double price2 = bob.registerSale(order2);
        peter.pay(price2);
        bob.checkPayment(peter, order2);

        Order order3 = peter.buy(tvSamsung, 1);
        double price3 = bob.registerSale(order3);
        peter.pay(price3);
        bob.checkPayment(peter, order3);
    }
}


