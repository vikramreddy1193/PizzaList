package com.vikram;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AppTest extends TestCase
{
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testApp()
    {
        App app = new App();
        ArrayList<PizzaOrder> orderedtestlist = new ArrayList<PizzaOrder>(){{
            add(new PizzaOrder("Bread", new Date(1477405487 * 1000)));
            add(new PizzaOrder("Meat", new Date(1506176687 * 1000)));
            add(new PizzaOrder("Pizza", new Date(1477319087 * 1000)));
            add(new PizzaOrder("VegVeg", new Date(1474295087 * 1000)));
            add(new PizzaOrder("bread", new Date(1477232687 * 1000)));
            add(new PizzaOrder("bread", new Date(1474640687 * 1000)));
            add(new PizzaOrder("meatMeaT", new Date(1474295087 * 1000)));
            add(new PizzaOrder("p1zza", new Date(1477491887 * 1000)));
            add(new PizzaOrder("pizza", new Date(1477578287 * 1000)));

        }};
        try{
            PrintWriter out = new PrintWriter("testsample.txt");
            out.println(String.format("%-15s %-15s", "Order", "time"));
            out.println(String.format("%-15s %-15s", "Meat", "1506176687"));
            out.println(String.format("%-15s %-15s", "pizza", "1477578287"));
            out.println(String.format("%-15s %-15s", "p1zza", "1477491887"));
            out.println(String.format("%-15s %-15s", "Bread", "1477405487"));
            out.println(String.format("%-15s %-15s", "Pizza", "1477319087"));
            out.println(String.format("%-15s %-15s", "bread", "1477232687"));
            out.println(String.format("%-15s %-15s", "bread", "1474640687"));
            out.println(String.format("%-15s %-15s", "meatMeaT", "1474295087"));
            out.println(String.format("%-15s %-15s", "VegVeg", "1474295087"));
            out.flush();
            out.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

        app.main(new String[]{"testsample.txt","testOutput.txt"});

        ArrayList<String> orderedoutputlistname = new ArrayList<>();
        try{
            FileReader fr = new FileReader("testOutput.txt");
            Scanner s = new Scanner(fr);
            s.nextLine();
            while(s.hasNextLine()){
                String line = s.nextLine();
                if(!(line.isEmpty())){
                    String[] orderread = line.trim().split("\\s+");
                    orderedoutputlistname.add(orderread[0]);
                }
            }
            s.close();
            fr.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

        for(int i=0; i<orderedtestlist.size(); i++){
            assertEquals(orderedtestlist.get(i).getOrder(),orderedoutputlistname.get(i));
        }
    }
}
