package com.example.projectstaj_beyzaugur;

import static com.example.projectstaj_beyzaugur.R.id.RecylertextView;
import static com.example.projectstaj_beyzaugur.R.id.basliktxt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements RecyclerViewInterface {

    private ArrayList<city> cityArrayList = new ArrayList<>(); // Sınıf seviyesinde tanımlandı


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addPlaces();

        RecyclerView recyclerView = findViewById(R.id.review);
        //setUpcityArrayList();
        cityadapter adapter = new cityadapter(this, cityArrayList, getApplicationContext());
        adapter.setOnItemClickListener(); // Listener'ı ayarla
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private void setUpcityArrayList() {
        String[] cityname = { "İstanbul", "Ankara","Konya", "Bursa", "İzmir", "Antalya",  "Tekirdağ",  "Sivas",};
        int[] image = { R.drawable.istanbul, R.drawable.ankara,R.drawable.konya1, R.drawable.bursa, R.drawable.izmir, R.drawable.antalya,  R.drawable.tekirdag,  R.drawable.sivas};
        for (int i = 0; i < cityname.length; i++) {
            cityArrayList.add(new city(cityname[i], image[i]));
        }
    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(getApplicationContext(), ActivtyDetails.class);
        intent.putExtra("cityname", cityArrayList.get(position).getCityname());
        intent.putExtra("image", cityArrayList.get(position).getImage());
        intent.putExtra("selectedCity", cityArrayList.get(position));
        startActivity(intent);
    }

    public void addPlaces() {

        String[] historicalPlacesIstanbul= {"Galata Kulesi", "Topkapı Sarayı"};
        String[] universitiesIstanbul = { "İstanbul Teknik Üniversitesi", "Marmara Üniversitesi"};
        String[] hospitalsIstanbul = {"Beykoz Devlet Hastanesi", "Üsküdar Devlet Hastanesi"};
        String[] mallsIstanbul = {"Zorlu Center","İstinye Park"};

        String[] historicalPlacesAnkara = {"Anıtkabir", "Ankara Kalesi"};
        String[] universitiesAnkara = { "Orta Doğu Teknik Üniversitesi", "Hacettepe Üniversitesi"};
        String[] hospitalsAnkara = {"Ankara Bilkent Şehir Hastanesi", "Ankara Etlik Şehir Hastanesi"};
        String[] mallsAnkara = {"Kızılay AVM","Metromall AVM"};

        String[] historicalPlacesKonya = {"Mevlana Müzesi", "Karatay Medresesi"};
        String[] universitiesKonya = {"Selçuk Üniversitesi", "KTO Karatay Üniversitesi"};
        String[] hospitalsKonya = {"Selçuk Üniversitesi Tıp Fakültesi", "Konya Numune Hastanesi"};
        String[] mallsKonya = {"KentPlaza AVM", "KuleSite AVM"};

        String[] historicalPlacesBursa = {"Bursa Ulu Camii", "Koza Han"};
        String[] universitiesBursa= {"Bursa Teknik Üniversitesi", "Bursa Uludağ Üniversitesi"};
        String[] hospitalsBursa = {"Bursa Şehir Hastanesi", "Gemlik Devlet Hastanesi"};
        String[] mallsBursa = {"Korupark Alışveriş Merkezi", "Kent Meydanı AVM"};

        String[] historicalPlacesIzmir= {"Efes Antik Kenti", "Kemeraltı Çarşısı"};
        String[] universitiesIzmir= {"Dokuz Eylül Üniversitesi","Ege Üniversitesi"};
        String[] hospitalsIzmir = {" Alsancak Nevvar Salih İşgören Devlet Hastanesi", "Dr. Behçet Uz Çocuk Hastalıkları Eğitim ve Araştırma Hastanesi"};
        String[] mallsIzmir = {"Hilltown Karşıyaka AVM", "İzmir Optimum AVM"};

        String[] historicalPlacesAntalya = {"Aspendos", "Köprülü Kanyon"};
        String[] universitiesAntalya = { "Akdeniz Üniversitesi", "Antalya Bilim Üniversitesi"};
        String[] hospitalsAntalya = {"Antalya Eğitim ve Araştırma Hastanesi", "Kepez Devlet Hastanesi"};
        String[] mallsAntalya = {"Mark Antalya AVM","TerraCity AVM"};

        String[] historicalPlacesTekirdag = {"Süleymaniye Cami", "Çorlu Kalesi"};
        String[] universitiesTekirdag = {"Tekirdağ Namık Kemal Üniversitesi"};
        String[] hospitalsTekirdag = {"Tekirdağ Devlet Hastanesi", "Çerkezköy Devlet Hastanesi"};
        String[] mallsTekirdag = {"Tekira Alışveriş Merkezi", "Çerkezköy Center"};

        String[] historicalPlacesSivas = {"Çifte Minareli Medrese", "Gök Medrese"};
        String[] universitiesSivas = { "Sivas Cumhuriyet Üniversitesi", "Sivas Bilim ve Teknoloji Üniversitesi"};
        String[] hospitalsSivas = {"Sivas Devlet Hastanesi", "Divriği Devlet Hastanesi"};
        String[] mallsSivas = {"İvapark Avm Sivas"};





        city istanbul = new city("İstanbul", R.drawable.istanbul);
        istanbul.setHistoricalPlaces(Arrays.asList(historicalPlacesIstanbul));
        istanbul.setUniversities(Arrays.asList(universitiesIstanbul));
        istanbul.setHospitals(Arrays.asList(hospitalsIstanbul));
        istanbul.setMalls(Arrays.asList(mallsIstanbul));
        cityArrayList.add(istanbul);

        city  ankara= new city("Ankara", R.drawable.ankara);
        ankara.setHistoricalPlaces(Arrays.asList(historicalPlacesAnkara));
        ankara.setUniversities(Arrays.asList(universitiesAnkara));
        ankara.setHospitals(Arrays.asList(hospitalsAnkara));
        ankara.setMalls(Arrays.asList(mallsAnkara));
        cityArrayList.add(ankara);



        city konya = new city("Konya", R.drawable.konya1);
        konya.setHistoricalPlaces(Arrays.asList(historicalPlacesKonya));
        konya.setUniversities(Arrays.asList(universitiesKonya));
        konya.setHospitals(Arrays.asList(hospitalsKonya));
        konya.setMalls(Arrays.asList(mallsKonya));
        cityArrayList.add(konya);

        city bursa = new city("Bursa", R.drawable.bursa);
        bursa.setHistoricalPlaces(Arrays.asList(historicalPlacesBursa));
        bursa.setUniversities(Arrays.asList(universitiesBursa));
        bursa.setHospitals(Arrays.asList(hospitalsBursa));
        bursa.setMalls(Arrays.asList(mallsBursa));
        cityArrayList.add(bursa);

        city i̇zmir = new city("İzmir", R.drawable.izmir);
        i̇zmir.setHistoricalPlaces(Arrays.asList(historicalPlacesIzmir));
        i̇zmir.setUniversities(Arrays.asList(universitiesIzmir));
        i̇zmir.setHospitals(Arrays.asList(hospitalsIzmir));
        i̇zmir.setMalls(Arrays.asList(mallsIzmir));
        cityArrayList.add(i̇zmir);

        city antalya = new city("Antalya", R.drawable.antalya);
        antalya.setHistoricalPlaces(Arrays.asList(historicalPlacesAntalya));
        antalya.setUniversities(Arrays.asList(universitiesAntalya));
        antalya.setHospitals(Arrays.asList(hospitalsAntalya));
        antalya.setMalls(Arrays.asList(mallsAntalya));
        cityArrayList.add(antalya);


        city tekirdag = new city("Tekirdağ", R.drawable.tekirdag1);
        tekirdag.setHistoricalPlaces(Arrays.asList(historicalPlacesTekirdag));
        tekirdag.setUniversities(Arrays.asList(universitiesTekirdag));
        tekirdag.setHospitals(Arrays.asList(hospitalsTekirdag));
        tekirdag.setMalls(Arrays.asList(mallsTekirdag));
        cityArrayList.add(tekirdag);

        city sivas = new city("Sivas", R.drawable.sivas1);
        sivas.setHistoricalPlaces(Arrays.asList(historicalPlacesSivas));
        sivas.setUniversities(Arrays.asList(universitiesSivas));
        sivas.setHospitals(Arrays.asList(hospitalsSivas));
        sivas.setMalls(Arrays.asList(mallsSivas));
        cityArrayList.add(sivas);


    }




}


