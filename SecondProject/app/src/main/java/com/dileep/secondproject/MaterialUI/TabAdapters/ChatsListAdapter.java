package com.dileep.secondproject.MaterialUI.TabAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dileep.secondproject.R;
import com.dileep.secondproject.RecyclerAdpater;

public class ChatsListAdapter extends RecyclerView.Adapter<ChatsListAdapter.ChatsListHolder> {



    @NonNull
    @Override
    public ChatsListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list_layout,parent,false);
        return new ChatsListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatsListHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ChatsListHolder extends RecyclerView.ViewHolder{

        public ChatsListHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
