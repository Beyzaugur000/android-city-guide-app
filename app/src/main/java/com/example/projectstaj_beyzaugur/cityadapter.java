package com.example.projectstaj_beyzaugur;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;


import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class cityadapter extends RecyclerView.Adapter<cityadapter.cityholder> {

    private final RecyclerViewInterface recyclerViewInterface;

    private Context context1;
    private final ArrayList<city> cityArrayList;

    public cityadapter(RecyclerViewInterface recyclerViewInterface, ArrayList<city> cityArrayList, Context context) {
        this.context1 = context;
        this.cityArrayList = cityArrayList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public cityholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context1);
        View v = inflater.inflate(R.layout.recyle_row, parent, false);
        return new cityholder(v, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull cityholder holder, int position) {


        holder.cityname.setText(cityArrayList.get(position).getCityname());
        holder.image.setImageResource(cityArrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return cityArrayList.size();
    }


    public class cityholder extends RecyclerView.ViewHolder {
        TextView cityname;
        ImageView image;


        public cityholder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            cityname = itemView.findViewById(R.id.RecylertextView);
            image = itemView.findViewById(R.id.RecylerImageView);

            itemView.setOnClickListener(v -> {


                if (recyclerViewInterface != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(pos);
                    }
                }
            });

        }

    }


    public void setOnItemClickListener() {
    }
}




