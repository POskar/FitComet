package com.example.fitcometv3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class ForgotPassActivity extends AppCompatActivity {

    Button buttonPrzypomnij;
    EditText etEmail;

    String userEmail;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        mAuth = FirebaseAuth.getInstance();

        buttonPrzypomnij = findViewById(R.id.buttonPrzypomnij);
        etEmail = findViewById(R.id.editTextEmail_Przypomnij);

        buttonPrzypomnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userEmail = etEmail.getText().toString().trim();

                if(!TextUtils.isEmpty(userEmail))
                {
                    mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                                Toast.makeText(ForgotPassActivity.this, "Email z hasłem został wysłany !", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else
                {
                    Toast.makeText(ForgotPassActivity.this, "Podaj email !", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
