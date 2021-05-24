package com.example.projecttry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    EditText email,password,cpassword,pn,user;
    static String emailid,cpass,pass,phone,uname;
    
    Button button;
    private FirebaseAuth mAuth;
    FirebaseDatabase db;
    DatabaseReference dbSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();



        button = (Button)findViewById(R.id.sb);

    };


        public void signn(View view){

            email = (EditText)findViewById(R.id.email);
            password = (EditText)findViewById(R.id.password);
            pn = (EditText)findViewById(R.id.phone);
            cpassword = (EditText)findViewById(R.id.cpass);
            user = (EditText)findViewById(R.id.uname);
            //toStrings

            emailid = email.getText().toString();
            pass = password.getText().toString();
            cpass = cpassword.getText().toString();
            phone = pn.getText().toString();
            uname = user.getText().toString();


            //Toast.makeText(getApplicationContext(),emailid,Toast.LENGTH_SHORT).show();

            if(emailid.isEmpty() || pass.isEmpty() || phone.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Empty not allowed",Toast.LENGTH_SHORT).show();
            }

            else {
                newuser user = new newuser(emailid, pass, phone, uname);

                db=FirebaseDatabase.getInstance();
                dbSignup= db.getReference("Users");
                mAuth.createUserWithEmailAndPassword(emailid,pass)
                        .addOnCompleteListener(this,new OnCompleteListener<AuthResult> () {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent i =new Intent(view.getContext(),MainActivity.class);
                                    startActivity(i);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                                }
                            }
                        });




                dbSignup.push().setValue(user, (databaseError, databaseReference) -> {
                    Toast.makeText(signup.this, "SIGNUP SUCCESSFULL ", Toast.LENGTH_LONG).show();
                });


            }
        }


        public static class newuser{
            String emailid,pass,phone,uname;

            public newuser(String emailid,String pass,String phone,String uname)
            {
                this.emailid=emailid;
                this.pass=pass;
                this.phone=phone;
                this.uname=uname;
            }

            public String getEmailid() {
                return emailid;
            }

            public String getPass() {
                return pass;
            }

            public String getPhone() {
                return phone;
            }

            public String getUname() {
                return uname;
            }

            public void setEmailid(String emailid) {
                this.emailid=emailid;
            }

            public void setPass(String pass) {
                this.pass=pass;

            }

            public void setPhone(String phone) {
                this.phone=phone;

            }

            public void setUname(String uname) {
                this.uname=uname;

            }
        }

    }
