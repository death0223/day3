package com.example.day3.anli.base;
//FirstStudentBaseView
public class FirstStudentBasePresenter<S extends FirstStudentBaseView> {
    public S iStudent;

    public void studentView(S s){
        iStudent=s;
    }


}
