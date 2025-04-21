package com.example.education.model;

import java.util.Map;

public class MyRequest {
    private double price;
    private Map<String, Object> info;

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public Map<String, Object> getInfo(){
        return info;
    }

    public void setInfo(Map<String, Object> info){
        this.info = info;
    }

}
