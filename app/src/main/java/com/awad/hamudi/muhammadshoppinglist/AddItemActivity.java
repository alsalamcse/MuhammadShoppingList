package com.awad.hamudi.muhammadshoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddItemActivity extends AppCompatActivity
{
    private EditText etamount;
    private EditText etName;
    private EditText etPrice;
    private EditText etUnits;
    private ImageButton iBtnImage;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        etamount = (EditText) findViewById(R.id.etamount);
        etName = (EditText) findViewById(R.id.etName);
        etPrice = (EditText) findViewById(R.id.etPrice);
        etUnits = (EditText) findViewById(R.id.etUnits);
        iBtnImage = (ImageButton) findViewById(R.id.iBtnImage);
        btnSave = (Button) findViewById(R.id.btnSave);
    }
    public void dataHandler(){
        String stname= etName.getText().toString();
        String stAmount= etamount.getText().toString();
        String stPrice= etPrice.getText().toString();
        String stUnits= etUnits.getText().toString();
        double amount= Double.parseDouble(stAmount);
        double price = Double.parseDouble(stPrice);
    }
}
