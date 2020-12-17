package com.example.day3.anli.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.day3.R;
import com.example.day3.anli.adatper.FirstNewAdatper;
import com.example.day3.anli.base.FirstNewBase;
import com.example.day3.anli.bean.FirstNewBean;
import com.example.day3.anli.contract.FirstContract;
import com.example.day3.anli.presenter.FirstNewPresenter;

import java.util.ArrayList;

public class FirstNew extends FirstNewBase<FirstNewPresenter> implements FirstContract.InFirstFragmentView {

    private ArrayList<FirstNewBean.NewsBean> list;
    private FirstNewAdatper adatper;

    @Override
    protected FirstNewPresenter getPresenter() {
        return new FirstNewPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_first_new;
    }

    protected void initDate() {
        presenter.getNew();
    }

    protected void initView(View view) {
        RecyclerView rel=view.findViewById(R.id.new_rel);

        list = new ArrayList<>();
        adatper = new FirstNewAdatper(getActivity(), list);
        rel.setLayoutManager(new LinearLayoutManager(getActivity()));
        rel.setAdapter(adatper);
    }


    @Override
    public void getNewList(FirstNewBean firstNewBean) {
        list.addAll(firstNewBean.getNews());
        adatper.notifyDataSetChanged();
    }

    @Override
    public void getError(String string) {

    }
}