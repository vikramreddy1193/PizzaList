package com.vikram.SortService;

import com.vikram.Entity.PizzaOrder;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SortServiceImpl implements SortService{
    @Override
    public List<PizzaOrder> sortList(List<PizzaOrder> pizzaOrders) {

        List<PizzaOrder> sortedorders = pizzaOrders.stream()
                .sorted(Comparator.comparing(PizzaOrder::getOrder))
                .collect(Collectors.toList());

        return sortedorders;
    }
}
