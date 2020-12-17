package com.example.day3.anli.util;

public interface InNetCallback<T> {
    public void onSuccess(T t);

    public void onFail(String error);
}
