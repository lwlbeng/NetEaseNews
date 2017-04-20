package com.lwl.live;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by L on 2017/4/19.
 */

public class Down {

    String url = "http://data.live.126.net/livechannel/previewlist.json";

    public byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() + ": with " + urlSpec);
            }

            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }

    public String getUrlString(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }

    public Bitmap getUrlBitmap(String urlSpec) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeByteArray(getUrlBytes(urlSpec), 0, getUrlBytes(urlSpec).length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public List<LiveBean> getListLiveBean() {
        List<LiveBean> beans = new ArrayList<>();


            try {
                String jsonString = getUrlString(url);
                String jsonString1 = jsonString.replace("\\r\\n", "\\n")
                                                .replace("\\/","/");
                Log.d("L-WL", "getListLiveBean: " + jsonString1);
                JSONObject jsonBody = new JSONObject(jsonString1);
                parseJson(beans, jsonBody);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return beans;
    }

    private void parseJson(List<LiveBean> beans, JSONObject jsonObject) throws JSONException {

        JSONArray beanJSONArray = jsonObject.getJSONArray("live_review");

        for (int i = 0; i< beanJSONArray.length(); i++) {
            JSONObject beanObject = beanJSONArray.getJSONObject(i);
            LiveBean bean = new LiveBean();
            bean.setImage(beanObject.getString("image"));
            bean.setBitmap(getUrlBitmap(bean.getImage()));
            bean.setLiveStatus(beanObject.getInt("liveStatus"));
            bean.setRoomName(beanObject.getString("roomName"));
            bean.setUserCount(beanObject.getInt("userCount"));
            if (beanObject.has("sourceinfo")) {
                bean.setTname(beanObject.getJSONObject("sourceinfo").getString("tname"));
            }
            beans.add(bean);
        }

    }
}
