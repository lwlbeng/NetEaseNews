package com.lwl.home.view;

import com.lwl.home.bean.NewsBean;

import java.util.List;

/**
 * Created by uk on 2017/4/7.
 */

public interface HomeItemView {
    void showList(List<NewsBean> data);
}
