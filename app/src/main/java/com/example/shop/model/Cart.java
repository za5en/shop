package com.example.shop.model;

import java.util.HashSet;
import java.util.Set;

public class Cart {

    public static Set<Integer> items_id = new HashSet<>();
    public static String[] realAmount = new String[5];

    String amount, goodsName, goodsPrice;

    public Cart(String amount, String goodsName, String goodsPrice) {
        this.amount = amount;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
