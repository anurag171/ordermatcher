package com.owision.order.types;

public enum Order{
    SELL("SELL"),BUY("BUY");

    Order(String type){
        this.type = type;
    }

    private String type;
}
