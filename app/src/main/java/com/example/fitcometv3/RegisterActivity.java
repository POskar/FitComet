package com.example.fitcometv3;

import android.content.Intent;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextUsername, editTextEmail, editTextPassword;
    Button buttonRejestracja;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    DatabaseReference mDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        editTextUsername = (EditText) findViewById(R.id.etUsername_Register);
        editTextEmail = (EditText) findViewById(R.id.etEmail_Register);
        editTextPassword = (EditText) findViewById(R.id.etPassword_Register);
        buttonRejestracja = (Button) findViewById(R.id.btnRejestracja);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null)
                {

                }
                else
                {

                }
            }
        };

        buttonRejestracja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String userUsernameString, userEmailString, userPasswordString;

                userUsernameString = editTextUsername.getText().toString().trim();
                userEmailString = editTextEmail.getText().toString().trim();
                userPasswordString = editTextPassword.getText().toString().trim();

                if(!TextUtils.isEmpty(userUsernameString) && !TextUtils.isEmpty(userEmailString) && !TextUtils.isEmpty(userPasswordString))
                {
                    mAuth.createUserWithEmailAndPassword(userEmailString, userPasswordString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid());

                                mDatabaseRef.child("isVerified").setValue("unverified");
                                mDatabaseRef.child("Username").setValue(userUsernameString);
                                mDatabaseRef.child("Email").setValue(userEmailString);
                                mDatabaseRef.child("Password").setValue(userPasswordString);

                                startActivity(new Intent(RegisterActivity.this, LoginActiv.class));
                                Toast.makeText(RegisterActivity.this, "Stworzono użytkownika", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                try {
                                    throw task.getException();
                                }
                                catch (FirebaseAuthWeakPasswordException weakPassword)
                                {
                                    Toast.makeText(RegisterActivity.this, "Hasło jest za słabe !", Toast.LENGTH_LONG).show();
                                }
                                catch (FirebaseAuthInvalidCredentialsException malformedEmail)
                                {
                                    Toast.makeText(RegisterActivity.this, "Wprowadź poprwany email !", Toast.LENGTH_LONG).show();
                                }
                                catch (FirebaseAuthUserCollisionException existEmail)
                                {
                                    Toast.makeText(RegisterActivity.this, "Email już zajęty !", Toast.LENGTH_LONG).show();
                                } catch (Exception e) {
                                    Toast.makeText(RegisterActivity.this, "Nie udało się stworzyć użytkownika", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Uzupełnij brakujące pola !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}