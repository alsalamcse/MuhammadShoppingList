package com.awad.hamudi.muhammadshoppinglist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity implements OnClickListener
{
    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etRePass;
    private EditText etPhone;
    private Button btnSave;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etRePass = (EditText) findViewById(R.id.etRePass);
        etPhone = (EditText) findViewById(R.id.etPhone);
        btnSave = (Button) findViewById(R.id.btnSave);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();


        btnSave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }

    private void dataHandler() {
        String stemail = etEmail.getText().toString();
        String stpassword = etPassword.getText().toString();
        String stname = etName.getText().toString();
        String phone = etPhone.getText().toString();
        String repassword = etRePass.getText().toString();
        boolean isOk = true;
        if (stemail.length() == 0 || stemail.indexOf('@') < 1) {
            etEmail.setError("WRONG EMAIL");
            isOk = false;
        }
        if (stpassword.length() < 8) {
            etPassword.setError("BAD PASSWORD");
            isOk = false;
        }
        if (isOk) {
            creatAcount(stemail, stpassword);
        }
    }

    private void creatAcount(String email, String passw) {
        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(signup.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(signup.this, "Authentication Failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
        FirebaseAuth.getInstance().signOut();
    }

    {


    }

    @Override
    public void onClick(View view)
    {
        if (btnSave==view)
        {
            dataHandler();
        }
    }
}
