package com.owision.order.validate;

import com.owision.order.data.InputData;

public class InputValidator{

    public InputData validate(String instruction){
        InputData data = new InputData();
        if(instruction.equalsIgnoreCase("PRINT") ||
            instruction.equalsIgnoreCase("EXIT")){
            data.setCommand(instruction);
            data.setValid(true);
            return data;
        }

        String[] type=instruction.split(" ");

        if(type.length<2){
            data.setValid(false);
            data.setErrorMessage("Invalid input  command format !!!");
            return data;
        }
        String order=type[0];
        String[] vol_price=type[1].split("@");
        if(vol_price.length<2){
            data.setValid(false);
            data.setErrorMessage("Invalid input  command format !!!");
            return  data;
        }
        int volume;
        try{
            volume=Integer.parseInt(vol_price[0]);
        }catch(NumberFormatException ex){
            data.setValid(false);
            data.setErrorMessage("Invalid input  command format !!!");
            return  data;
        }
        int price;
        try{
            price=Integer.parseInt(vol_price[1]);
        }catch(NumberFormatException ex){
            data.setValid(false);
            data.setErrorMessage("Invalid input  command format !!!");
            return  data;
        }
        if(volume<0||price<0){
            data.setValid(false);
            data.setErrorMessage("Volume and Price Must be Greater than 0 !!!");
            return  data;
        }
        data.setErrorMessage("");
        data.setValid(true);
        data.setPrice(price);
        data.setVolume(volume);
        data.setCommand(order);
        return data;
    }
}
