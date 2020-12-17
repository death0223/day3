package com.example.day3.anli.presenter;

import com.example.day3.anli.base.FirstNewBasePresenter;
import com.example.day3.anli.base.FirstStudentBase;
import com.example.day3.anli.base.FirstStudentBasePresenter;
import com.example.day3.anli.bean.FirstNewBean;
import com.example.day3.anli.bean.FirstStudentBean;
import com.example.day3.anli.contract.FirstContract;
import com.example.day3.anli.model.FirstModel;
import com.example.day3.anli.util.InNetCallback;


public class FirstStudentPresenter extends FirstStudentBasePresenter<FirstContract.InFirstStudentView> implements FirstContract.InFirstStudentPresent {
    private FirstModel model;

    public FirstStudentPresenter() {
        this.model = new FirstModel();
    }

    @Override
    public void getStudent() {
        model.getModel("exam2003/astudent.json", new InNetCallback<FirstStudentBean>() {
            @Override
            public void onSuccess(FirstStudentBean firstStudentBean) {
                iStudent.getStudentList(firstStudentBean);
            }

            @Override
            public void onFail(String error) {
                iStudent.getError(error);
            }
        });
    }
}
