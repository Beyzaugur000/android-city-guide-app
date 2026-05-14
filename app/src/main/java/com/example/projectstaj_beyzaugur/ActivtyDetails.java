package com.example.projectstaj_beyzaugur;

import static android.app.PendingIntent.getActivity;
import static android.view.View.INVISIBLE;
import static android.view.View.SCROLLBARS_OUTSIDE_INSET;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivtyDetails extends AppCompatActivity implements CityDetailFragment.FragmentInteractionListener {
    Button back;
    TextView nametextView, history, universty, hospital, mall;
    ImageView imageView;
    LinearLayout linearLayout;
    FrameLayout frameLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activty_details);

        back = findViewById(R.id.geribtn);
        nametextView = findViewById(R.id.basliktxt);
        imageView = findViewById(R.id.cityfoto);
        history = findViewById(R.id.tarihitxt);
        universty = findViewById(R.id.unitxt);
        hospital = findViewById(R.id.hastanetxt);
        mall = findViewById(R.id.avmtxt);
        linearLayout = findViewById(R.id.linearLayoutDetail);
        frameLayout = findViewById(R.id.fragmentContainerView);

        System.out.println("oncreate");


        city selectedCity = (city) getIntent().getSerializableExtra("selectedCity");
        String cityname = selectedCity.getCityname(); // Seçilen şehir adı
        int image = selectedCity.getImage(); // Seçilen şehir resim kaynağı

        boolean fragControl = getIntent().getBooleanExtra("fragControl",false);
        System.out.println("FRAGcONTROL " + fragControl);


        nametextView.setText(cityname);
        imageView.setImageResource(Integer.parseInt(String.valueOf(image)));



        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCategoryList("historicalPlaces", selectedCity);
            }


        });
        universty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCategoryList("universities", selectedCity);
            }
        });
        mall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCategoryList("malls", selectedCity);
            }
        });
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCategoryList("hospitals", selectedCity);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main2 = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(main2);
                finish();
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent main2 = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(main2);
        finish();
        super.onBackPressed();
    }

    private void showCategoryList(String category, city selectedCity) {
        List<String> itemList;
        switch (category) {
            case "historicalPlaces":
                itemList = selectedCity.getHistoricalPlaces();
                break;
            case "universities":
                itemList = selectedCity.getUniversities();
                break;
            case "malls":
                itemList = selectedCity.getMalls();
                break;
            case "hospitals":
                itemList = selectedCity.getHospitals();
                break;
            default:
                itemList = new ArrayList<>();
        }
        showCityDetailFragment(itemList);
    }

    private void showCityDetailFragment(List<String> itemList) {
        // Ana ekranı gizle
        linearLayout.setVisibility(View.INVISIBLE);
        history.setVisibility(View.INVISIBLE);
        mall.setVisibility(View.INVISIBLE);
        universty.setVisibility(View.INVISIBLE);
        hospital.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
        frameLayout.setVisibility(View.VISIBLE);

        // Doğru şekilde CityDetailFragment'ı oluşturun
        CityDetailFragment fragment = new CityDetailFragment(itemList);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragment) // R.id.fragmentContainer yerine layoutunuzun id'sini kullanın
                .commit();
    }


    @Override
    protected void onResume() {
        super.onResume();


        // Elemanları tekrar görünür yap
        linearLayout.setVisibility(View.VISIBLE);
        history.setVisibility(View.VISIBLE);
        mall.setVisibility(View.VISIBLE);
        universty.setVisibility(View.VISIBLE);
        hospital.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        System.out.println("ONRESUME");
    }

    @Override
    protected void onPause() {

        super.onPause();
        System.out.println("ONPAUSE");


    }

    private void restoreVisibility() {
        linearLayout.setVisibility(View.VISIBLE);
        history.setVisibility(View.VISIBLE);
        mall.setVisibility(View.VISIBLE);
        universty.setVisibility(View.VISIBLE);
        hospital.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
    }


    @Override
    public void onFragmentReturned() {
        restoreVisibility();
    }
}