package com.example.miestro.marca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {

    ImageView imageView;
    TextView title;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent=getIntent();

        imageView = (ImageView)findViewById(R.id.image_dtails);
        title = (TextView)findViewById(R.id.Title_details);
        description= (TextView)findViewById(R.id.details_description);


        title.setText(intent.getStringExtra("title"));
        description.setText(intent.getStringExtra("description"));
        Picasso.with(this).load(intent.getStringExtra("image")).into(imageView);


    }
}
