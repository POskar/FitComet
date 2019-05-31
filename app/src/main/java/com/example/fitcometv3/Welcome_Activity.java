package com.example.fitcometv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Welcome_Activity extends AppCompatActivity {

    Button buttonWelcome;
    EditText etWaga, etWzrost;
    RadioButton rbMezczyzna, rbKobieta;

    String userWaga, userWzrost, userPlec;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    DatabaseReference mDatabaseRef, mDetailsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_);

        mAuth = FirebaseAuth.getInstance();

        buttonWelcome = findViewById(R.id.moveToMain);
        etWaga = findViewById(R.id.editTextWaga_Welcome);
        etWzrost = findViewById(R.id.editTextWzrost_Welcome);
        rbMezczyzna = findViewById(R.id.radioButtonMezczyzna);
        rbKobieta = findViewById(R.id.radioButtonKobieta);

        if(rbMezczyzna.isChecked())
        {
            rbKobieta.setChecked(false);
        }
        if(rbKobieta.isChecked())
        {
            rbMezczyzna.setChecked(false);
        }

        buttonWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userWaga = etWaga.getText().toString().trim();
                userWzrost = etWzrost.getText().toString().trim();
                if(rbMezczyzna.isChecked()) userPlec = "Mezczyzna";
                if(rbKobieta.isChecked()) userPlec = "Kobieta";

                if(!TextUtils.isEmpty(userWaga) && !TextUtils.isEmpty(userWzrost) && !TextUtils.isEmpty(userPlec))
                {
                    mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid());
                    mDatabaseRef.child("isVerified").setValue("verified");

                    mDetailsRef = mDatabaseRef.child("Dane");
                    mDetailsRef.child("Plec").setValue(userPlec);
                    mDetailsRef.child("Waga").setValue(userWaga);
                    mDetailsRef.child("Wzrost").setValue(userWzrost);

                    Intent intent = new Intent(Welcome_Activity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Welcome_Activity.this, "Uzupełnij brakujące pola !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
