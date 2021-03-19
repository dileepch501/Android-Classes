package com.dileep.secondproject.MaterialUI.TabAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dileep.secondproject.Pjoclasses.UsersPojo;
import com.dileep.secondproject.R;
import com.dileep.secondproject.RecyclerAdpater;

import java.util.ArrayList;

public class ChatsListAdapter extends RecyclerView.Adapter<ChatsListAdapter.ChatsListHolder> {

    ArrayList<UsersPojo> usersPojoArrayList;
    Context context;

    public ChatsListAdapter(ArrayList<UsersPojo> usersPojoArrayList, Context context) {
        this.usersPojoArrayList = usersPojoArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatsListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list_layout,parent,false);
        return new ChatsListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatsListHolder holder, int position) {
            holder.nameTv.setText(usersPojoArrayList.get(position).getName());
            holder.messageTv.setText(usersPojoArrayList.get(position).getMessage());
            holder.countTv.setText(usersPojoArrayList.get(position).getCount());
            holder.timeTv.setText(usersPojoArrayList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return usersPojoArrayList.size();
    }

    public class ChatsListHolder extends RecyclerView.ViewHolder{
        TextView nameTv,messageTv,timeTv,countTv;

        public ChatsListHolder(@NonNull View itemView) {
            super(itemView);

            nameTv=itemView.findViewById(R.id.nameTv);
            messageTv=itemView.findViewById(R.id.messageTv);
            timeTv=itemView.findViewById(R.id.timeTv);
            countTv=itemView.findViewById(R.id.countTv);
        }
    }
}
