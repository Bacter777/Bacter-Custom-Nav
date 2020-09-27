package com.bacter.bacter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bacter.bacter.R;
import com.bacter.bacter.helper.SampleHelper;

public class HeadlessFragmentActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(new LinearLayout(this));
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content,new HeadlessFragment()).commit();
    }
    public static class HeadlessFragment extends Fragment
    {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
        {
            return inflater.inflate(R.layout.activity_about,container,false);
        }
        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState)
        {
            super.onActivityCreated(savedInstanceState);
            setRetainInstance(true);
            SampleHelper.with(getActivity()).loadAbout();
        }
    }
}
