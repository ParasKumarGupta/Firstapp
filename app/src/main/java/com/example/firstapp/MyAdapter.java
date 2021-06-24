package com.example.firstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    Context context;
    String[] festivals;

    public MyAdapter(Context context, String[] festivals) {
        this.context=context;
        this.festivals=festivals;
    }

    @Override
    public int getCount() {
        return festivals.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);

        View view=layoutInflater.inflate(R.layout.listitems,parent,false);

        ImageView imageView=view.findViewById(R.id.imglistitems);

        TextView textView=view.findViewById(R.id.txtlistitems);

        textView.setText(festivals[position]);
        return view;
    }

}