package com.kd.appaks;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;


import com.kd.appaks.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding main;
    TextView timeView;
    Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = DataBindingUtil.setContentView(this, R.layout.activity_main);
        timeView = findViewById(R.id.time);
        tf = Typeface.createFromAsset(getAssets(), "fonts/simsun.ttc");
        main.setTf(tf);
        initFragments();
        //getLifecycle().addObserver(new MyObserver());
        receiverLiveData();
        startService();
        initTimer();
        changeFragment();

    }

    public void startService() {
        Intent intent = new Intent(this, ElementsService.class);
        startService(intent);
    }

    FragmentFirst fragmentFirst;
    FragmentSecond fragmentSecond;
    FragmentThird fragmentThird;

    private void initFragments() {
        fragmentFirst = new FragmentFirst();
        fragmentFirst.setTf(tf);
        fragmentSecond = new FragmentSecond();
        fragmentSecond.setTf(tf);
        fragmentThird = new FragmentThird();
        fragmentThird.setTf(tf);
    }

    private void changeFragment() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 20 * 1000);
    }

    Timer timer;
    SimpleDateFormat format = new SimpleDateFormat("yyyy???MM???dd??? E HH:mm", Locale.CHINA);
    int index = 0;

    private void initTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String date = format.format(new Date());
                LiveDataBus.get().with("time").postValue(date);
                Log.i("TAG", "????????????????????????");
                int i = index % 3;
                if (i == 0) {
                    LiveDataBus.get().with("fragment").postValue(fragmentFirst);
                } else if (i == 1) {
                    LiveDataBus.get().with("fragment").postValue(fragmentSecond);
                } else {
                    LiveDataBus.get().with("fragment").postValue(fragmentThird);
                }
                index++;
                if (index == 3000) {
                    index = 0;
                }
            }
        }, 0, 15000);
    }

    public void receiverLiveData() {
        LiveDataBus.get().with("time", String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String time) {
                Log.i("TAG", "????????????????????????");
                //  main.setTime(time);
                timeView.setText(time);
            }
        });
        LiveDataBus.get().with("fragment", Fragment.class).observe(this, new Observer<Fragment>() {
            @Override
            public void onChanged(Fragment fragment) {
                Log.i("TAG", "????????????????????????");
                //  main.setTime(time);
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.content, fragment).commit();
            }
        });
        LiveDataBus.get().with("dmgd", Dmgd.class).observe(this, new Observer<Dmgd>() {
            @Override
            public void onChanged(Dmgd s) {
                Log.i("TAG", "????????????????????????");
                //  main.setTime(time);
                fragmentFirst.setDmgd(s);

            }
        });
        LiveDataBus.get().with("dmsd", Dmsd.class).observe(this, new Observer<Dmsd>() {
            @Override
            public void onChanged(Dmsd s) {
                Log.i("TAG", "????????????????????????");
                //  main.setTime(time);

            }
        });
        LiveDataBus.get().with("dm5d", Dm5d.class).observe(this, new Observer<Dm5d>() {
            @Override
            public void onChanged(Dm5d s) {
                Log.i("TAG", "????????????????????????");
                //  main.setTime(time);
                //fragmentSecond.setDm5d(s);
            }
        });
        LiveDataBus.get().with("dm4d", String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.i("TAG", "????????????????????????");

                fragmentThird.setCo2(s);
            }
        });
        LiveDataBus.get().with("dmrd", Dmrd.class).observe(this, new Observer<Dmrd>() {
            @Override
            public void onChanged(Dmrd s) {
                Log.i("TAG", "????????????????????????");
             //   fragmentFirst.setDmrd(s);
                fragmentThird.setDmrd(s);
            }
        });
        LiveDataBus.get().with("dmaq", Dmaq.class).observe(this, new Observer<Dmaq>() {
            @Override
            public void onChanged(Dmaq s) {
                Log.i("TAG", "????????????????????????");
                fragmentSecond.setDmaq(s);
            }
        });
        LiveDataBus.get().with("oxy", String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.i("TAG", "????????????????????????");
                fragmentThird.setOxy(s);
            }
        });
    }

   /* @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }*/
}