package com.example.day3.anli.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class FirstBase<P extends FirstBasePersenter> extends AppCompatActivity implements FirstBaseView {
    public P present;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        if (present==null){
            present =add();
            present.attachView(this);
        }
        initView();
        initDate();
    }

    protected abstract void initView();
    protected abstract void initDate();
    protected abstract int getLayout();
    public abstract P add();
}
