package com.awad.hamudi.muhammadshoppinglist.mainlistfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.awad.hamudi.muhammadshoppinglist.R;
import com.awad.hamudi.muhammadshoppinglist.data.product;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentListFragment extends Fragment
{
    private TextView tvTotal;
    private TextView tvTotalValue;
    private TextView tvCount;
    private TextView tvCountValue;
    private ImageButton imbSave;
    private ListView lstvCurrent;

    public CurrentListFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_current_list2, container, false);
        tvTotal = (TextView) view.findViewById(R.id.tvTotal);
        tvTotalValue = (TextView) view.findViewById(R.id.tvTotalValue);
        tvCount = (TextView) view.findViewById(R.id.tvCount);
        tvCountValue = (TextView) view.findViewById(R.id.tvCountValue);
        imbSave = (ImageButton) view.findViewById(R.id.imbSave);
        lstvCurrent = (ListView) view.findViewById(R.id.lstvCurrent);
        String [] ar={"noor","rimaa","teya","shada"};
        //
        readAndlisten();
        //4.
        return view;
    }
    //raed and listen data from firebase
    private void readAndlisten()
    {
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
        //7. listening to data change
        reference.child(email).child("myList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for (DataSnapshot ds:dataSnapshot.getChildren())
                {
                    product p=ds.getValue(product.class);
                    Log.d("SL",p.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                
            }
        });
    }

}
