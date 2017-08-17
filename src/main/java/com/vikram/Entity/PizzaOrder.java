package com.vikram.Entity;

import java.util.Date;

public class PizzaOrder {
    private String order;
    private Date time;

    public PizzaOrder(String order, Date time) {
        this.order = order;
        this.time = time;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return  order + " " + time + "\n";
    }
}
