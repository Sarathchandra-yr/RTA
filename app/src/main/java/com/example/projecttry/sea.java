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
import android.widget.Toast;


import com.bumptech.glide.Glide;

import java.net.URL;

public class sea extends AppCompatActivity {

    TextView t;
    GridView gv;
    String place,str,p,h="hyderabad",c="chennai",m="manipal",g="goa";
    ImageView imgURL1,imgURL2,imgURL3,imgURL4;
    ProgressBar pbbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sea);
        t = (TextView)findViewById(R.id.textView5);
        imgURL1 =findViewById(R.id.imageView);
        imgURL2 = findViewById(R.id.imageView2);
        imgURL3 = findViewById(R.id.imageView3);

        Intent i = getIntent();
        place =  i.getStringExtra("place");

        p = place.toLowerCase();
        t.setText(place);
        Toast.makeText(this, p, Toast.LENGTH_SHORT).show();


        insert();

    }

    private void insert() {

        if (p.compareTo(h)==0) {
            Glide.with(this)
                    .load("https://assets-news.housing.com/news/wp-content/uploads/2020/11/02184143/Everything-you-need-to-know-about-Golconda-Fort-FB-1200x700-compressed.jpg")
                    .into(imgURL1);
            Glide.with(this)
                    .load("https://www.nationsonline.org/gallery/India/Char-Minar-Hyderabad.jpg")
                    .into(imgURL2);
            Glide.with(this)
                    .load("http://www.jllapsites.com/research/wp-content/uploads/2019/01/Blog-by-Trivita-Roy_28Jan2019.jpg")
                    .into(imgURL3);

        }
        if (p.compareTo(m)==0){
            Glide.with(this)
                    .load("https://www.manipalthetalk.org/wp-content/uploads/2016/06/Kundadari-2-1400x1050.jpg")
                    .into(imgURL1);
            Glide.with(this)
                    .load("https://www.hlimg.com/images/things2do/738X538/end_1510669442t.jpg")
                    .into(imgURL2);
            Glide.with(this)
                    .load("https://www.travelhippies.in/wp-content/uploads/2016/07/Heroor-Bridge-Udupi.jpg")
                    .into(imgURL3);
        }
        else if (p.compareTo(g)==0){
            Glide.with(this)
                    .load("https://img.traveltriangle.com/blog/wp-content/uploads/2020/02/Cover-image-of-Places-to-visit-in-Goa-in-may-1.jpg")
                    .into(imgURL1);
            Glide.with(this)
                    .load("https://www.fabhotels.com/blog/wp-content/uploads/2019/03/Mangeshi-Temple.jpg")
                    .into(imgURL2);
            Glide.with(this)
                    .load("https://www.excellencytrip.com/uploads/tours/1551104966GOA-3.jpg")
                    .into(imgURL3);

        }
        else if (p.compareTo(c)==0) {
            Glide.with(this)
                    .load("https://www.thehindu.com/society/qwfz7a/article31488395.ece/ALTERNATES/LANDSCAPE_615/1MPCHENNAIBEACH")
                    .into(imgURL1);
            Glide.with(this)
                    .load("https://www.fabhotels.com/blog/wp-content/uploads/2018/07/Kapaleeswarar-Temple.jpg")
                    .into(imgURL2);
            Glide.with(this)
                    .load("https://www.daisyvega.com/wp-content/uploads/2018/01/Chennai.jpg")
                    .into(imgURL3);

        }

    }

}

