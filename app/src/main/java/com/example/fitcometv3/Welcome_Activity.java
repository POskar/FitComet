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

public class Welcome_Activity extends AppCompatActivity {

  //  Button buttonWelcome;
  //  EditText etWaga, etWzrost;
    ImageView btnMezczyzna, btnKobieta, btnaktyw1, btnaktyw2, btnaktyw3, btnaktyw4;

   // String userWaga, userWzrost, userPlec;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    DatabaseReference mDatabaseRef, mDetailsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_);

        mAuth = FirebaseAuth.getInstance();

//
//        buttonWelcome = findViewById(R.id.moveToMain);
//        etWaga = findViewById(R.id.editTextWaga_Welcome);
//        etWzrost = findViewById(R.id.editTextWzrost_Welcome);
          btnMezczyzna = findViewById(R.id.Mezczyzna);
          btnKobieta = findViewById(R.id.Kobieta);
          btnaktyw1 = findViewById(R.id.pozaktyw1);
          btnaktyw2 = findViewById(R.id.pozaktyw2);
          btnaktyw3 = findViewById(R.id.pozaktyw3);
          btnaktyw4 = findViewById(R.id.pozaktyw4);
//
//
//        if(rbMezczyzna.isChecked())
//        {
//            rbKobieta.setChecked(false);
//        }
//        if(rbKobieta.isChecked())
//        {
//            rbMezczyzna.setChecked(false);
//        }


//        buttonWelcome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                userWaga = etWaga.getText().toString().trim();
//                userWzrost = etWzrost.getText().toString().trim();
//                if(rbMezczyzna.isChecked()) userPlec = "Mezczyzna";
//                if(rbKobieta.isChecked()) userPlec = "Kobieta";
//
//                if(!TextUtils.isEmpty(userWaga) && !TextUtils.isEmpty(userWzrost) && !TextUtils.isEmpty(userPlec))
//                {
//                    mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid());
//                    mDatabaseRef.child("isVerified").setValue("verified");
//
//                    mDetailsRef = mDatabaseRef.child("Dane");
//                    mDetailsRef.child("Plec").setValue(userPlec);
//                    mDetailsRef.child("Waga").setValue(userWaga);
//                    mDetailsRef.child("Wzrost").setValue(userWzrost);
//
//                    Intent intent = new Intent(Welcome_Activity.this, MainActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                }
//                else
//                {
//                    Toast.makeText(Welcome_Activity.this, "Uzupełnij brakujące pola !", Toast.LENGTH_LONG).show();
//                }
//            }
//        });


    }

    public void ZmianaKoloruMezczyzna(View view) {
        btnMezczyzna.setImageDrawable(getResources().getDrawable(R.drawable.mezczyznapoklik));
        btnKobieta.setImageDrawable(getResources().getDrawable(R.drawable.kobietanieprzycisnieta));
    }

    public void ZmianaKoloruKobieta(View view) {
        btnKobieta.setImageDrawable(getResources().getDrawable(R.drawable.kobietapoklik));
        btnMezczyzna.setImageDrawable(getResources().getDrawable(R.drawable.mezczyznanieprzycisniety));
    }

    public void ZmianaKoloruPoziomAktywn1(View view) {
        btnaktyw1.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci1wcisniety));
        btnaktyw2.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci2));
        btnaktyw3.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci3));
        btnaktyw4.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci4));
    }

    public void ZmianaKoloruPoziomAktywn2(View view) {
        btnaktyw1.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci1));
        btnaktyw2.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci2wcisniety));
        btnaktyw3.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci3));
        btnaktyw4.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci4));
    }

    public void ZmianaKoloruPoziomAktywn3(View view) {
        btnaktyw1.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci1));
        btnaktyw2.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci2));
        btnaktyw3.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci3wcisniety));
        btnaktyw4.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci4));
    }

    public void ZmianaKoloruPoziomAktywn4(View view) {
        btnaktyw1.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci1));
        btnaktyw2.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci2));
        btnaktyw3.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci3));
        btnaktyw4.setImageDrawable(getResources().getDrawable(R.drawable.przyciskaktywnosci4wcisniety));
    }
}
