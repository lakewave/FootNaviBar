package com.ghb.footnavibar;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class VPRadioActivity extends AppCompatActivity {

    final static String[] titles = new String[]{"find","chat","friend","me"};
    final static String ARG_NAME = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpradio);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.vp);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg);
        final RadioButton rb_find = (RadioButton) findViewById(R.id.rb_find);
        final RadioButton rb_chat = (RadioButton) findViewById(R.id.rb_chat);
        final RadioButton rb_friends = (RadioButton) findViewById(R.id.rb_friends);
        final RadioButton rb_me = (RadioButton) findViewById(R.id.rb_me);

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

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_find:
                        viewPager.setCurrentItem(0,false);
                        break;
                    case R.id.rb_chat:
                        viewPager.setCurrentItem(1,false);
                        break;
                    case R.id.rb_friends:
                        viewPager.setCurrentItem(2,false);
                        break;
                    case R.id.rb_me:
                        viewPager.setCurrentItem(3,false);
                        break;
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rb_find.setChecked(true);
                        break;
                    case 1:
                        rb_chat.setChecked(true);
                        break;
                    case 2:
                        rb_friends.setChecked(true);
                        break;
                    case 3:
                        rb_me.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
