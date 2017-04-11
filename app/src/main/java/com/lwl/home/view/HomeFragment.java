package com.lwl.home.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lwl.home.Constant;
import com.lwl.home.adapter.HomeVPAdapter;
import com.lwl.neteasenews.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.lwl.home.Constant.jsons;

/**
 * Created by uk on 2017/4/7.
 */

public class HomeFragment extends Fragment{
    public static Map<String, String> jsonMap = new HashMap<>();
    static {
        Log.d("isolation_uk", "static initializer: static");
        jsonMap.put(Constant.TOUTIAO_URL, jsons[0]);
        jsonMap.put(Constant.YULE_URL, jsons[1]);
        jsonMap.put(Constant.CAIJING_URL, jsons[2]);
        jsonMap.put(Constant.SHISHANG_URL, jsons[3]);
    }

    @Bind(R.id.home_tablayout)
    TabLayout mTabLayout;
    @Bind(R.id.home_vp)
    ViewPager mViewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("isolation_uk", "static initializer: onCreate");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("isolation_uk", "onCreateView: ");
        View view = inflater.inflate(R.layout.fg_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HomeVPAdapter adapter = new HomeVPAdapter(getChildFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
