package com.example.recyclerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {

    //4- Handling the click events

    private ItemClickListner clickListner;
    //1- Data Source
    private VaccineModel[] listData;

    public MyAdapter(VaccineModel[] listData) {
        this.listData = listData;
    }

    public void setClickListner(ItemClickListner clickListner) {
        this.clickListner = clickListner;
    }

    //2- View holder class:
    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView imageView;
        private TextView textView;



        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.textView = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if(clickListner != null){
                clickListner.onClick(v, getAdapterPosition());
            }
        }
    }


    //3- Implementing the methods
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.recyclerview_item,parent,false);

        CustomViewHolder viewHolder = new CustomViewHolder(listItem);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        final VaccineModel myListData = listData[position];
        holder.textView.setText(listData[position].getVaccineName());
        holder.imageView.setImageResource(listData[position].getVaccineImage());
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

}
