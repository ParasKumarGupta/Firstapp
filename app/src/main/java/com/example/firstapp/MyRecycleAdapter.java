package com.example.firstapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.Hero;

import java.util.ArrayList;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolder>
{
    Context context;
    ArrayList<Hero> heroes;
    AlertDialog.Builder builder;
    MyRecycleAdapter(Context context, ArrayList<Hero> heroes)
    {
        this.context=context;
        this.heroes=heroes;
    }

    @NonNull
    @Override
    public MyRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleAdapter.ViewHolder holder, int position) {
        builder = new AlertDialog.Builder(context);
        additem(position,holder);
        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setCancelable(false);
                builder.setMessage("Are you sure you want to delete this item");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        heroes.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position,heroes.size());
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //No Button Response
                        dialog.cancel();
                        Toast.makeText(context,"You choose no response",Toast.LENGTH_SHORT).show();
                    }
                });
            AlertDialog alert= builder.create();
            alert.setTitle("Permanent Delete");
            alert.show();
            }
        });
        /*
        Toast.makeText(context,hero.getName(),Toast.LENGTH_SHORT).show();*/
        //holder.imageView.setImageDrawable(context.getResources().getDrawable(hero.getImage()));

    }
    private void additem(int position,ViewHolder holder){
    Hero hero = heroes.get(position);
    holder.txtname.setText(hero.getName());
    holder.txtteam.setText(hero.getTeam());
    //notifyItemInserted(position);
    //notifyItemRangeChanged(position,heroes.size());
}


    @Override
    public int getItemCount() {

        return heroes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView txtname;
        public TextView txtteam;
        public Button btndelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.img_listItem);
            this.txtname = (TextView) itemView.findViewById(R.id.txt_listname);
            this.txtteam = (TextView) itemView.findViewById(R.id.txt_listteam);
            this.btndelete= (Button) itemView.findViewById(R.id.btn_delete);
        }
    }
}
