package com.lwl.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lwl.neteasenews.R;

/**
 * Created by uk on 2017/4/7.
 */

public class MineFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("isolation_uk", "onCreateView: ");
        View view = inflater.inflate(R.layout.fg_mine, container, false);
        return view;
    }
}
