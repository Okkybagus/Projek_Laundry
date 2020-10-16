package com.example.projek_laundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projek_laundry.entity.Laundry;
import com.example.projek_laundry.model.LaundryModel;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtnama;
    TextView edtharga;
    String name;
    LihatLaundry laundrypilih;
    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.edtnama = this.findViewById(R.id.edt_name);
        this.edtharga = this.findViewById(R.id.price_textview);
    }

    public void increment(View view){//perintah tombol tambah
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }
    public void decrement(View view){//perintah tombol tambah
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }


    public void Submitorder(View view) {
        String nama = this.edtnama.getText().toString();
        String harga = this.edtharga.getText().toString();
        Log.v("MainActivity","Nama:"+name);

        CheckBox ckcb= (CheckBox) findViewById(R.id.ck);
        boolean kck=ckcb.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+kck);
        CheckBox ckscb= (CheckBox) findViewById(R.id.cks);
        boolean kcks=ckscb.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+kcks);
        CheckBox setrikacb= (CheckBox) findViewById(R.id.setrika);
        boolean ksetrika=setrikacb.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+ksetrika);
        CheckBox selimutcb= (CheckBox) findViewById(R.id.selimut);
        boolean kselimut=selimutcb.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+kselimut);;
        CheckBox sepatucb= (CheckBox) findViewById(R.id.sepatu);
        boolean ksepatu=sepatucb.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+ksepatu);
        CheckBox karpetcb= (CheckBox) findViewById(R.id.karpet);
        boolean kkarpet=karpetcb.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+kkarpet);

        int price=calculateprice(kck,kcks,ksetrika,kselimut,ksepatu,kkarpet);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);
        displayMessage(pricemessage);

        Laundry laundry = new Laundry();
        laundry.setNama(nama);
        laundry.setHarga(harga);

        LaundryModel mlaundy = new LaundryModel(this);
        mlaundy.tambahLaundry(laundry);
    }
    private int calculateprice(boolean kck,boolean kcks,boolean ksetrika,boolean kselimut,boolean ksepatu, boolean kkarpet){
        int harga=0;

        if(kck){
            harga=harga+3000;
        }
        if(kcks){
            harga=harga+4000;
        }
        if (ksetrika){
            harga=harga+3000;
        }
        if (kselimut){
            harga=harga+7000;
        }
        if (ksepatu){
            harga=harga+6000;
        }
        if(kkarpet){
            harga=harga+6000;
        }

        return quantity * harga;
    }
    private String createOrderSummary(int price) {//hasil pemesanan
        String pricemessage=""+price;
        return  pricemessage;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }

    public void btnKembali_onClick(View view) {
        Intent i = new Intent(MainActivity.this, Beranda.class);
        startActivity(i);
    }
}