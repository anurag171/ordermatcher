package com.owision.order.data;

public class InputData{

    private String command;
    private int volume;
    private int price;
    private boolean valid;
    private String errorMessage;

    public String getCommand(){
        return command;
    }

    public void setCommand(String command){
        this.command=command;
    }

    public int getVolume(){
        return volume;
    }

    public void setVolume(int volume){
        this.volume=volume;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price=price;
    }

    public boolean isValid(){
        return valid;
    }

    public void setValid(boolean valid){
        this.valid=valid;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage=errorMessage;
    }
}
