package com.dileep.secondproject;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dileep.secondproject.Pjoclasses.DataPojo;

import java.util.ArrayList;

public class RecyclerAdpater extends RecyclerView.Adapter<RecyclerAdpater.RecyclerHolder> {

    ArrayList<DataPojo> dataPojoArrayList;

    public RecyclerAdpater(ArrayList<DataPojo> dataPojoArrayList) {
        this.dataPojoArrayList = dataPojoArrayList;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_recyclerview,parent,false);

//        RecyclerHolder holder=new RecyclerHolder(listView);

        return new RecyclerHolder(listView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {

       holder.nameTv.setText(dataPojoArrayList.get(position).getUserName());
       holder.descTv.setText(dataPojoArrayList.get(position).getDescription());

        holder.profilePic.setImageResource(dataPojoArrayList.get(position).getProfileImage());


    }

    @Override
    public int getItemCount() {
        return dataPojoArrayList.size();
    }



    public class RecyclerHolder extends RecyclerView.ViewHolder{

        ImageView profilePic;
        TextView nameTv,descTv;
        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            profilePic=itemView.findViewById(R.id.imageView);
            nameTv=itemView.findViewById(R.id.textview);
            descTv=itemView.findViewById(R.id.description);

        }
    }
}
