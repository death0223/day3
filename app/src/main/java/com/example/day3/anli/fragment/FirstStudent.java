package com.example.day3.anli.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day3.R;
import com.example.day3.anli.adatper.FirstStudentAdatper;
import com.example.day3.anli.base.FirstStudentBase;
import com.example.day3.anli.base.FirstStudentBasePresenter;
import com.example.day3.anli.bean.FirstBannerBean;
import com.example.day3.anli.bean.FirstStudentBean;
import com.example.day3.anli.contract.FirstContract;
import com.example.day3.anli.presenter.FirstStudentPresenter;

import java.util.ArrayList;
import java.util.List;

public class FirstStudent extends FirstStudentBase<FirstStudentPresenter> implements FirstContract.InFirstStudentView {

    private ArrayList<FirstStudentBean.StudenlistBean> list;
    private FirstStudentAdatper adatper;

    @Override
    protected FirstStudentPresenter getPresenter() {
        return new FirstStudentPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_first_student;
    }

    @Override
    protected void initView(View view) {
        RecyclerView rel = view.findViewById(R.id.student_rel);
        list = new ArrayList<>();
        adatper = new FirstStudentAdatper(getActivity(), list);
        rel.setLayoutManager(new LinearLayoutManager(getActivity()));
        rel.setAdapter(adatper);
    }

    @Override
    protected void initDate() {
        presenter.getStudent();
    }

    @Override
    protected void initLister() {
        adatper.setOnClick(new FirstStudentAdatper.OnClick() {
            @Override
            public void onClick(int position) {
                list.remove(position);
                adatper.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void getStudentList(FirstStudentBean firstStudentBean) {
        List<FirstStudentBean.StudenlistBean> studenlist = firstStudentBean.getStudenlist();
        list.addAll(studenlist);
        adatper.notifyDataSetChanged();
    }

    @Override
    public void getError(String string) {

    }
}