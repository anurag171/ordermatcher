package com.owision.order.command.impl;

import com.owision.order.command.OrderCommand;
import com.owision.order.command.data.Buy;
import com.owision.order.command.data.Sell;

import java.util.List;

import static com.owision.order.constants.OrderMatcherConstants.*;

public class Print implements OrderCommand{

	
	private void print(List<Buy> buyOrders, List<Sell> sellOrders) {
		
		//Print orders
		System.out.println(SELL_DISPLAY);
		sellOrders.stream()
				  .filter(i->i.getPrice()>0 && i.getVolume()>0)
				  .sorted((i1, i2)->Integer.valueOf(i2.getPrice()).compareTo(i1.getPrice()))
				  .forEach(i->System.out.println(SELL_PRINT.concat(String.valueOf(i.getVolume())).concat(AT_THE_RATE).concat(String.valueOf(i.getPrice()))));

		System.out.println("--- BUY ---");
		buyOrders.stream().filter(i->i.getPrice()>0 && i.getVolume()>0)
				 .sorted((i1, i2)->Integer.valueOf(i2.getPrice()).compareTo(i1.getPrice()))
				 .forEach(i->System.out.println(BUY_PRINT.concat(String.valueOf(i.getVolume())).concat(AT_THE_RATE).concat(String.valueOf(i.getPrice()))));
	}


	@Override
	public void execute(List <Buy> buys, List <Sell> sells){
		print(buys,sells);
	}
}