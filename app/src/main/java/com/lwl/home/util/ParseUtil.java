package com.lwl.home.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lwl.home.bean.NewsBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by uk on 2017/4/7.
 */

public class ParseUtil {

    public static List<NewsBean> parseToutiaoFromJson(String key, String json) {

        try {
            JSONArray array = new JSONObject(json).getJSONArray(key);
            TypeToken<List<NewsBean>> tt = new TypeToken<List<NewsBean>>(){};
            return new Gson().fromJson(array.toString(), tt.getType());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
