package com.example.fitcometv3;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
*/

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    public void StopwatchClickStart(View view) {
        running = true;
    }

    public void StopwatchesClickStop(View view) {
        running = false;
    }

    public void StopwatchClickReset(View view) {
        running = false;
        seconds = 0;
    }

    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format("%02d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onStop() {
        super.onStop();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (wasRunning) {
            running = true;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (id == R.id.nav_profil) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Profil_Fragment()).commit();
        } else if (id == R.id.nav_pomiar) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Pomiar_Fragment()).commit();
        } else if (id == R.id.nav_message) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Message_Fragment()).commit();
        } else if (id == R.id.nav_setting) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Settings_Fragment()).commit();
        } else if (id == R.id.nav_stopwatch) {
            Intent intent = new Intent(this, StopwatchActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gymplan) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Gymplan_Fragment()).commit();
        } else if (id == R.id.nav_maxweight) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Gymmax_Fragment()).commit();
        } else if (id == R.id.nav_diet) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Diet_Fragment()).commit();
        } else if (id == R.id.nav_dietpor) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.DietPor_Fragment()).commit();
        } else if (id == R.id.nav_dietbook) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Dietbook_Fragment()).commit();
        } else if (id == R.id.nav_test) {

        } else if (id == R.id.nav_calculator) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Calculator_Fragment()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
