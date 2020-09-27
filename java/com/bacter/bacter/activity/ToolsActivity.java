package com.bacter.bacter.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.bacter.bacter.R;

public class ToolsActivity extends AppCompatActivity
{
    private Activity mActivity;
    private Button CompassBtn;
    private Button strobeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        Context mContext = getApplicationContext();
        mActivity = ToolsActivity.this;

        strobeBtn = findViewById(R.id.strobeBtn);
        strobeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToStrobe();
            }
        });
        CompassBtn = findViewById(R.id.compassBtn);
        CompassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCompass();
            }
        });
    }
    public void moveToStrobe()
    {
        Intent intent = new Intent(this,StrobeActivity.class);
        startActivity(intent);
    }
    public void moveToCompass()
    {
        Intent intent = new Intent(this,CompassActivity.class);
        startActivity(intent);
    }
}