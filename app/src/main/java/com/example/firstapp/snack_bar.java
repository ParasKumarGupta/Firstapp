package com.example.firstapp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class snack_bar extends AppCompatActivity {

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);


        linearLayout = findViewById(R.id.ll_snack_bar);

        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

        Button button = findViewById(R.id.btn_snack_bar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(linearLayout, currentDate+" "+currentTime, Snackbar.LENGTH_LONG)
                        .setAction("Toast", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Toast.makeText(getApplicationContext(), currentDate+" "+currentTime, Toast.LENGTH_SHORT).show();
                            }
                        });
                snackbar.setActionTextColor(Color.RED);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        });




    }
}