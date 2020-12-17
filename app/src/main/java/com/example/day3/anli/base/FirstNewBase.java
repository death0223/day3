package com.example.day3.anli.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class FirstNewBase<P extends FirstNewBasePresenter> extends Fragment implements FirstNewBaseView {
    public P presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(getLayoutId(),container,false);
        presenter=getPresenter();
        presenter.fragmentView(this);
        initView(view);
        initDate();
        return view;
    }

    protected abstract P getPresenter();

    protected abstract int getLayoutId();
    protected abstract void initView(View view);
    protected abstract void initDate();
}
