package com.example.projecttry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    TextView textView,tv;
    String str,email,passwor;
    Button lb;
    EditText emal,pass;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance();

        textView =(TextView)findViewById(R.id.textView2);
        str = textView.toString();




        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"yoo",Toast.LENGTH_SHORT).show();

            }
        });
        tv=(TextView)findViewById(R.id.textView7);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),signup.class);
                startActivity(i);
            }
        });
        lb =(Button)findViewById(R.id.button2);


    }

    public void login(View view) {
        emal = (EditText) findViewById(R.id.emal);
        pass = (EditText) findViewById(R.id.password);
        email = emal.getText().toString();
        passwor = pass.getText().toString();
        if (email.isEmpty() || passwor.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Empty not allowed", Toast.LENGTH_SHORT).show();
        }
        else {
            mAuth.signInWithEmailAndPassword(email, passwor)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(view.getContext(), homesrn.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
             }


    }
}






