package com.example.projectstaj_beyzaugur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceDetailActivity extends AppCompatActivity {
    private TextView TitleTextView, descriptionTextView, AddressView;
    private ImageView ImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        TitleTextView = findViewById(R.id.title);
        descriptionTextView = findViewById(R.id.descrip);
        ImageView = findViewById(R.id.foto);
        AddressView = findViewById(R.id.adress);

        Intent intent = getIntent();
        String placeName = intent.getStringExtra("placeName");
        String placeDescription = intent.getStringExtra("placeDescription");
        String placeAdress = intent.getStringExtra("placeAdress");
        int placeFoto = intent.getIntExtra("placeFoto", 0);

        TitleTextView.setText(placeName);
        descriptionTextView.setText(placeDescription);
         AddressView.setText(placeAdress);
       ImageView.setImageResource(placeFoto);

        System.out.println("PLACE NAME " + placeName);
        System.out.println("PLACE DESCRIPTION " + placeDescription);
        System.out.println("PLACE ADRESS " + placeAdress);
        System.out.println("PLACE FOTO " + placeAdress);


    }
}
