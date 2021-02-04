package com.dileep.secondproject.RecyclerViewFlow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dileep.secondproject.Pjoclasses.DataPojo;
import com.dileep.secondproject.R;
import com.dileep.secondproject.RecyclerAdpater;

import java.util.ArrayList;

public class RecyclerList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdpater adpater;
    ArrayList<DataPojo> dataPojoArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list);

     /*   DataPojo dataPojo=new DataPojo();
        dataPojo.setUserName("dileep");
        dataPojo.setDescription("Android developer");
        dataPojo.setProfileImage(R.drawable.google);
        dataPojoArrayList.add(dataPojo);

        DataPojo dataPojo1=new DataPojo();
        dataPojo1.setUserName("Aditya");
        dataPojo1.setDescription("Engineer");
        dataPojo1.setProfileImage(R.drawable.google);
        dataPojoArrayList.add(dataPojo1);

        DataPojo dataPojo2=new DataPojo();
        dataPojo2.setUserName("Ramji");
        dataPojo2.setDescription("Software Engineer");
        dataPojo2.setProfileImage(R.drawable.google);
        dataPojoArrayList.add(dataPojo2);*/

        dataPojoArrayList.add(new DataPojo("Dileep1","Android developer","",R.drawable.google));
        dataPojoArrayList.add(new DataPojo("Aditya","Android developer","",R.drawable.google));
        dataPojoArrayList.add(new DataPojo("Ramji","Android developer","",R.drawable.google));







        //step 1 binding with with id
        recyclerView=findViewById(R.id.recyclerList);
        adpater=new RecyclerAdpater(dataPojoArrayList);
        //step 2 setting LayoutManager
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(linearLayoutManager);
        // step 3 setting an adapter class
        recyclerView.setAdapter(adpater);
    }
}