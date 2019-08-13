package com.newapp.bookshow;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class LoginActivity extends AppCompatActivity {

    private ImageView userimage;
    private Button login;
    private EditText email;
    private EditText password;
    private TextView logintitle;
    private TextView signupnow;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() !=null)
        {
            //show profile
            finish();
            startActivity(new Intent(getApplicationContext(),NewprofileActivity.class));
        }
        login = (Button)findViewById(R.id.loginbutton);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        signupnow = (TextView)findViewById(R.id.textView5);
        userimage = (ImageView)findViewById(R.id.userimage);

        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/User.png?alt=media&token=2fdc85f4-473a-489b-8864-c7bf852570ac").fit().centerCrop().into(userimage);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString().trim();
                String pass1 = password.getText().toString().trim();

                if(TextUtils.isEmpty(email1))
                {
                    Toast.makeText(getApplicationContext(),"please enter your email id",Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(pass1))
                {
                    Toast.makeText(getApplicationContext(),"please enter your password",Toast.LENGTH_SHORT).show();
                }

                firebaseAuth.signInWithEmailAndPassword(email1,pass1)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    //show profile
                                    finish();
                                    startActivity(new Intent(getApplicationContext(),NewprofileActivity.class));
                                }

                            }
                        });
            }
        });

        signupnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });
    }
}
