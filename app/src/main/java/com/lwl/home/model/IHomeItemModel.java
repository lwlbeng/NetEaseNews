package com.lwl.home.model;

import com.lwl.home.bean.NewsBean;

import java.util.List;

/**
 * Created by uk on 2017/4/7.
 */

public interface IHomeItemModel {

    public interface DownJsonListener{
        void succeesful(List<NewsBean> data);
    }
    void DownJson(String path, DownJsonListener downJsonListener);
}
