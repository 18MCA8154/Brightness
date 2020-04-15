package com.example.brightness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bright;
    Calendar min_time,max_time,time;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bright = findViewById(R.id.bright);
        bright.setOnClickListener(this);

        time = Calendar.getInstance();
        time.setTimeInMillis(System.currentTimeMillis());
        min_time.set(Calendar.HOUR_OF_DAY,5);
        long m = min_time.getTimeInMillis();
        max_time.set(Calendar.HOUR_OF_DAY,19);
        long max = max_time.getTimeInMillis();

    }

    @Override
    public void onClick(View v) {
        if (v == bright){
            setbright();
        }

    }


    public void setbright() {
        if((time.compareTo(min_time)>0) && (time.compareTo(max_time)<0)){

            Settings.System.putInt(this.getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS, 0);
        }

        else {
            Settings.System.putInt(this.getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS, 255);
        }

    }

}

