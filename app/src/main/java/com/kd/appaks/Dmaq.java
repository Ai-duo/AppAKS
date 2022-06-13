package com.kd.appaks;

public class Dmaq {
    public String so2,co,no2,o3,pm25,pm10;

    public Dmaq(String so2, String co, String no2, String o3, String pm25, String pm10) {
        this.so2 = "SO2:"+so2+"ug/m³";
        this.co = "CO:"+co+"mg/m3";
        this.no2 = "NO2:"+no2+"ug/m³";
        this.o3 = "O3:"+o3+"ug/m³";
        this.pm25 ="PM2.5:"+pm25+"ug/m³";
        this.pm10 = "PM10:"+pm10+"ug/m³";
    }
}
