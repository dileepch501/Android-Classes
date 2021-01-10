package com.dileep.secondproject.ListViewPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.dileep.secondproject.R;

public class ActivityList extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=findViewById(R.id.listview1);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter(ActivityList.this,R.layout.spinner_list_item,getResources().getStringArray(R.array.autolist));

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String clickedItem=arrayAdapter.getItem(position);
                Toast.makeText(ActivityList.this, clickedItem, Toast.LENGTH_SHORT).show();
            }
        });

    }
}