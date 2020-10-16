package com.example.projek_laundry.model;

import android.content.Context;
import android.database.Cursor;

import com.example.projek_laundry.entity.Laundry;
import com.example.projek_laundry.helper.DbHelper;

import java.util.ArrayList;

public class LaundryModel {
    private Context context;
    private DbHelper db;

    public LaundryModel(Context context) {
        this.context = context;
        this.db = new DbHelper(this.context);
    }

    public void tambahLaundry(Laundry laundry)
    {
        String nama = laundry.getNama();
        String harga = laundry.getHarga();

        String sql = "INSERT INTO laundry1 (nama, harga) VALUES ('" + nama + "', '" + harga + "')";
        this.db.tulisData(sql);
    }

    public void hapusLaundry(Laundry laundry)
    {
        String sql = "DELETE FROM laundry1 WHERE id = '" + laundry.getId() + "'";
        db.tulisData(sql);
    }

    public ArrayList<Laundry> ambilSemuaLaundry()
    {
        String sql = "SELECT * FROM laundry1";

        Cursor c = this.db.bacaData(sql);
        ArrayList<Laundry> hasil = new ArrayList<>();
        if(c.getCount() < 1)
            return hasil;
        c.moveToFirst(); // Pasang di baris ke-1
        do {
               int id = c.getInt(0); // Kolom ke-0 INTEGER
            String nama = c.getString(1); // Kolom ke-1 VARCHAR
            String harga = c.getString(2); // Kolom ke-2 VARCHAR

            Laundry laundry = new Laundry();
            laundry.setId(id);
            laundry.setNama(nama);
            laundry.setHarga(harga);
            hasil.add(laundry);
        }
        while(c.moveToNext());
        return hasil;
    }
    public Laundry cariBerdasarkanId(int id)
    {
        String sql = "SELECT * FROM laundry1 WHERE id = '" + id + "'";
        Cursor c = this.db.bacaData(sql);
        if(c.getCount() > 0)
        {
            c.moveToFirst();
            String nama = c.getString(1);
            String harga = c.getString(2);
            Laundry laundry = new Laundry();
            laundry.setId(id);
            laundry.setNama(nama);
            laundry.setHarga(harga);
            return laundry;
        }
        return null;
    }
}
