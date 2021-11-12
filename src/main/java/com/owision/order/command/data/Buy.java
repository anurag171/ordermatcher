package com.owision.order.command.data;

import com.owision.order.command.OrderType;
import com.owision.order.types.Order;

public class Buy implements  OrderType{
	
	private int volume;
	private int price;
	private long timeStamp;
	
	public Buy(int volume, int price, long timeStamp) {
		this.volume = volume;
		this.price = price;
		this.timeStamp = timeStamp;
	}

	@Override
	public String getOrderType(){
		return Order.BUY.name();
	}

	public int getVolume(){
		return volume;
	}

	public int getPrice(){
		return price;
	}

	public long getTimeStamp(){
		return timeStamp;
	}

	public void setVolume(int volume){
		this.volume=volume;
	}

	public void setPrice(int price){
		this.price=price;
	}

	public void setTimeStamp(long timeStamp){
		this.timeStamp=timeStamp;
	}
}
