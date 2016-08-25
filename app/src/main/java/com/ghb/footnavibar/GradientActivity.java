package com.ghb.footnavibar;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class GradientActivity extends AppCompatActivity implements View.OnClickListener {

    final static String[] titles = new String[]{"find", "chat", "friend", "me"};
    final static String ARG_NAME = "title";

    private ViewPager viewPager;
    private TabView tab1, tab2, tab3, tab4;
    private ArrayList<TabView> tabs = new ArrayList<TabView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradient);

        viewPager = (ViewPager) findViewById(R.id.vp);
        tab1 = (TabView) findViewById(R.id.tab1);
        tab1.setIconAlpha(1.0f);
        tab2 = (TabView) findViewById(R.id.tab2);
        tab3 = (TabView) findViewById(R.id.tab3);
        tab4 = (TabView) findViewById(R.id.tab4);

        tab1.setIcon(R.mipmap.ic_menu_start_conversation);
        tab2.setIcon(R.mipmap.ic_menu_friendslist);
        tab3.setIcon(R.mipmap.ic_menu_emoticons);
        tab4.setIcon(R.mipmap.ic_menu_allfriends);


        tabs.add(tab1);
        tabs.add(tab2);
        tabs.add(tab3);
        tabs.add(tab4);


        ArrayList<Fragment> list = new ArrayList<Fragment>();
        for (int i = 0; i < titles.length; i++) {
            DemoFragment demoFragment = new DemoFragment();
            Bundle args = new Bundle();
            args.putString(ARG_NAME, titles[i]);
            demoFragment.setArguments(args);
            list.add(demoFragment);
        }
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);

        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);
        tab4.setOnClickListener(this);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset>0){
                    TabView left = tabs.get(position);
                    TabView right = tabs.get(position+1);
                    left.setIconAlpha(1f-positionOffset);
                    right.setIconAlpha(positionOffset);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.tab1:
                resetIndicators(0);
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.tab2:
                resetIndicators(1);
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.tab3:
                resetIndicators(2);
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.tab4:
                resetIndicators(3);
                viewPager.setCurrentItem(3,false);
                break;
        }
    }

    private void resetIndicators(int pos){
        for (int i = 0; i < tabs.size(); i++) {
            tabs.get(i).setIconAlpha(pos==i?1.0f:0f);
        }
    }
}
