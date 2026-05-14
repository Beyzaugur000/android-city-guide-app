package com.example.projectstaj_beyzaugur;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Presentation;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000); //istediğiniz değerleri yazabilirsiniz (3000 = 3 saniye)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent main2 = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(main2);
                    finish();
                }
            }
        };
        timerThread.start();

        }


    }

