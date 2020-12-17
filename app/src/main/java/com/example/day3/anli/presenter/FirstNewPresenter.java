package com.example.day3.anli.presenter;

import com.example.day3.anli.base.FirstNewBasePresenter;
import com.example.day3.anli.bean.FirstNewBean;
import com.example.day3.anli.contract.FirstContract;
import com.example.day3.anli.model.FirstModel;
import com.example.day3.anli.util.InNetCallback;


public class FirstNewPresenter extends FirstNewBasePresenter<FirstContract.InFirstFragmentView> implements FirstContract.InFirstFragmentPresent {
    private FirstModel model;

    public FirstNewPresenter() {
        this.model = new FirstModel();
    }

//    public F iFragment;
//
//    public void fragmentView(F f){
//        iFragment=f;
//    }

    @Override
    public void getNew() {
        model.getModel("exam2003/anewslist.json", new InNetCallback<FirstNewBean>() {
            @Override
            public void onSuccess(FirstNewBean firstNewBean) {
                iFragment.getNewList(firstNewBean);
            }

            @Override
            public void onFail(String error) {
                iFragment.getError(error);
            }
        });
    }
}
