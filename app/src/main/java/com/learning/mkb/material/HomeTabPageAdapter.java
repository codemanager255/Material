package com.learning.mkb.material;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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
