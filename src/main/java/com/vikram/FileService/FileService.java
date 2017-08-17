package com.vikram.FileService;

import com.vikram.Entity.PizzaOrder;

import java.util.List;

public interface FileService {
    List<PizzaOrder> readFile(String inputFile);
    void writeFile(String outputFile, List<PizzaOrder> orders);
}
