package com.lwl.home.model;

import com.lwl.home.bean.NewsBean;
import com.lwl.home.util.ParseUtil;
import com.lwl.home.view.HomeFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by uk on 2017/4/7.
 */

public class HomeItemModelImpl implements IHomeItemModel {

    //下载新闻json
    @Override
    public void DownJson(String path,DownJsonListener downJsonListener) {
        useOkHttpForJson(downJsonListener, path);
    }

    private void useOkHttpForJson(final DownJsonListener listener, final String url) {
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        String key = HomeFragment.jsonMap.get(url);
                        return ParseUtil.parseToutiaoFromJson(key, response.body().string());
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        listener.succeesful((List<NewsBean>) response);
                    }
                });

    }

}
