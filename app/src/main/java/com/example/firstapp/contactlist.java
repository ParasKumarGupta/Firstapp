package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class contactlist extends AppCompatActivity {
    //ListView listView;
    RecyclerView recyclerView;
    EditText edthero,edtteam;
    ArrayList<Hero> heroes;
    Button btnupdate;
    MyRecycleAdapter myRecycleAdapter;
    //String[] festivals = { "Diwali", "Holi", "Christmas", "Eid", "Baisakhi", "Halloween" ,"Lohri"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactlist);
        //listView=findViewById(R.id.contact_items);
        recyclerView=findViewById(R.id.Recycler_view);
        edthero=findViewById(R.id.edt_hero);
        edtteam=findViewById(R.id.edt_team);
        btnupdate=findViewById(R.id.btn_update);
        heroes=new ArrayList<>();

        /*heroes.add(new Hero(R.drawable.spiderman,"SpiderMan","Avengers"));
        heroes.add(new Hero(R.drawable.ironman,"IronMan","Avengers"));
        heroes.add(new Hero(R.drawable.captain,"Captain America","Avengers"));
        heroes.add(new Hero(R.drawable.thor,"Thor","Avengers"));*/
        btnupdate.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             String hero = edthero.getText().toString();
                                             String team = edtteam.getText().toString();
                                             heroes.add(new Hero(hero, team));
                                             //myRecycleAdapter.notifyDataSetChanged();
                                         }
                                     });

        //ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.list_item,R.id.txt_listItem,festivals);

        //MyContactAdapter myContactAdapter=new MyContactAdapter(this,heroes);
        //listView.setAdapter(myContactAdapter);

        MyRecycleAdapter myRecycleAdapter=new MyRecycleAdapter(this,heroes);
        recyclerView.setHasFixedSize(true);
        //LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3,LinearLayoutManager.HORIZONTAL,false);

        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(myRecycleAdapter);





        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String value=festivals[position];
                Toast.makeText(contactlist.this, value, Toast.LENGTH_SHORT).show();
            }
        });
*/
    }
}