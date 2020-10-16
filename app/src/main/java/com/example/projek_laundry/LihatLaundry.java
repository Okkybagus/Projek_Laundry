package com.example.projek_laundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projek_laundry.entity.Laundry;
import com.example.projek_laundry.model.LaundryModel;

import java.util.ArrayList;

public class LihatLaundry extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listLaundry;
    private ArrayAdapter<String> adapterDaftarLaundry;

    private ArrayList<String> daftarNama;

    private ArrayList<Laundry> daftarLaundry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_laundry);

        this.listLaundry = this.findViewById(R.id.list_daftar_laundry);
//        this.Harga = this.findViewById(R.id.list_daftar_harga);
        this.daftarNama = new ArrayList<>();
        this.isiDaftarNama();

        this.adapterDaftarLaundry = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                this.daftarNama
        );

        this.listLaundry.setAdapter(this.adapterDaftarLaundry);
        this.listLaundry.setOnItemClickListener(this);
    }

    private void isiDaftarNama() {
        LaundryModel ml = new LaundryModel(this);
        ArrayList<Laundry>  daftarLaundry = ml.ambilSemuaLaundry();
        for (Laundry laundry : daftarLaundry)
        {
            this.daftarNama.add(laundry.getNama());
        }

        this.daftarLaundry = daftarLaundry;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//        int laundryid = lKlik.getId();
//
//        Intent i = new Intent(LihatLaundry.this, MainActivity.class);
//        i.putExtra("laundryid", laundryid);
//        this.startActivity(i);
    }
    public void btnKembali_onClick(View view)
    {
        this.finish();
    }

//    public void btnRefresh_onClick(View view)
//    {
//        this.daftarLaundry.clear();
//
//        this.daftarNama.clear();
//
//        this.adapterDaftarLaundry.clear();
//
//        this.isiDaftarNama();
//
//        this.adapterDaftarLaundry.notifyDataSetChanged();
//
//        Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
//    }
}