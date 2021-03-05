package com.dileep.secondproject.MaterialUI.TabFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dileep.secondproject.MaterialUI.TabAdapters.ChatsListAdapter;
import com.dileep.secondproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class ChatsFragment extends Fragment {

    View rootView;
    FloatingActionButton floating_action_button;
    RecyclerView chatsList;
    ChatsListAdapter chatsListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.chats_tab,container,false);
        floating_action_button=rootView.findViewById(R.id.floating_action_button);
        chatsList=rootView.findViewById(R.id.chatsList);
        chatsList.setHasFixedSize(true);
        chatsList.setLayoutManager(new LinearLayoutManager(getContext()));
        chatsListAdapter=new ChatsListAdapter();
        chatsList.setAdapter(chatsListAdapter);

        floating_action_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Snackbar.make(floating_action_button,"Heloooo", Snackbar.LENGTH_LONG)
                     .setAction("Action", new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {

                         }
                     }).show();
            }
        });

        return rootView;
    }
}
