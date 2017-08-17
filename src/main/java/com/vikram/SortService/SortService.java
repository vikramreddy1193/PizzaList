package com.vikram.SortService;

import com.vikram.Entity.PizzaOrder;

import java.util.List;

public interface SortService {
    List<PizzaOrder> sortList(List<PizzaOrder> pizzaOrders);
}
