package com.owision.order.command;

import com.owision.order.command.data.Buy;
import com.owision.order.command.data.Sell;

import java.util.List;

public interface OrderCommand{
    void execute(List <Buy> buys, List<Sell> sells);
}
