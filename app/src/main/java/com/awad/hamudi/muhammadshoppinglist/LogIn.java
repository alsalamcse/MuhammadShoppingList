package com.awad.hamudi.muhammadshoppinglist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.awad.hamudi.muhammadshoppinglist.mainlistfragments.MainListActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity implements View.OnClickListener
{
    private EditText etEm;
    private EditText etP;
    private Button btnin;
    private Button btnForgot;
    private  Button btnUp;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEm = (EditText) findViewById(R.id.etEm);
        etP = (EditText) findViewById(R.id.etP);
        btnin = (Button) findViewById(R.id.btnin);
       btnin.setOnClickListener(this);
        btnForgot = (Button) findViewById(R.id.btnForgot);
        btnUp = (Button) findViewById(R.id.btnUp);
       btnUp.setOnClickListener(this);
        auth=FirebaseAuth.getInstance();
        firebaseUser=auth.getCurrentUser();
            }

            private void dataHandler() {
                String stemail = etEm.getText().toString();
                String stpassword = etP.getText().toString();
                    signIn(stemail, stpassword);
                }



            private void signIn(String email, String passw) {
                auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(LogIn.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(LogIn.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(LogIn.this,MainListActivity.class);
                            startActivity(intent);
                             finish();
                        }
                        else
                        {
                            Toast.makeText(LogIn.this, "signIn failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            task.getException().printStackTrace();
                        }
                    }
                });
            }

    @Override
    public void onClick(View view)
    {
        if (view==btnin)
        {
            dataHandler();
        }

        if (view==btnUp)
        {
            Intent i = new Intent(this,signup.class);
            startActivity(i);
        }
    }
}
