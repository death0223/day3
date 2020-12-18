package com.example.day3.anli.base;
public class FirstStudentBasePresenter<S extends FirstStudentBaseView> {
    public S iStudent;

    public void studentView(S s){
        iStudent=s;
    }


}
