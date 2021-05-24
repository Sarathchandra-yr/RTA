package com.example.projecttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.net.URL;

public class sea extends AppCompatActivity {

    TextView t;
    GridView gv;
    String place,str;
    ImageView imgURL1,imgURL2,imgURL3,imgURL4;
    ProgressBar pbbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sea);
        t = (TextView)findViewById(R.id.textView5);
        imgURL1 = findViewById(R.id.imageView);
        imgURL2 = findViewById(R.id.imageView2);
        imgURL3 = findViewById(R.id.imageView3);
        imgURL4 = findViewById(R.id.imageView4);
        Intent i = getIntent();
        place =  i.getStringExtra("place");
        place = place.toLowerCase();
        t.setText(place);
        if (place == "hyderabad"){

        }
        else if (place == "manipal"){

        }
        else if (place == "goa"){


        }
        else if (place == "chennai") {

        }

    }

}

