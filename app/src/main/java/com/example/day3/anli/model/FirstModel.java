package com.example.day3.anli.model;

import com.example.day3.anli.contract.FirstContract;
import com.example.day3.anli.util.InNetCallback;
import com.example.day3.anli.util.RetrofitUtil;

public class FirstModel implements FirstContract.InFirstModel {
    @Override
    public <T> void getModel(String url, InNetCallback<T> callback) {
        RetrofitUtil.getRetrofitUtil().get(url,callback);
    }
}
