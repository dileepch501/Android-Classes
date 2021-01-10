package com.dileep.secondproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewExample extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example);
        listView=findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter(this,R.layout.spinner_list_item,getResources().getStringArray(R.array.spinnerlist));
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item=arrayAdapter.getItem(position);
                Toast.makeText(ListViewExample.this,item,Toast.LENGTH_SHORT).show();

            }
        });

    }
}