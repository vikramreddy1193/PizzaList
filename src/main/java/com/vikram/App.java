package com.vikram;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        SortPizzaOrders sortPizzaOrders = context.getBean(SortPizzaOrders.class);
        sortPizzaOrders.sortOrders(args[0],args[1]);
        context.close();
    }
}
