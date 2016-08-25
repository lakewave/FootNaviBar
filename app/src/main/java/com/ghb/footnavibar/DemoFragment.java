package com.ghb.footnavibar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * (what to do)
 * Created by lakewave on 2016/8/25.
 */
public class DemoFragment extends Fragment {

    private String title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getArguments()!=null){
            title = getArguments().getString("title");
        }

        TextView tv = new TextView(getContext());
        tv.setText(title);
        tv.setGravity(Gravity.CENTER);
        return tv;
    }
}
