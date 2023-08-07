package com.example.thithuandroidnetw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    EditText editTextUsername, editTextPassword;
    Button buttonregis, tosignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextPassword = findViewById(R.id.editTextNewPassword);
        editTextUsername = findViewById(R.id.editTextNewUsername);
        buttonregis = findViewById(R.id.buttonSignUp);
        tosignin = findViewById(R.id.tosignin);


        buttonregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(register.this, MainActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(register.this, "login okkkk", Toast.LENGTH_SHORT).show();
                                    finishAffinity();

                                } else {
                                    Toast.makeText(register.this, "login fall", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}