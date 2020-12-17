package com.example.day3.anli.contract;

import com.example.day3.anli.base.FirstBaseView;
import com.example.day3.anli.base.FirstNewBaseView;
import com.example.day3.anli.base.FirstStudentBase;
import com.example.day3.anli.base.FirstStudentBaseView;
import com.example.day3.anli.bean.FirstBannerBean;
import com.example.day3.anli.bean.FirstNewBean;
import com.example.day3.anli.bean.FirstStudentBean;
import com.example.day3.anli.util.InNetCallback;

public class FirstContract {
    public interface InFirstModel{
        <T> void getModel(String url, InNetCallback<T> callback);
    }
    public interface InFirstPresent{
        void getBanner();
    }
    public interface InFirstView extends FirstBaseView {
        void getBannerList(FirstBannerBean firstBean);
        void getError(String string);
    }

    public interface InFirstFragmentPresent{
        void getNew();
    }
    public interface InFirstFragmentView extends FirstNewBaseView {
        void getNewList(FirstNewBean firstNewBean);
        void getError(String string);
    }

    public interface InFirstStudentPresent{
        void getStudent();
    }
    public interface InFirstStudentView extends FirstStudentBaseView{
        void getStudentList(FirstStudentBean firstStudentBean);
        void getError(String string);
    }

}
