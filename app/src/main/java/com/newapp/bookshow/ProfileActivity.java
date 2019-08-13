package com.newapp.bookshow;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11;
    private TextView textView;
    private Button logout;
    private Button movie;
    private Button event;
    String uid;

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        logout = (Button)findViewById(R.id.logoutbutton);
        textView = (TextView)findViewById(R.id.userwelcome);
        movie = (Button)findViewById(R.id.moviebutton);
        event = (Button)findViewById(R.id.eventbutton);
        t1 = (TextView)findViewById(R.id.text1);
        t2 = (TextView)findViewById(R.id.text2);
        t3 = (TextView)findViewById(R.id.text3);
        t4 = (TextView)findViewById(R.id.text4);
        t5 = (TextView)findViewById(R.id.text5);
        t6 = (TextView)findViewById(R.id.text6);
        t7 = (TextView)findViewById(R.id.text7);
        t8 = (TextView)findViewById(R.id.text8);
        t9 = (TextView)findViewById(R.id.text9);
        t10 = (TextView)findViewById(R.id.text10);
        t11 = (TextView)findViewById(R.id.text11);




        FirebaseUser user = firebaseAuth.getCurrentUser();
        textView.setText(user.getEmail());
        uid = user.getUid();

        r1= FirebaseDatabase.getInstance().getReference(uid + "/Movie/Inox1");
        r2= FirebaseDatabase.getInstance().getReference(uid + "/Movie/Inox2");
        r3= FirebaseDatabase.getInstance().getReference(uid + "/Movie/Inox3");
        r4= FirebaseDatabase.getInstance().getReference(uid + "/Movie/Inox4");
        r5= FirebaseDatabase.getInstance().getReference(uid + "/Movie/PVR1");
        r6= FirebaseDatabase.getInstance().getReference(uid + "/Movie/PVR2");
        r7= FirebaseDatabase.getInstance().getReference(uid + "/Movie/PVR3");
        r8= FirebaseDatabase.getInstance().getReference(uid + "/Movie/PVR4");
        r9=FirebaseDatabase.getInstance().getReference(uid + "/Event/Event1");
        r10= FirebaseDatabase.getInstance().getReference(uid + "/Event/Event2");
        r11 = FirebaseDatabase.getInstance().getReference(uid +"/Wallet");


        r1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue().toString();
                t1.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        r2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue().toString();
                t2.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        r3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue().toString();
                t3.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        r4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue().toString();
                t4.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        r5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue().toString();
                t5.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        r6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue().toString();
                t6.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        r7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue().toString();
                t7.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        r8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue().toString();
                t8.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        r9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double event1 = dataSnapshot.getValue(Double.class);
                t9.setText("COLDPLAY: " + event1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        r10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double event2 = dataSnapshot.getValue(Double.class);
                t10.setText("MAROON V" + event2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        r11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double wallet = dataSnapshot.getValue(Double.class);
                t11.setText("Wallet: "+ wallet);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
            }
        });

        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(ProfileActivity.this,MovieActivity.class));
            }
        });
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                startActivity(new Intent(ProfileActivity.this,MapsActivity.class));
            }
        });
    }
}
