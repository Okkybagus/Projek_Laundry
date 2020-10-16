package com.example.projek_laundry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Beranda extends AppCompatActivity {

    ImageButton img1,img2,img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        img1 = (ImageButton) findViewById(R.id.img1);
        img2 = (ImageButton) findViewById(R.id.img2);
        img3 = (ImageButton) findViewById(R.id.img3);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Gambar1());
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Gambar2());
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Gambar3());
            }
        });
    }

    public void btnTambahLaundry_onClick(View view) {
        Intent i = new Intent(Beranda.this, MainActivity.class);
        this.startActivity(i);
    }

    public void btnLihatLaundry_onClick(View view) {
        Intent i = new Intent(Beranda.this, LihatLaundry.class);
        this.startActivity(i);
    }
    private void loadFragment (Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}