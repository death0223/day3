package com.example.day3.anli.base;

public
class FirstBasePersenter<V extends FirstBaseView>{
    public V iView;

    public void attachView(V v){
        iView=v;
    }
}
