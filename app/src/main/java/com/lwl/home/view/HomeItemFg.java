package com.lwl.home.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lwl.base.MVPBaseFragment;
import com.lwl.home.adapter.HomeItemAdapter1;
import com.lwl.home.bean.NewsBean;
import com.lwl.home.presenter.HomeItemPresenter;
import com.lwl.neteasenews.R;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

import butterknife.Bind;

/**
 * Created by uk on 2017/4/7.
 */

public class HomeItemFg extends MVPBaseFragment<HomeItemView, HomeItemPresenter> implements HomeItemView {

    @Bind(R.id.fg_item_fg_recycle)
    RecyclerView mRecycleView;


    @Override
    protected int getLayoutId() {
        return R.layout.fg_home_itemfg;
    }

    @Override
    protected HomeItemPresenter getPresenter() {
        return new HomeItemPresenter();
    }

    public static HomeItemFg newInstance(String path) {
        Bundle args = new Bundle();
        args.putString("home_key", path);
        HomeItemFg fragment = new HomeItemFg();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle arguments = getArguments();
        String path = arguments.getString("home_key");

        mPresenter.getData(path);
    }

    @Override
    public void showList(List<NewsBean> data) {
        MultiItemTypeAdapter multiItemTypeAdapter = new MultiItemTypeAdapter<>(getActivity(), data);
        multiItemTypeAdapter.addItemViewDelegate(new HomeItemAdapter1(getActivity()));
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycleView.setAdapter(multiItemTypeAdapter);

    }
}
