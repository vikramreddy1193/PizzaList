package com.vikram;

import com.vikram.Entity.PizzaOrder;
import com.vikram.FileService.FileService;
import com.vikram.SortService.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class SortPizzaOrders {

    @Autowired
    private FileService fileService;
    @Autowired
    private SortService sortService;

    public void sortOrders(String inputFile, String outputFile){

        //Reading pizza orders from file
        List<PizzaOrder> orders = fileService.readFile(inputFile);

        //Sorting pizza orders
        List<PizzaOrder> sortedorders = sortService.sortList(orders);

        //writing pizza orders to file
        fileService.writeFile(outputFile, sortedorders);

    }
}
