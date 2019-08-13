package com.newapp.bookshow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private String name1;
    private Button buttonRegister;
    private EditText email;
    private EditText name;
    private EditText password;
    private TextView signin;
    String uid;
    //private ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
//        progressBar = new ProgressBar(this);
        if (firebaseAuth.getCurrentUser() !=null)
        {
            finish();
            //show profile
            startActivity(new Intent(getApplicationContext(),NewprofileActivity.class));
        }

        databaseReference = FirebaseDatabase.getInstance().getReference();
        buttonRegister = (Button)findViewById(R.id.register);
        email = (EditText)findViewById(R.id.editEmail);
        password = (EditText)findViewById(R.id.editPassword);
        signin = (TextView)findViewById(R.id.textViewSignIn);
        name = (EditText)findViewById(R.id.editName);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               name1 = name.getText().toString();
               final String emailid = email.getText().toString().trim();
               String passwd = password.getText().toString().trim();

               if(TextUtils.isEmpty(emailid)){
                   Toast.makeText(getApplicationContext(),"please enter email address",Toast.LENGTH_SHORT).show();
                   return;
               }

               if(TextUtils.isEmpty(passwd))
               {
                   Toast.makeText(getApplicationContext(),"please enter password",Toast.LENGTH_SHORT).show();
                    return;
               }

               if(TextUtils.isEmpty(name1))
               {
                   Toast.makeText(getApplicationContext(),"please enter your name ",Toast.LENGTH_SHORT).show();
               }

               firebaseAuth.createUserWithEmailAndPassword(emailid,passwd)
                       .addOnCompleteListener(MainActivity.this
                               , new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(getApplicationContext(),"registered successfully",Toast.LENGTH_SHORT).show();

                                    FirebaseUser usernew = firebaseAuth.getCurrentUser();
                                    uid = usernew.getUid();

                                    databaseReference.child(uid).child("Name").setValue(name1);
                                    databaseReference.child(uid).child("Wallet").setValue(3000);
                                    databaseReference.child(uid).child("Event").child("Event1").setValue(0.0);
                                    databaseReference.child(uid).child("Event").child("Event2").setValue(0.0);
                                    databaseReference.child(uid).child("Movie").child("Inox1").setValue("none");
                                    databaseReference.child(uid).child("Movie").child("Inox2").setValue("none");
                                    databaseReference.child(uid).child("Movie").child("Inox3").setValue("none");
                                    databaseReference.child(uid).child("Movie").child("Inox4").setValue("none");
                                    databaseReference.child(uid).child("Movie").child("PVR1").setValue("none");
                                    databaseReference.child(uid).child("Movie").child("PVR2").setValue("none");
                                    databaseReference.child(uid).child("Movie").child("PVR3").setValue("none ");
                                    databaseReference.child(uid).child("Movie").child("PVR4").setValue("none");
                                    startActivity(new Intent(getApplicationContext(),NewprofileActivity.class));
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"could not register",Toast.LENGTH_SHORT).show();
                                }

                           }
                       });


            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                }
        });

    }

    public String getName1() {
        return name1;
    }
}
