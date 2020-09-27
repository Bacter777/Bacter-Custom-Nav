package com.bacter.bacter.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bacter.bacter.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.Transition;

public class BacterBurnsAhuk extends AppCompatActivity
{
    private KenBurnsView bacterBurns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bacter_burns_ahuk);

        bacterBurns = findViewById(R.id.bacterBurns);
        bacterBurns.setTransitionListener(new KenBurnsView.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
            }
            @Override
            public void onTransitionEnd(Transition transition) {
            }
        });
    }
}