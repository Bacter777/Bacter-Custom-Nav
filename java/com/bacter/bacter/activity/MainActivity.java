package com.bacter.bacter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bacter.bacter.R;
import com.bacter.bacter.fragment.CalendarFragment;
import com.bacter.bacter.fragment.HomeFragment;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity
{
    Executor executor;
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    SNavigationDrawer sNavigationDrawer;
    Class fragmentClass;
    public static Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set biometric at runtime
        biometricPrompt = new BiometricPrompt(this, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(MainActivity.this,errString,Toast.LENGTH_LONG).show();
                MainActivity.this.finish();
            }
            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(MainActivity.this,"AUTHENTICATION SUCCESSFUL!",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(MainActivity.this,"AUTHENTICATION FAILED!!",Toast.LENGTH_LONG).show();
            }
        });
        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Bacter Says...")
                .setSubtitle("Fingerprint ID Required")
                .setDescription("Touch Fingerprint Sensor")
                .setNegativeButtonText("EXIT")
                .build();
        biometricPrompt.authenticate(promptInfo);
        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
        sNavigationDrawer = findViewById(R.id.navigation_drawer);
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Home",R.drawable.home));
        menuItems.add(new MenuItem("Calendar",R.drawable.dashboard));
        menuItems.add(new MenuItem("Tools",R.drawable.flash));
        menuItems.add(new MenuItem("About",R.drawable.about));
        menuItems.add(new MenuItem("Exit",R.drawable.exit));

        sNavigationDrawer.setMenuItemList(menuItems);
        fragmentClass = BacterBurnsAhuk.class;

        try
        {
            fragment = (Fragment)fragmentClass.newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if (fragment != null)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
                    .replace(R.id.frameLayout,fragment).commit();
        }
        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position" +position);
                switch (position)
                {
                    case 0:
                        {
                            fragmentClass = HomeFragment.class;
                            break;
                        }
                    case 1:
                        {
                            fragmentClass = CalendarFragment.class;
                            break;
                        }
                    case 2:
                        {
                            tools();
                            break;
                        }
                    case 3:
                        {
                            fragmentClass = HeadlessFragmentActivity.HeadlessFragment.class;
                            break;
                        }
                    case 4:
                        {
                            sNavigationDrawer.closeDrawer();
                            finish();
                        }
                }
            }
        });
        sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {
            @Override
            public void onDrawerOpening() {

            }

            @Override
            public void onDrawerClosing()
            {
                try
                {
                    fragment = (Fragment)fragmentClass.newInstance();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                if (fragment != null)
                {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out).replace(R.id.frameLayout,fragment).commit();
                }
            }

            @Override
            public void onDrawerOpened() {

            }

            @Override
            public void onDrawerClosed() {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }

        });
    }
    public void tools()
    {
        Intent compass = new Intent(this,ToolsActivity.class);
        startActivity(compass);
    }
    public void bacterBurnsAhuk()
    {
        Intent AHUK = new Intent(this,BacterBurnsAhuk.class);
        startActivity(AHUK);
    }
}