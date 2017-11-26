package com.awad.hamudi.muhammadshoppinglist;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.awad.hamudi.muhammadshoppinglist.data.product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }
    public void dataHandler()
    {
        //1. get data from the fields
        String stname= etName.getText().toString();
        String stAmount= etamount.getText().toString();
        String stPrice= etPrice.getText().toString();
        String stUnits= etUnits.getText().toString();
        //2. todo Validate fields input
        //isok=true...

        //3. data manipulation
        double amount = Double.parseDouble(stAmount);
        double price = Double.parseDouble(stPrice);


        //4. building data object
        product p= new product();
        p.setName(stname);
        p.setName(stAmount);
        p.setPrice(price);
        p.setIscompleted(false);



        //5. to get user email..... user info
        FirebaseAuth auth=FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
        String email=user.getEmail();
        email= email.replace('.','*');

        //6. building data refernce = data path = data address
        DatabaseReference reference;
        //todo לקבלת קישור למסד הניתונים שלנו
        //todo קישור הינו לשורש של המסד הניתונים
        reference = FirebaseDatabase.getInstance().getReference();
        //7. saving data on the firebase database
        reference.child(email).child("myList").push().setValue(p).
                addOnCompleteListener(this, new OnCompleteListener<Void>() {//8. add CompleteListener to check if the insertion done
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(AddItemActivity.this, "Add Product Successful", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddItemActivity.this, "Add Product Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //todo Testing
        //reference.child("list").setValue(stname);
    }
}
