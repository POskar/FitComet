package com.example.fitcometv3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public boolean kgTrue = true;
    FirebaseAuth mAuth;
    DatabaseReference mDatabaseRef;

    TextView tvKalorie;
    int userWiek, userWaga, userWzrost;
    double userKalorie, userPoziomAktywnosci;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Zapis.editDodaj = false;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tvKalorie = findViewById(R.id.textKalorie);

        mAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid()).child("Dane");

        mDatabaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("Plec").getValue().toString().equals("mezczyzna"))
                {
                    userWaga = dataSnapshot.child("Waga").getValue(Integer.class);
                    userWzrost = dataSnapshot.child("Wzrost").getValue(Integer.class);
                    userWiek = dataSnapshot.child("Wiek").getValue(Integer.class);
                    userPoziomAktywnosci = dataSnapshot.child("PoziomAktywnosci").getValue(Double.class);

                    userKalorie = (66.5 + (13.7 * userWaga) + (5 * userWzrost) - (6.8 * userWiek)) * userPoziomAktywnosci;
                    tvKalorie.setText(String.format("%.2f", userKalorie));
                }
                else
                {
                    userWaga = dataSnapshot.child("Waga").getValue(Integer.class);
                    userWzrost = dataSnapshot.child("Wzrost").getValue(Integer.class);
                    userWiek = dataSnapshot.child("Wiek").getValue(Integer.class);
                    userPoziomAktywnosci = dataSnapshot.child("PoziomAktywnosci").getValue(Double.class);

                    userKalorie = (655 + (9.6 * userWaga) + (1.85 * userWzrost) - (4.7 * userWiek)) * userPoziomAktywnosci;
                    tvKalorie.setText(String.format("%.2f", userKalorie));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (Zapis.editDodaj == false) {
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finishActivity(0);
            } else {
                Zapis.editDodaj = false;
                super.onBackPressed();//po usunieciu nic sie nie dzieje

            }
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }
        */
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (id == R.id.nav_profil) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Profil_Fragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_pomiar) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Pomiar_Fragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_message) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Message_Fragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_setting) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Settings_Fragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_stopwatch) {
            Intent intent = new Intent(this, StopwatchActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gymplan) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Gymplan_Fragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_maxweight) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Gymmax_Fragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_diet) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Diet_Fragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_dietpor) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.DietPor_Fragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_dietbook) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Dietbook_Fragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_test) {

        } else if (id == R.id.nav_calculator) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Calculator_Fragment()).addToBackStack(null).commit();
        }
        // Intent intent = new Intent(this, LoginActiv.class);
        // startActivity(intent);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    public void WagaButtonLicz(View v) {

        boolean zaznaczony = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.lbs:
                kgTrue = false;
                break;
            case R.id.kg:
                kgTrue = true;
                break;

        }

    }

    public void onClickPrzelicz(View view) {
        final TextView tv1 = (TextView) findViewById(R.id.wyliczWysw);
        final EditText eText = (EditText) findViewById(R.id.Waga);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (eText.length() == 0 || eText.equals("") || eText == null) {
            tv1.setText("Podaj Liczbe");
        } else {
            int wagaprzelicz = Integer.parseInt(eText.getText().toString());//jesli nie dziala dac do ifow

            if (kgTrue == true) {

                double wynik = wagaprzelicz * 0.45359237;
                String FinalWynik = decimalFormat.format(wynik);//new Double(wynik).toString();
                tv1.setText(FinalWynik);
            } else {

                double wynik = wagaprzelicz / 0.45359237;
                String FinalWynik = decimalFormat.format(wynik);
                tv1.setText(FinalWynik);

            }

        }
    }

    public void OnBackClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onDodajPomiarCialaClick(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Dodaj_Pomiar_Fragment()).commit();
    }


    public void onDodajPomiarCialaAnulujClick(View view) {
        Zapis.editDodaj = false;
        Zapis.anuluj = true;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Pomiar_Fragment()).commit();
    }

    public void Wyloguj(View view) {
        Intent intent = new Intent(this, LoginActiv.class);
        startActivity(intent);
    }

}
