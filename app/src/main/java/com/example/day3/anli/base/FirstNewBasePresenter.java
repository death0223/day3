package com.example.day3.anli.base;

public class FirstNewBasePresenter<F extends FirstNewBaseView> {
    public F iFragment;

    public void fragmentView(F f){
        iFragment=f;
    }


}
