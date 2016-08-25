package com.ghb.footnavibar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * (what to do)
 * Created by lakewave on 2016/8/25.
 */
public class VPAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> list;

    public VPAdapter(FragmentManager fm,ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
