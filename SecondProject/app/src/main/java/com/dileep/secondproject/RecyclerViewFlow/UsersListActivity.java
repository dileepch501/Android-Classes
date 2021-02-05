package com.dileep.secondproject.RecyclerViewFlow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dileep.secondproject.R;

import java.util.ArrayList;

public class UsersListActivity extends AppCompatActivity {

    ArrayList<UsersPojo> usersPojoArrayList=new ArrayList<>();
    USersListAdapter uSersListAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        recyclerView=findViewById(R.id.userListView);




        // data preperation
        usersPojoArrayList.add(new UsersPojo("Dileep"));
        usersPojoArrayList.add(new UsersPojo("Adithya"));
        usersPojoArrayList.add(new UsersPojo("Ramji"));
        usersPojoArrayList.add(new UsersPojo("ABCD"));
        usersPojoArrayList.add(new UsersPojo("EFGH"));
        usersPojoArrayList.add(new UsersPojo("IJKL"));
        usersPojoArrayList.add(new UsersPojo("Dileep"));
        usersPojoArrayList.add(new UsersPojo("Adithya"));
        usersPojoArrayList.add(new UsersPojo("Ramji"));
        usersPojoArrayList.add(new UsersPojo("ABCD"));
        usersPojoArrayList.add(new UsersPojo("EFGH"));
        usersPojoArrayList.add(new UsersPojo("IJKL"));
        usersPojoArrayList.add(new UsersPojo("Dileep"));
        usersPojoArrayList.add(new UsersPojo("Adithya"));
        usersPojoArrayList.add(new UsersPojo("Ramji"));
        usersPojoArrayList.add(new UsersPojo("ABCD"));
        usersPojoArrayList.add(new UsersPojo("EFGH"));
        usersPojoArrayList.add(new UsersPojo("IJKL"));

        // paassing data to adapter class
        uSersListAdapter=new USersListAdapter(usersPojoArrayList);


        // setting up recyclerview

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(uSersListAdapter);

    }
}