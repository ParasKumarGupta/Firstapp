package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class listdemo extends AppCompatActivity {
    ListView listView;
    String[] festivals = { "LinkedIn", "GeeksForGeeks", "IBM", "Google", "Internshala", "Coursera" ,"Microsoft"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdemo);
        listView=findViewById(R.id.contact_items);
        //ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.list_item,R.id.txt_listItem,festivals);

        MyAdapter myadapter=new MyAdapter(this,festivals);
        listView.setAdapter(myadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value;
                value = festivals[position];
                Toast.makeText(listdemo.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}