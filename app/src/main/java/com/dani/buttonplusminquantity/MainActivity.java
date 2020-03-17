package com.dani.buttonplusminquantity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private EditText harga;
    private EditText qtydan;
    private EditText hasil;

    private EditText harga2;
    private EditText qtydan2;
    private EditText hasil2;

    private EditText hasisemuadan;

    private TextWatcher textWatcher = null;
    private TextWatcher textWatcher2 = null;
    private TextWatcher textWatcherhasilsemua = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        harga = (EditText) findViewById(R.id.harga);
        qtydan = (EditText) findViewById(R.id.qtydan);
        hasil = (EditText) findViewById(R.id.hasil);

        harga2 = (EditText) findViewById(R.id.harga2);
        qtydan2 = (EditText) findViewById(R.id.qtydan2);
        hasil2 = (EditText) findViewById(R.id.hasil2);

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView tdate = (TextView) findViewById(R.id.tanggaldani);
                                TextView ttime = (TextView) findViewById(R.id.jamdani);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
                                SimpleDateFormat jamdani = new SimpleDateFormat("\nhh-mm-ss a");
                                String dateString = sdf.format(date);
                                String timeString = jamdani.format(date);
                                tdate.setText(dateString);
                                ttime.setText(timeString);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();




        hasisemuadan = (EditText) findViewById(R.id.hasilsemua);

        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int num1 = Integer.parseInt(harga.getText().toString());
                int num2 = Integer.parseInt(qtydan.getText().toString());

                int sum = num1 * num2;

               hasil.setText(Integer.toString(sum));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        textWatcher2 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int num12 = Integer.parseInt(harga2.getText().toString());
                int num22 = Integer.parseInt(qtydan2.getText().toString());

                int sum2 = num12 * num22;

                hasil2.setText(Integer.toString(sum2));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        textWatcherhasilsemua = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int hasilsemua1 = Integer.parseInt(hasil.getText().toString());
                int hasilsemua2 = Integer.parseInt(hasil2.getText().toString());

                int sum3 = hasilsemua1 + hasilsemua2;

                hasisemuadan.setText(Integer.toString(sum3));

                hasisemuadan= (EditText) findViewById(R.id.hasilsemua);
                Locale localeID = new Locale("in", "ID");
                NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                hasisemuadan.setText(formatRupiah.format((double)sum3));




            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };


            harga.addTextChangedListener(textWatcher);
           qtydan.addTextChangedListener(textWatcher);
        harga2.addTextChangedListener(textWatcher2);
        qtydan2.addTextChangedListener(textWatcher2);
        hasil.addTextChangedListener(textWatcherhasilsemua);
        hasil2.addTextChangedListener(textWatcherhasilsemua);


    }



    int minteger = 0;


    public void tambahqty(View view) {
        minteger = minteger + 1;
        display(minteger);
    }

    public void kurangqty(View view) {

        minteger = minteger - 1;
        display(minteger);
    }

    private void display(int number) {
        EditText displayInteger = (EditText) findViewById(
                R.id.qtydan);
        displayInteger.setText("" + number);
    }



//    BEDA PRODUK

    int minteger2 = 0;


    public void tambahqty2(View view) {
        minteger2 = minteger2 + 1;
        display2(minteger2);
    }

    public void kurangqty2(View view) {

        minteger2 = minteger2 - 1;
        display2(minteger2);
    }

    private void display2(int number2) {
        EditText displayInteger = (EditText) findViewById(
                R.id.qtydan2);
        displayInteger.setText("" + number2);
    }






}