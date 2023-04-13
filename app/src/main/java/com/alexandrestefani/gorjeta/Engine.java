package com.alexandrestefani.gorjeta;

public class Engine {

    public double tipValue(String amount,double percent){
        double amountDouble = Double.parseDouble(amount);
        double tipValue = amountDouble*(percent/100);
    return tipValue;
    }

    public double totalValue(String amount,double tip){
        double amountDouble = Double.parseDouble(amount);
        double totalValue = amountDouble + tip;
        return totalValue;
    }




}
