package com.bacter.bacter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.bacter.bacter.R;

import in.codeshuffle.typewriterview.TypeWriterView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView splash_image = findViewById(R.id.splash_image);
        final TypeWriterView dev = findViewById(R.id.dev);

        Context context;
        Animation anim1 = AnimationUtils.loadAnimation(splash_image.getContext(),R.anim.translate);
        //start animation
        dev.animateText("Developed by:BdFreak");
        dev.setDelay(100);
        splash_image.startAnimation(anim1);

        final Intent intent = new Intent(this,MainActivity.class);
        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(5000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}