package com.kd.appaks;

import android.util.Log;

public class Dmgd {
    public String wd,sd,cm10w,cm20w,cm30w,cm40w,cm50w;
    public String fs,fx,qy,yl;
    public Dmgd(String wd, String sd, String cm10w, String cm20w, String cm30w, String cm40w, String cm50w) {
        this.wd = "温度:"+wd+"℃";
        this.sd = "相对湿度:"+sd+"%";
        this.cm10w = "10CM:"+cm10w+"℃";
        this.cm20w = "20CM:"+cm20w+"℃";
        this.cm30w = "30CM:"+cm30w+"℃";
        this.cm40w = "40CM:"+cm40w+"℃";
        this.cm50w = "50CM:"+cm50w+"℃";
        Log.i("TAG",toString());
    }

    public Dmgd(String wd, String sd, String fs, String fx, String qy, String yl) {
        this.wd = "温度:"+wd+"℃";
        this.sd = "相对湿度:"+sd+"%";
        this.fs = "风速:"+fs+"m/s";
        this.fx = "风向:"+fx;
        this.qy = "气压:"+qy+"hpa";
        this.yl = "降水:"+yl+"mm";
    }

    @Override
    public String toString() {
        return "Dmgd{" +
                "wd='" + wd + '\'' +
                ", sd='" + sd + '\'' +
                ", cm10w='" + cm10w + '\'' +
                ", cm20w='" + cm20w + '\'' +
                ", cm30w='" + cm30w + '\'' +
                ", cm40w='" + cm40w + '\'' +
                ", cm50w='" + cm50w + '\'' +
                '}';
    }
}
