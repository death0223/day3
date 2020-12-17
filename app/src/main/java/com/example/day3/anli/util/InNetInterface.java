package com.example.day3.anli.util;

import java.util.HashMap;

public interface InNetInterface {
    public <T> void get(String url, InNetCallback callback);

    public <T> void post(String url, InNetCallback callback);

    public <T> void post(String url, HashMap<String,String> map,InNetCallback callback);
}
