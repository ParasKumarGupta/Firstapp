package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity{
    TextView txtname1;
    EditText edtname1,edtpassword1;
    ImageButton btnsubmit1;
    Button btnsubmit2,Alarm,btnsubmit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtname1 =findViewById(R.id.edt_name1);
        edtpassword1=findViewById(R.id.edt_password1);
        btnsubmit1= findViewById(R.id.btn_Submit1);
        btnsubmit2=findViewById(R.id.btn_Submit2);
        txtname1= findViewById(R.id.txt_output1);
        btnsubmit3 =findViewById(R.id.btn_Submit3);
        Alarm=findViewById(R.id.btnalarm);
        Intent i = getIntent();
        String str = i.getStringExtra("name1");
        edtname1.setText(str);
        String str1 = i.getStringExtra("pass2");
        edtpassword1.setText(str1);
        Alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(login.this, Alarm.class);
                startActivity(i1);
            }
        });

        btnsubmit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(login.this,"You Logged In Successfully!!",Toast.LENGTH_LONG).show();;
                Intent i =new Intent(login.this,listdemo.class);
                startActivity(i);
            }
        });
        btnsubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ie=new Intent(login.this,contactlist.class);
                startActivity(ie);
            }
        });
        btnsubmit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu =new PopupMenu(getApplicationContext(),v);
                popupMenu.inflate(R.menu.menu_items);
                popupMenu.setOnMenuItemClickListener(login.this::onOptionsItemSelected);
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                Toast.makeText(getApplicationContext(),"ADD",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_delete:
                Toast.makeText(getApplicationContext(),"Delete",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
