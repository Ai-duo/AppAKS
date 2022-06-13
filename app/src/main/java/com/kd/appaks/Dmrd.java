package com.kd.appaks;

import android.util.Log;

public class Dmrd {
    public String zfs,rzh,gh,zwx;

    public Dmrd(String zfs, String rzh, String gh) {
        this.zfs = "总辐射:"+zfs+"W²/m³";
        this.rzh = "小时日照:"+rzh+"min";
        this.gh = "光合:"+gh+"W²/m³";
        Log.i("TAG",toString());
    }

    public Dmrd(String gh, String zwx) {
        this.gh = "光合:"+gh+"W²/m³";
        this.zwx = "紫外:"+zwx+"W²/m³";
    }

    @Override
    public String toString() {
        return "Dmrd{" +
                "zfs='" + zfs + '\'' +
                ", rzh='" + rzh + '\'' +
                ", gh='" + gh + '\'' +
                '}';
    }
}
