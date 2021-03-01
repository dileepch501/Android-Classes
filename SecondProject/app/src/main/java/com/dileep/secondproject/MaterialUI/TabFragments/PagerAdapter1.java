package com.dileep.secondproject.MaterialUI.TabFragments;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter1 extends FragmentPagerAdapter {

    int tabcounts;
    Context context;

    public PagerAdapter1(@NonNull FragmentManager fm, int tabcount) {
        super(fm);

        this.tabcounts = tabcount;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                ChatsFragment chatsFragment = new ChatsFragment();
                return chatsFragment;
            case 1:
                StatusFragment statusFragment=new StatusFragment();
                return statusFragment;
            case 2:
                CallsFragment callsFragment=new CallsFragment();
                return callsFragment;
            default:
                ChatsFragment chatsFragment1 = new ChatsFragment();
                return chatsFragment1;
        }

    }

    @Override
    public int getCount() {
        return tabcounts;
    }
}
