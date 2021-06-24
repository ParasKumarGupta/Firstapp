package com.example.firstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyContactAdapter extends BaseAdapter {
    Context context;
    ArrayList<Hero> heroes;

    public MyContactAdapter(Context context, ArrayList<Hero> heroes) {
        this.context=context;
        this.heroes=heroes;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);

        View view=layoutInflater.inflate(R.layout.list_item,parent,false);

        ImageView imageView=view.findViewById(R.id.img_listItem);

        TextView txtname=view.findViewById(R.id.txt_listname);
        TextView txtteam=view.findViewById(R.id.txt_listteam);

        Hero hero=heroes.get(position);
        //imageView.setImageDrawable(context.getResources().getDrawable(hero.getImage()));
        txtname.setText(hero.getName());
        txtteam.setText(hero.getTeam());
        return view;
    }

}