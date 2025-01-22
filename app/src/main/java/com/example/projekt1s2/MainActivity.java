package com.example.projekt1s2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etAwa, etAkhi;

     Button BtMaps,BtStop, BtTelp, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAwa = findViewById(R.id.etAwa);
        etAkhi = findViewById(R.id.etAkhi);
        BtMaps = findViewById(R.id.BtMaps);
        BtStop = findViewById(R.id.BtStop);
        BtTelp = findViewById(R.id.BtTelp);
        button4 = findViewById(R.id.button4);

        BtStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DetailActivity2.class));
            }
        });

        BtTelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Callme.class));
            }
        });

        BtMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String asal = etAwa.getText().toString();
                String tujuan = etAkhi.getText().toString();

                DisplayJalur(asal, tujuan);
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://youtu.be/IpFX2vq8HKw?si=-9BBlJzwxBL8sBux"));
                startActivity(intent);
            }
        });
    }
    private void DisplayJalur(String asal, String tujuan) {
        try {
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + asal + "/" + tujuan);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}