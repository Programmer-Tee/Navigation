package com.example.tobeisun.navigatonn;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 */

public class Fragment_Message extends Fragment {
    EditText a ;
    Button b;
    DatabaseReference dataa ;
    List <Messages> storedmessage; //the list will store the messages entered


    public Fragment_Message() {


        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View view=  inflater.inflate(R.layout.fragment_fragment__message, container, false);


        dataa= FirebaseDatabase.getInstance().getReference("Messages") ;


        a=(EditText) view.findViewById(R.id.editTextMessage) ;
        b = (Button) view.findViewById(R.id.buttonsave);
        storedmessage= new ArrayList<>(); //saves the message in an array

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                savename();

            }
        });


        // Inflate the layout for this fragment
        return view;


}

    private void savename()
    {
        String message = a.getText().toString().trim();


        if(!TextUtils.isEmpty(message))
        {

            Messages d =new Messages(message) ;
            dataa.child(message).setValue(d) ;
              Toast.makeText(getActivity(), "Please long press the key", Toast.LENGTH_LONG ).show();
            a.setText(" ");



        }

        else
        {
            Toast.makeText(getActivity(),"Empty field, please enter a name", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onStart() {
        super.onStart();




        dataa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {  //ondatachange will be executed anytime you change something in the database
                // also reads the values in the specified "database" , which is "data" .. kind of takes a snapshot of them

                storedmessage.clear(); //clear it if something was previously there as the datasnapshot would contain all messages
                for(DataSnapshot d:dataSnapshot.getChildren())  //an enhanced forloop
                {
                    Messages m= d.getValue(Messages.class) ;

                    storedmessage.add(m) ;
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {  //oncancelled will be used when there is an error in the database

            }
        }) ;
    }





}














