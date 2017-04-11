package com.lwl.home.presenter;

import com.lwl.base.BasePresenter;
import com.lwl.home.bean.NewsBean;
import com.lwl.home.model.HomeItemModelImpl;
import com.lwl.home.model.IHomeItemModel;
import com.lwl.home.view.HomeItemView;

import java.util.List;

/**
 * Created by uk on 2017/4/7.
 */

public class HomeItemPresenter extends BasePresenter<HomeItemView> {
    private IHomeItemModel mHomeItemModel;
    public HomeItemPresenter() {
        mHomeItemModel = new HomeItemModelImpl();
    }


    public void getData(String path){
        mHomeItemModel.DownJson(path, new IHomeItemModel.DownJsonListener() {
            @Override
            public void succeesful(List<NewsBean> data) {

                getView().showList(data);
            }
        });
    }

}
