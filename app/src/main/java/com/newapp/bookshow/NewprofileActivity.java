package com.newapp.bookshow;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NewprofileActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int i;
    String text1,text2,text3,text4,text5,text6,text7,text8,text9,text10;
    Double wallet;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> imagenames = new ArrayList<>();
    TextView newtext;
    String uid;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11;
    private static final String TAG = "Mainactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newprofile);




        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

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

        r11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                wallet = dataSnapshot.getValue(Double.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });









        Log.d(TAG,"inRecyclerView : successfully");
        final RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        final Recyclerviewadapter recyclerviewadapter = new Recyclerviewadapter(this,names,imagenames);
        //recyclerView.setAdapter(recyclerviewadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));





        r1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                text1 = dataSnapshot.getValue().toString();
                if(!(text1.equals("none"))){
                    String[] arr1;
                    arr1 = text1.split(":");
                    String t1 = "Theater : "+ arr1[0].substring(4);
                    String t2 = "Screen : " + arr1[1];
                    String t3 = "Movie : " + arr1[2];
                    String t4 = "Seats : " + arr1[3];
                names.add( t2 + "\n" + t3 + "\n" + t4+ "\n");
                imagenames.add("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/inoximage.jpg?alt=media&token=54ce55fe-38d9-48c2-bf2c-a59a7315de7d");
                recyclerView.setAdapter(recyclerviewadapter);}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        r2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                text2 = dataSnapshot.getValue().toString();
                if(!(text2.equals("none"))){
                    String[] arr1;
                    arr1 = text2.split(":");
                    String t1 = "Theater : "+ arr1[0].substring(4);
                    String t2 = "Screen : " + arr1[1];
                    String t3 = "Movie : " + arr1[2];
                    String t4 = "Seats : " + arr1[3];
                    names.add( t2 + "\n" + t3 + "\n" + t4+ "\n");
                imagenames.add("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/inoximage.jpg?alt=media&token=54ce55fe-38d9-48c2-bf2c-a59a7315de7d");
                recyclerView.setAdapter(recyclerviewadapter);

            }}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        r3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                text3 = dataSnapshot.getValue().toString();
                if(!(text3.equals("none"))){
                    String[] arr1;
                    arr1 = text3.split(":");
                    String t1 = "Theater : "+ arr1[0].substring(4);
                    String t2 = "Screen : " + arr1[1];
                    String t3 = "Movie : " + arr1[2];
                    String t4 = "Seats : " + arr1[3];
                    names.add( t2 + "\n" + t3 + "\n" + t4+ "\n");
                    imagenames.add("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/inoximage.jpg?alt=media&token=54ce55fe-38d9-48c2-bf2c-a59a7315de7d");
                recyclerView.setAdapter(recyclerviewadapter);
            }}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        r4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                text4 = dataSnapshot.getValue().toString();
                if(!(text4.equals("none"))){
                    String[] arr1;
                    arr1 = text4.split(":");
                    String t1 = "Theater : "+ arr1[0].substring(4);
                    String t2 = "Screen : " + arr1[1];
                    String t3 = "Movie : " + arr1[2];
                    String t4 = "Seats : " + arr1[3];
                    names.add( t2 + "\n" + t3 + "\n" + t4+ "\n");
                    imagenames.add("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/inoximage.jpg?alt=media&token=54ce55fe-38d9-48c2-bf2c-a59a7315de7d");
                recyclerView.setAdapter(recyclerviewadapter);}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        r5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                text5 = dataSnapshot.getValue().toString();
                if(!(text5.equals("none"))){
                    String[] arr1;
                    arr1 = text5.split(":");
                    String t1 = "Theater : "+ arr1[0].substring(4);
                    String t2 = "Screen : " + arr1[1];
                    String t3 = "Movie : " + arr1[2];
                    String t4 = "Seats : " + arr1[3];
                    names.add( t2 + "\n" + t3 + "\n" + t4+ "\n");
                    imagenames.add("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/pvrimage.jpg?alt=media&token=a1b55fd2-a7d8-45f4-8dd7-0aaad54d9b84");
                recyclerView.setAdapter(recyclerviewadapter);
            }}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        r6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                text6 = dataSnapshot.getValue().toString();
                if(!(text6.equals("none"))){
                    String[] arr1;
                    arr1 = text6.split(":");
                    String t1 = "Theater : "+ arr1[0].substring(4);
                    String t2 = "Screen : " + arr1[1];
                    String t3 = "Movie : " + arr1[2];
                    String t4 = "Seats : " + arr1[3];
                    names.add( t2 + "\n" + t3 + "\n" + t4+ "\n");
                    imagenames.add("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/pvrimage.jpg?alt=media&token=a1b55fd2-a7d8-45f4-8dd7-0aaad54d9b84");
                recyclerView.setAdapter(recyclerviewadapter);
            }}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    /*    r7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                text7 = dataSnapshot.getValue().toString();
                if(!(text7.equals("none"))){
                    String[] arr1;
                    arr1 = text7.split(":");
                    String t1 = "Theater : "+ arr1[0].substring(4);
                    String t2 = "Screen : " + arr1[1];
                    String t3 = "Movie : " + arr1[2];
                    String t4 = "Seats : " + arr1[3];
                    names.add( t2 + "\n" + t3 + "\n" + t4+ "\n");
                    imagenames.add("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/pvrimage.jpg?alt=media&token=a1b55fd2-a7d8-45f4-8dd7-0aaad54d9b84");
                recyclerView.setAdapter(recyclerviewadapter);
            }}


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        r8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                text8 = dataSnapshot.getValue().toString();
                if(!(text8.equals("none"))){
                    String[] arr1;
                    arr1 = text8.split(":");
                    String t1 = "Theater : "+ arr1[0].substring(4);
                    String t2 = "Screen : " + arr1[1];
                    String t3 = "Movie : " + arr1[2];
                    String t4 = "Seats : " + arr1[3];
                    names.add( t2 + "\n" + t3 + "\n" + t4+ "\n");
                    imagenames.add("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/pvrimage.jpg?alt=media&token=a1b55fd2-a7d8-45f4-8dd7-0aaad54d9b84");
                recyclerView.setAdapter(recyclerviewadapter);
            }}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        r9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double event1 = dataSnapshot.getValue(Double.class);
                String[] arr;
                text9 = "COLDPLAY: " + event1;
                arr = text9.split(":");
                String t1 = arr[0];
                String t2 = "Seats: " + arr[1];
                names.add(t1 + "\n" + t2 + "\n");
                imagenames.add("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/coldplay.png?alt=media&token=2fc7952f-e932-42c4-a0fb-7b10deb484d8");
                recyclerView.setAdapter(recyclerviewadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        r10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double event2 = dataSnapshot.getValue(Double.class);
                String[] arr;
                text10 = "MAROON V:" + event2;
                arr = text10.split(":");
                String t1 = arr[0];
                String t2 = "Seats: " + arr[1];
                names.add(t1 + "\n" + t2 + "\n");
                imagenames.add("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/maroon5.png?alt=media&token=3fc1d85b-4a72-4025-b63d-98055cab5836");
                recyclerView.setAdapter(recyclerviewadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.newprofile, menu);
        return true;
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_movie) {
            startActivity(new Intent(NewprofileActivity.this,MovieActivity.class));
        } else if (id == R.id.nav_event) {
            startActivity(new Intent(NewprofileActivity.this,MapsActivity.class));
        } else if (id == R.id.nav_wallet) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("BALANCE");
            alert.setMessage("Your current balance is:" + wallet);

            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(NewprofileActivity.this,":)",Toast.LENGTH_SHORT).show();
                }
            });
            alert.create().show();

        } else if (id == R.id.nav_logout) {
            firebaseAuth.signOut();
            startActivity(new Intent(NewprofileActivity.this,LoginActivity.class));

        }
        else if (id == R.id.nav_requestfunds){
            wallet = wallet + 1000.0;
            r11.setValue(wallet);
            Toast.makeText(NewprofileActivity.this,"Amount of Rs.1000 added to the account!",Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
