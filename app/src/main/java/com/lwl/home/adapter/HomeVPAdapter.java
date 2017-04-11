package com.lwl.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lwl.home.Constant;
import com.lwl.home.view.HomeItemFg;

/**
 * Created by uk on 2017/4/7.
 */

public class HomeVPAdapter extends FragmentStatePagerAdapter {

    public HomeVPAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return HomeItemFg.newInstance(Constant.URLS[position]);
    }

    @Override
    public int getCount() {
        return Constant.URLS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Constant.TITLES[position];
    }
}
