package com.yicj.weather;

public class WeatherService {

    private WeatherSource weatherSource ;

    public WeatherService(WeatherSource weatherSource){
        this.weatherSource = weatherSource ;
    }

    //向外界提供方法
    public String getType(){
        return weatherSource.getType() ;
    }

    public String getRate(){
        return weatherSource.getRate() ;
    }
}
