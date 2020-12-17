package com.example.day3.anli.presenter;

import com.example.day3.anli.base.FirstBasePersenter;
import com.example.day3.anli.bean.FirstBannerBean;
import com.example.day3.anli.bean.FirstNewBean;
import com.example.day3.anli.contract.FirstContract;
import com.example.day3.anli.fragment.FirstNew;
import com.example.day3.anli.model.FirstModel;
import com.example.day3.anli.util.InNetCallback;

public class FirstPresenter extends FirstBasePersenter<FirstContract.InFirstView> implements FirstContract.InFirstPresent {

    private FirstContract.InFirstModel model;
    private FirstContract.InFirstView view;

    public FirstPresenter(FirstContract.InFirstView view) {
        this.view = view;
        this.model=new FirstModel();
    }

    @Override
    public void getBanner() {
        model.getModel("exam2003/abannerlist.json", new InNetCallback<FirstBannerBean>() {

            @Override
            public void onSuccess(FirstBannerBean firstBean) {
                view.getBannerList(firstBean);
            }

            @Override
            public void onFail(String error) {
                view.getError(error);
            }
        });
    }
}
