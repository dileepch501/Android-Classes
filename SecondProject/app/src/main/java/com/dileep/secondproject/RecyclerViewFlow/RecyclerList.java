package com.dileep.secondproject.RecyclerViewFlow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dileep.secondproject.R;
import com.dileep.secondproject.RecyclerAdpater;

public class RecyclerList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdpater adpater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list);

        //step 1 binding with with id
        recyclerView=findViewById(R.id.recyclerList);
        adpater=new RecyclerAdpater();

        //step 2 setting LayoutManager

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(linearLayoutManager);

        // step 3 setting an adapter class
        recyclerView.setAdapter(adpater);
    }
}