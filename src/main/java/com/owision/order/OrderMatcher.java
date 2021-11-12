package com.owision.order;

import com.owision.order.command.OrderType;
import com.owision.order.command.data.Buy;
import com.owision.order.command.impl.Print;
import com.owision.order.command.data.Sell;
import com.owision.order.command.impl.Trade;

import com.owision.order.data.InputData;
import com.owision.order.validate.InputValidator;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OrderMatcher{

    public static void main(String[] args){

        List <Buy> buyOrders=new ArrayList <>();
        List <Sell> sellOrders=new ArrayList <>();
        List<OrderType> orderTypeList = new ArrayList <>();

        Scanner sc=new Scanner(System.in);
        Print print=new Print();
        Trade trade=new Trade();


        while(true){
            //Enter order type
            System.out.println("Enter 'BUY VOLUME@PRICE' or 'SELL VOLUME@PRICE' or 'PRINT' or 'EXIT'" );
            String inputStr =sc.nextLine();

            InputValidator validator = new InputValidator();
            InputData data = validator.validate(inputStr);

            if(!data.isValid())
			{
				System.out.println(data.getErrorMessage());
				continue;
			}

            switch(data.getCommand()){
                case "SELL":
                    var time  = Instant.now().toEpochMilli();
                    sellOrders.add(new Sell(data.getVolume(), data.getPrice(), time));
                    orderTypeList.add(new Sell(data.getVolume(), data.getPrice(), time));
                    trade.execute(buyOrders, sellOrders);
                    break;
                case "BUY":
                    time  = Instant.now().toEpochMilli();
                    buyOrders.add(new Buy(data.getVolume(), data.getPrice(), time));
                    orderTypeList.add(new Buy(data.getVolume(), data.getPrice(), time));
                    trade.execute(buyOrders, sellOrders);
                    break;
                case "PRINT":
                    print.execute(buyOrders, sellOrders);
                    break;
                case "EXIT":
                    System.out.println("Are you sure you want to exit ? Press Y to confirm else ,Enter RESUME if you want to continue !! ");
                    String command=sc.nextLine();
                    if(command.equalsIgnoreCase("Y")){
                    System.out.println("Closing Program. Bye Bye !!");
                    System.exit(0);
                    }else if(command.equalsIgnoreCase("RESUME")){
                        continue;
                    }
                default:
                    System.out.println("Invalid Command !");
            }
        }
    }
}
