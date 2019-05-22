package com.learning.mkb.material.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.learning.mkb.material.View.Chat;
import com.learning.mkb.material.View.SettingFragment;
import com.learning.mkb.material.View.StatusFragment;

public class HomeTabPageAdapter extends FragmentStatePagerAdapter {

    int numberOfTabs;
    public HomeTabPageAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return  new Chat();
            case 1:
                return  new StatusFragment();
            case 2:
                return  new SettingFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
