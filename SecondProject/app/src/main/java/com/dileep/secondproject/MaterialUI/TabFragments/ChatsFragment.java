package com.dileep.secondproject.MaterialUI.TabFragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dileep.secondproject.AlarmManager.AlarmScreen;
import com.dileep.secondproject.MaterialUI.TabAdapters.ChatsListAdapter;
import com.dileep.secondproject.Pjoclasses.UsersPojo;
import com.dileep.secondproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.util.ArrayList;

public class ChatsFragment extends Fragment {

    View rootView;
    FloatingActionButton floating_action_button;
    RecyclerView chatsList;
    ChatsListAdapter chatsListAdapter;
    ArrayList<UsersPojo> usersPojoArrayList=new ArrayList<>();
    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.chats_tab, container, false);
        floating_action_button = rootView.findViewById(R.id.floating_action_button);
        chatsList = rootView.findViewById(R.id.chatsList);
        chatsList.setHasFixedSize(true);
        chatsList.setLayoutManager(new LinearLayoutManager(getContext()));
        chatsListAdapter = new ChatsListAdapter(usersPojoArrayList,getContext());
        chatsList.setAdapter(chatsListAdapter);
        progressDialog=new ProgressDialog(getContext());
        readData();

        floating_action_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getContext(), AlarmScreen.class);
                startActivity(intent);
//                storeData();

//                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.sample);


              /*  try {

//                    int resID=getResources().getIdentifier("sample.mp3", "raw", getContext().getPackageName());
//                    MediaPlayer mediaPlayer=MediaPlayer.create(getActivity().getApplicationContext(),resID);
                   MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sample);
//                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    mediaPlayer.pause();

                }catch (Exception e){
                    Log.e("error",e.getMessage());
                    e.printStackTrace();
                }*/

            }
        });

        return rootView;
    }

    private void readData() {
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("usersTable");

// Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                usersPojoArrayList.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    UsersPojo usersPojo=ds.getValue(UsersPojo.class);
                    usersPojoArrayList.add(usersPojo);
                }
                chatsListAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
//                UsersPojo usersPojo=dataSnapshot.getValue(UsersPojo.class);
//                String value = dataSnapshot.getValue(String.class);

//                Log.e("data", usersPojo.getName());



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Error", "Failed to read value.", error.toException());
            }
        });

    }

    private void storeData() {

        UsersPojo usersPojo = new UsersPojo("Dileep", "hi this is read", "10:30 pm", "20");
//        usersPojo.setName("Dileep");
//        usersPojo.setMessage("How are you..");
//        usersPojo.setCount("3");
//        usersPojo.setTime("10:30 pm");


        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("usersTable");

        myRef.push().setValue(usersPojo);
//        myRef.setValue(usersPojo);


//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Snackbar.make(floating_action_button,value, Snackbar.LENGTH_LONG)
//                        .setAction("Action", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//
//                            }
//                        }).show();
////                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
////                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });


    }
}
