package com.newapp.bookshow;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class PVRActivity extends AppCompatActivity {

    String x ;
    EditText ed1,ed2;
    Double i,j;
    String uid1;

    FirebaseAuth firebaseAuth;
    Button back,confirm;
    StorageReference storageReference;
    DatabaseReference databaseReference,databaseReferencef,databaseReferenceg,databaseReferenceh,databaseReferencei,databaseReferencej,databaseReferencea,databaseReferenceb,databaseReferencec,databaseReferenced,databaseReferencee;
    DatabaseReference userwallet,userinox1;
    ImageView i1,i2,i3,i4,i5,i6,i7,i8,i9,i10;
    String info;
    Double current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvr);

        Firebase.setAndroidContext(this);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        uid1 = firebaseUser.getUid();

        i1 = (ImageView)findViewById(R.id.seata5);
        i2 = (ImageView)findViewById(R.id.seatb5);
        i3 = (ImageView)findViewById(R.id.seatc5);
        i4 = (ImageView)findViewById(R.id.seatd5);
        i5 = (ImageView)findViewById(R.id.seate5);
        i6 = (ImageView)findViewById(R.id.seatf5);
        i7 = (ImageView)findViewById(R.id.seatg5);
        i8 = (ImageView)findViewById(R.id.seath5);
        i9 = (ImageView)findViewById(R.id.seati5);
        i10 = (ImageView)findViewById(R.id.seatj5);

        i=0.0;
        j=0.0;
        storageReference = FirebaseStorage.getInstance().getReference();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        userinox1 = FirebaseDatabase.getInstance().getReference(uid1 + "/Movie/PVR1");
        userwallet = FirebaseDatabase.getInstance().getReference(uid1 + "/Wallet");
        databaseReferencea = FirebaseDatabase.getInstance().getReference("PVR/PVR1/Gold/seatA");
        databaseReferenceb = FirebaseDatabase.getInstance().getReference("PVR/PVR1/Gold/seatB");
        databaseReferencec = FirebaseDatabase.getInstance().getReference("PVR/PVR1/Gold/seatC");
        databaseReferenced = FirebaseDatabase.getInstance().getReference("PVR/PVR1/Gold/seatD");
        databaseReferencee = FirebaseDatabase.getInstance().getReference("PVR/PVR1/Gold/seatE");
        databaseReferencef = FirebaseDatabase.getInstance().getReference("PVR/PVR1/Silver/seatF");
        databaseReferenceg = FirebaseDatabase.getInstance().getReference("PVR/PVR1/Silver/seatG");
        databaseReferenceh = FirebaseDatabase.getInstance().getReference("PVR/PVR1/Silver/seatH");
        databaseReferencei = FirebaseDatabase.getInstance().getReference("PVR/PVR1/Silver/seatI");
        databaseReferencej = FirebaseDatabase.getInstance().getReference("PVR/PVR1/Silver/seatJ");

        back = (Button)findViewById(R.id.backbutton5);
        confirm = (Button)findViewById(R.id.confirmbutton5);

        userinox1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                info = dataSnapshot.getValue().toString();

                if(info.equals("none"))
                {
                    x = info + "PVR: SCREEN1: Venom :";
                }
                else
                {
                    x = info + " ";
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        userwallet.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                current = dataSnapshot.getValue(Double.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        databaseReferencea.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String texta = dataSnapshot.getValue().toString();
                if(texta.equals("true")){
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/vacantseat.jpg?alt=media&token=d44a4ca3-e6f7-4280-ba49-167fda3b799b").fit().centerCrop().into(i1);
                    i1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i1);
                            databaseReferencea.setValue("false");
                            x = x + " " + " a";
                            i++;
                        }
                    });
                }
                else
                {
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReferenceb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String texta = dataSnapshot.getValue().toString();
                if(texta.equals("true")){
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/vacantseat.jpg?alt=media&token=d44a4ca3-e6f7-4280-ba49-167fda3b799b").fit().centerCrop().into(i2);
                    i2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i2);
                            databaseReferenceb.setValue("false");
                            x = x + " " + " b";
                            i++;
                        }
                    });
                }
                else
                {
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReferencec.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String texta = dataSnapshot.getValue().toString();
                if(texta.equals("true")){
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/vacantseat.jpg?alt=media&token=d44a4ca3-e6f7-4280-ba49-167fda3b799b").fit().centerCrop().into(i3);
                    i3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i3);
                            databaseReferencec.setValue("false");
                            x = x + " " + " c";
                            i++;
                        }
                    });
                }
                else
                {
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReferenced.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String texta = dataSnapshot.getValue().toString();
                if(texta.equals("true")){
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/vacantseat.jpg?alt=media&token=d44a4ca3-e6f7-4280-ba49-167fda3b799b").fit().centerCrop().into(i4);
                    i4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i4);
                            databaseReferenced.setValue("false");
                            x = x + " " + " d";
                            i++;
                        }
                    });
                }
                else
                {
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i4);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReferencee.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String texta = dataSnapshot.getValue().toString();
                if(texta.equals("true")){
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/vacantseat.jpg?alt=media&token=d44a4ca3-e6f7-4280-ba49-167fda3b799b").fit().centerCrop().into(i5);
                    i5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i5);
                            databaseReferencee.setValue("false");
                            x = x + " " + " e";
                            i++;
                        }
                    });
                }
                else
                {
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i5);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReferencef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String texta = dataSnapshot.getValue().toString();
                if(texta.equals("true")){
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/vacantseat.jpg?alt=media&token=d44a4ca3-e6f7-4280-ba49-167fda3b799b").fit().centerCrop().into(i6);
                    i6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i6);
                            databaseReferencef.setValue("false");
                            x = x + " " + " f";
                            j++;
                        }
                    });
                }
                else
                {
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i6);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReferenceg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String texta = dataSnapshot.getValue().toString();
                if(texta.equals("true")){
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/vacantseat.jpg?alt=media&token=d44a4ca3-e6f7-4280-ba49-167fda3b799b").fit().centerCrop().into(i7);
                    i7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i7);
                            databaseReferenceg.setValue("false");
                            x = x + " " + " g";
                            j++;
                        }
                    });
                }
                else
                {
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i7);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        databaseReferenceh.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String texta = dataSnapshot.getValue().toString();
                if(texta.equals("true")){
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/vacantseat.jpg?alt=media&token=d44a4ca3-e6f7-4280-ba49-167fda3b799b").fit().centerCrop().into(i8);
                    i8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i8);
                            databaseReferenceh.setValue("false");
                            x = x + " " + " h";
                            j++;
                        }
                    });
                }
                else
                {
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i8);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReferencei.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String texta = dataSnapshot.getValue().toString();
                if(texta.equals("true")){
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/vacantseat.jpg?alt=media&token=d44a4ca3-e6f7-4280-ba49-167fda3b799b").fit().centerCrop().into(i9);
                    i9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i9);
                            databaseReferencei.setValue("false");
                            x = x + " " + " i";
                            j++;
                        }
                    });
                }
                else
                {
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i9);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReferencej.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String texta = dataSnapshot.getValue().toString();
                if(texta.equals("true")){
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/vacantseat.jpg?alt=media&token=d44a4ca3-e6f7-4280-ba49-167fda3b799b").fit().centerCrop().into(i10);
                    i10.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i10);
                            databaseReferencej.setValue("false");
                            x = x + " " + " j";
                            j++;
                        }
                    });
                }
                else
                {
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/bookedseat.jpg?alt=media&token=cbcda7bb-d508-4c49-81b3-7f563c98516d").fit().centerCrop().into(i10);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PVRActivity.this,CinemaActivity1.class));
            }
        });


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = current - i*200 -j*100;
                userinox1.setValue(x);

                userwallet.setValue(current);
                startActivity(new Intent(PVRActivity.this,EventConfirm.class));

            }

        });


    }
}
