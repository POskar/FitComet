package com.example.fitcometv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.xw.repo.BubbleSeekBar;

public class Welcome_Activity extends AppCompatActivity {

    Button buttonMoveToMain, buttonHelp;
    ImageView btnMezczyzna, btnKobieta, btnaktyw1, btnaktyw2, btnaktyw3, btnaktyw4;
    BubbleSeekBar suwakWiek, suwakWaga, suwakWzrost;

    String userPlec;
    int userWaga = 0, userWzrost = 0, userWiek = 0;
    double userPoziomAktywnosci = 0;

    FirebaseAuth mAuth;
    DatabaseReference mDatabaseRef, mDetailsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_);

        mAuth = FirebaseAuth.getInstance();

        btnMezczyzna = findViewById(R.id.Mezczyzna);
        btnKobieta = findViewById(R.id.Kobieta);
        btnaktyw1 = findViewById(R.id.pozaktyw1);
        btnaktyw2 = findViewById(R.id.pozaktyw2);
        btnaktyw3 = findViewById(R.id.pozaktyw3);
        btnaktyw4 = findViewById(R.id.pozaktyw4);
        suwakWaga = findViewById(R.id.wagasuwak);
        suwakWiek = findViewById(R.id.wieksuwak);
        suwakWzrost = findViewById(R.id.wzrostsuwak);
        buttonMoveToMain = findViewById(R.id.buttonMoveToMain);
        buttonHelp = findViewById(R.id.buttonHelp);

        suwakWaga.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                userWaga = suwakWaga.getProgress();
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

            }
        });
        suwakWiek.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                userWiek = suwakWiek.getProgress();
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

            }
        });
        suwakWzrost.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                userWzrost = suwakWzrost.getProgress();
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

            }
        });

        btnMezczyzna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPlec = "mezczyzna";
                btnMezczyzna.setImageDrawable(getResources().getDrawable(R.drawable.mezczyznapoklik));
                btnKobieta.setImageDrawable(getResources().getDrawable(R.drawable.kobietanieprzycisnieta));
            }
        });

        btnKobieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPlec = "kobieta";
                btnKobieta.setImageDrawable(getResources().getDrawable(R.drawable.kobietapoklik));
                btnMezczyzna.setImageDrawable(getResources().getDrawable(R.drawable.mezczyznanieprzycisniety));
            }
        });

        btnaktyw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPoziomAktywnosci = 1.0;
                btnaktyw1.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci1wcisniety));
                btnaktyw2.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci2));
                btnaktyw3.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci3));
                btnaktyw4.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci4));
            }
        });

        btnaktyw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPoziomAktywnosci = 1.2;
                btnaktyw1.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci1));
                btnaktyw2.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci2wcisniety));
                btnaktyw3.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci3));
                btnaktyw4.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci4));
            }
        });

        btnaktyw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPoziomAktywnosci = 1.4;
                btnaktyw1.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci1));
                btnaktyw2.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci2));
                btnaktyw3.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci3wcisniety));
                btnaktyw4.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci4));
            }
        });

        btnaktyw4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPoziomAktywnosci = 1.6;
                btnaktyw1.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci1));
                btnaktyw2.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci2));
                btnaktyw3.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci3));
                btnaktyw4.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci4wcisniety));
            }
        });

        buttonMoveToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userWaga!=0 && userWzrost!=0 && userWiek!=0 && userPoziomAktywnosci!=0 && !TextUtils.isEmpty(userPlec))
                {
                    mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid());
                    mDatabaseRef.child("isVerified").setValue("verified");

                    mDetailsRef = mDatabaseRef.child("Dane");
                    mDetailsRef.child("Waga").setValue(userWaga);
                    mDetailsRef.child("Wiek").setValue(userWiek);
                    mDetailsRef.child("Wzrost").setValue(userWzrost);
                    mDetailsRef.child("Plec").setValue(userPlec);
                    mDetailsRef.child("PoziomAktywnosci").setValue(userPoziomAktywnosci);

                    Intent intent = new Intent(Welcome_Activity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                 else
                {
                   Toast.makeText(Welcome_Activity.this, "Uzupełnij brakujące dane !", Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    public void openDialog()
    {
        HelpDialog helpDialog = new HelpDialog();
        helpDialog.show(getSupportFragmentManager(), "help dialog");
    }
}
