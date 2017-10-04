package com.awad.hamudi.muhammadshoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LogIn extends AppCompatActivity
{
    private EditText etEm;
    private EditText etP;
    private Button btin;
    private Button btForgot;
    private  Button btUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEm = (EditText) findViewById(R.id.etEm);
        etP = (EditText) findViewById(R.id.etP);
        btin = (Button) findViewById(R.id.btin);
        btForgot = (Button) findViewById(R.id.btForgot);
        btUp = (Button) findViewById(R.id.btUp);
    }
}
