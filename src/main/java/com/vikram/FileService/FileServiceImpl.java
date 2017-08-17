package com.vikram.FileService;

import com.vikram.Entity.PizzaOrder;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Component
public class FileServiceImpl implements FileService {

    @Override
    public List<PizzaOrder> readFile(String inputFile) {
        ArrayList<PizzaOrder> orders = new ArrayList<>();
        try{
            FileReader fr = new FileReader(inputFile);
            Scanner s = new Scanner(fr);
            s.nextLine();
            while(s.hasNextLine()){
                String line = s.nextLine();
                if(!(line.isEmpty())){
                    String[] orderread = line.trim().split("\\s+");
                    Date date = new Date(Long.parseLong(orderread[1]) * 1000);
                    orders.add(new PizzaOrder(orderread[0], date));
                }
            }
            s.close();
            fr.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return orders;
    }

    @Override
    public void writeFile(String outputFile, List<PizzaOrder> orders) {
        try{
            PrintWriter out = new PrintWriter(outputFile);
            out.println(String.format("%-15s %-15s", "Order", "time"));
            for(PizzaOrder o : orders){
                out.println(String.format("%-15s %-15s", o.getOrder(), o.getTime()));
            }
            out.flush();
            out.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
