package com.awad.hamudi.muhammadshoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.awad.hamudi.muhammadshoppinglist.mainlistfragments.MainListActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity
{
    private EditText etEm;
    private EditText etP;
    private Button btnin;
    private Button btnForgot;
    private  Button btnUp;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEm = (EditText) findViewById(R.id.etEm);
        etP = (EditText) findViewById(R.id.etP);
        btnin = (Button) findViewById(R.id.btnin);
        btnin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getBaseContext(), MainListActivity.class);
                startActivity(i);

            }
        });
        btnForgot = (Button) findViewById(R.id.btnForgot);
        btnUp = (Button) findViewById(R.id.btnUp);
    }
}
