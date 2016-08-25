package com.ghb.footnavibar;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class VPLinearActivity extends AppCompatActivity implements View.OnClickListener{

    final static String[] titles = new String[]{"find","chat","friend","me"};
    final static String ARG_NAME = "title";

    private TextView tv_find,tv_chat,tv_friends,tv_me;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vplinear);

        viewPager = (ViewPager) findViewById(R.id.vp);
        tv_find = (TextView) findViewById(R.id.tv_find);
        tv_find.setSelected(true);
        tv_chat = (TextView) findViewById(R.id.tv_chat);
        tv_friends = (TextView) findViewById(R.id.tv_friends);
        tv_me = (TextView) findViewById(R.id.tv_me);

        ArrayList<Fragment> list = new ArrayList<Fragment>();
        for (int i=0;i<titles.length;i++){
            DemoFragment demoFragment = new DemoFragment();
            Bundle args = new Bundle();
            args.putString(ARG_NAME,titles[i]);
            demoFragment.setArguments(args);
            list.add(demoFragment);
        }
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);

        tv_find.setOnClickListener(this);
        tv_chat.setOnClickListener(this);
        tv_friends.setOnClickListener(this);
        tv_me.setOnClickListener(this);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetTextViewSelected(position);
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
            case R.id.tv_find:
                resetTextViewSelected(0);
                viewPager.setCurrentItem(0,false);
            break;
            case R.id.tv_chat:
                resetTextViewSelected(1);
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.tv_friends:
                resetTextViewSelected(2);
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.tv_me:
                resetTextViewSelected(3);
                viewPager.setCurrentItem(3,false);
                break;
        }
    }

    private void resetTextViewSelected(int pos){
        tv_find.setSelected(pos==0?true:false);
        tv_chat.setSelected(pos==1?true:false);
        tv_friends.setSelected(pos==2?true:false);
        tv_me.setSelected(pos==3?true:false);
    }
}
