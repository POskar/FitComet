package com.example.fitcometv3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActiv extends AppCompatActivity implements TextWatcher,
        CompoundButton.OnCheckedChangeListener {
    //
    private CheckBox rem_userpass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String PREF_NAME = "prefs";
    private static final String KEY_REMEMBER = "remember";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASS = "password";
    //

    Button btnLogowanie;
    TextView btnRejestracja, btnZapomnianeHaslo;
    EditText editTextEmail, editTextPassword;

    String userEmailString, userPasswordString;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    DatabaseReference mDatabaseRef;

    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btnLogowanie = findViewById(R.id.btnlogowanie);
        btnRejestracja = findViewById(R.id.btnregister);
        btnZapomnianeHaslo = findViewById(R.id.btnforgotpass);
        editTextEmail = findViewById(R.id.etLogin);
        editTextPassword = findViewById(R.id.etPassword);

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        rem_userpass = findViewById(R.id.checkBoxRemember);
        if (sharedPreferences.getBoolean(KEY_REMEMBER, false))
            rem_userpass.setChecked(true);
        else
            rem_userpass.setChecked(false);

        editTextEmail.setText(sharedPreferences.getString(KEY_EMAIL, ""));
        editTextPassword.setText(sharedPreferences.getString(KEY_PASS, ""));

        editTextEmail.addTextChangedListener((TextWatcher) this);
        editTextPassword.addTextChangedListener((TextWatcher) this);
        rem_userpass.setOnCheckedChangeListener(this);

        //

        mAuth = FirebaseAuth.getInstance();

        btnLogowanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userEmailString = editTextEmail.getText().toString().trim();
                userPasswordString = editTextPassword.getText().toString().trim();

                if (!TextUtils.isEmpty(userEmailString) && !TextUtils.isEmpty(userPasswordString)) {
                    mAuth.signInWithEmailAndPassword(userEmailString, userPasswordString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid());
                                mDatabaseRef.child("Password").setValue(userPasswordString);

                                mDatabaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        if(!dataSnapshot.child("isVerified").getValue().toString().equals("verified")){
                                            Intent intent = new Intent(LoginActiv.this, Welcome_Activity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                        }
                                        else
                                        {
                                            Intent intent = new Intent(LoginActiv.this, MainActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });
                            } else {
                                Toast.makeText(LoginActiv.this, "Nie udało się zalogować", Toast.LENGTH_LONG).show();
                            }
                        }

                    });
                } else {
                    Toast.makeText(LoginActiv.this, "Uzupełnij brakujące pola !", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnRejestracja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActiv.this, RegisterActivity.class));
            }
        });

        btnZapomnianeHaslo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActiv.this, ForgotPassActivity.class));
            }
        });
    }

    public void LoginClick(View view) {
        Intent intent = new Intent(LoginActiv.this, Welcome_Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        managePrefs();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        managePrefs();
    }

    private void managePrefs() {
        if (rem_userpass.isChecked()) {
            editor.putString(KEY_EMAIL, editTextEmail.getText().toString().trim());
            editor.putString(KEY_PASS, editTextPassword.getText().toString().trim());
            editor.putBoolean(KEY_REMEMBER, true);
            editor.apply();
        } else {
            editor.putBoolean(KEY_REMEMBER, false);
            editor.remove(KEY_PASS);//editor.putString(KEY_PASS,"");
            editor.remove(KEY_EMAIL);//editor.putString(KEY_USERNAME, "");
            editor.apply();
        }
    }
}
