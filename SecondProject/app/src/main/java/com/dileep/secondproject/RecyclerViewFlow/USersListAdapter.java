package com.dileep.secondproject.RecyclerViewFlow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dileep.secondproject.R;

import java.util.ArrayList;

public class USersListAdapter extends RecyclerView.Adapter<USersListAdapter.UsersHolder> {

    ArrayList<UsersPojo> usersPojoArrayList;

    public USersListAdapter(ArrayList<UsersPojo> usersPojoArrayList) {
        this.usersPojoArrayList = usersPojoArrayList;
    }

    @NonNull
    @Override
    public UsersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.users_layout_file,parent,false);

        return new UsersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersHolder holder, int position) {

        holder.usernmae.setText(usersPojoArrayList.get(position).getUserName());

    }

    @Override
    public int getItemCount() {
        return usersPojoArrayList.size();
    }

    public class UsersHolder extends RecyclerView.ViewHolder{

        TextView usernmae;
        public UsersHolder(@NonNull View itemView) {
            super(itemView);

            usernmae=itemView.findViewById(R.id.username);
        }
    }
}
