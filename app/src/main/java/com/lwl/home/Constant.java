package com.lwl.home;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by uk on 2017/4/7.
 */

public class Constant {

    //    头条
    public static final String TOUTIAO_URL = "http://c.3g.163.com/nc/article/headline/T1348647853363/0-140.html";
    //娱乐
    public static final String YULE_URL = "http://c.3g.163.com/nc/article/list/T1348648517839/0-20.html";
    //财经
    public static final String CAIJING_URL = "http://c.m.163.com/nc/article/list/T1348648756099/0-20.html";
//时尚
    public static final String SHISHANG_URL = "http://c.m.163.com/nc/article/list/T1348650593803/0-20.html";
    //热点
    public static final String REDIAN_URL = "http://c.3g.163.com/recommend/getSubDocPic?passport=&devId=B45E64F7-002F-4126-8C7E-3DB0ACF6C85E&size=40";
//数组
    public static final String[] URLS = new String[]{TOUTIAO_URL, YULE_URL, CAIJING_URL, SHISHANG_URL};
    public static final String[] TITLES = new String[]{"头条", "娱乐", "财经", "时尚"};
    public static final String[] jsons = new String[]{"T1348647853363", "T1348648517839", "T1348648756099", "T1348650593803"};
    public static final Map<String, String> jsonMap = new HashMap<>();



}
