package com.owision.order.command.impl;

import com.owision.order.command.OrderCommand;
import com.owision.order.command.data.Buy;
import com.owision.order.command.data.Sell;

import java.util.List;

public class Trade implements OrderCommand{

	@Override
	public void execute(List <Buy> buys, List <Sell> sells){
		trade(buys,sells);
	}


	private void trade(List<Buy> buyOrders, List<Sell> sellOrders) {
		for(Buy buyOrder : buyOrders){
			for(Sell sellOrder : sellOrders){
				if(buyOrder.getVolume()>0&&sellOrder.getVolume()>0){

					//Start trade if the buy order price is equal to or higher than the sell order price
					if(buyOrder.getPrice()>=sellOrder.getPrice()){

						//Check if the sell order was entered before the buy order
						if(buyOrder.getTimeStamp()>sellOrder.getTimeStamp()){
							if(sellOrder.getVolume()>=buyOrder.getVolume()){
								System.out.println("TRADE "+buyOrder.getVolume()+"@"+sellOrder.getPrice());
								sellOrder.setVolume(sellOrder.getVolume()-buyOrder.getVolume());
								buyOrder.setVolume(0);
							}else{
								System.out.println("TRADE "+sellOrder.getVolume()+"@"+sellOrder.getPrice());
								buyOrder.setVolume(buyOrder.getVolume()-sellOrder.getVolume());
								sellOrder.setVolume(0);
							}
						}

						//Check if the buy order was entered before the sell order
						if(sellOrder.getTimeStamp()>buyOrder.getTimeStamp()){
							if(sellOrder.getVolume()>=buyOrder.getVolume()){
								System.out.println("TRADE "+buyOrder.getVolume()+"@"+buyOrder.getPrice());
								sellOrder.setVolume(sellOrder.getVolume()-buyOrder.getVolume());
								buyOrder.setVolume(0);
							}else{
								System.out.println("TRADE "+sellOrder.getVolume()+"@"+buyOrder.getPrice());
								buyOrder.setVolume(buyOrder.getVolume()-sellOrder.getVolume());
								sellOrder.setVolume(0);
							}
						}
					}
				}
			}
		}
	}
}
