package com.kd.appaks;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.kd.appaks.databinding.ActivityThirdBinding;


public class FragmentThird extends Fragment {
    Dmrd dmrd;
    String oxy,co2;
    Typeface tf;
    ActivityThirdBinding inflate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(inflate==null) {
            inflate = DataBindingUtil.inflate(inflater, R.layout.activity_third, container, false);
            inflate.setTf(tf);
        }  if(dmrd!=null){
            inflate.setDmrd(dmrd);
        }
        if(co2!=null){
            inflate.setCo2(co2);
        }
        if(oxy!=null){
            inflate.setOxy(oxy);
        }
        return inflate.getRoot();
    }
    public void setDmrd( Dmrd dmrd){
        this.dmrd = dmrd;
        if(inflate!=null)
            inflate.setDmrd(dmrd);
    }
    public void setCo2( String co2){
        this.co2 = co2;
        if(inflate!=null)
            inflate.setCo2(co2);
    }
    public void setOxy( String oxy){
        this.oxy = oxy;
        if(inflate!=null)
            inflate.setOxy(oxy);
    }
    public void setTf(Typeface tf){
        this.tf = tf;
    }
}
