package com.vikram;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class App
{
    public static void main( String[] args )
    {
        ArrayList<PizzaOrder> orders = new ArrayList<>();
        try{
            FileReader fr = new FileReader(args[0]);
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
        List<PizzaOrder> sortedorders = orders.stream()
                .sorted(Comparator.comparing(PizzaOrder::getOrder))
                .collect(Collectors.toList());


        try{
            PrintWriter out = new PrintWriter(args[1]);
            out.println(String.format("%-15s %-15s", "Order", "time"));
            for(PizzaOrder o : sortedorders){
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
