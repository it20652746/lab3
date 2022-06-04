package com.example.tempraturecalculatertute2;

public class Calculations {
    protected float convertCelciusToFarhenheit(float value){
        float ans = (value * 9/5) + 32;
        return ans;
    }

    protected float convertFarenheitToCelcius(float value){
        float ans = (value - 32) * 5/9;
        return ans;
    }

}
