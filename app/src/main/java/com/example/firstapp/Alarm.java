package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Date;

public class Alarm extends AppCompatActivity {
    TimePicker timePicker;
    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        timePicker = findViewById(R.id.timepicker);
        textView = findViewById(R.id.txt_show_time);
        editText = findViewById(R.id.edt_time);
        button = findViewById(R.id.btn_set_alarm);
        timePicker.setIs24HourView(true);
        String toastMessage;
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                textView.setText("Alarm will ring at: "+ hourOfDay+" : "+minute);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateAlarm();
            }
        });


    }
    private void generateAlarm(){
        int i = Integer.parseInt(editText.getText().toString());
        Intent intent = new Intent(this,broad.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,250,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+ (i*1000),pendingIntent);
        Toast.makeText(this,"Alarm will will ring after: "+i+" seconds",Toast.LENGTH_SHORT).show();
    }



}