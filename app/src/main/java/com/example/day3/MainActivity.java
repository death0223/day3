package com.example.day3;

import android.content.Context;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.day3.anli.adatper.FirstTabAdatper;
import com.example.day3.anli.base.FirstBase;
import com.example.day3.anli.bean.FirstBannerBean;
import com.example.day3.anli.bean.FirstNewBean;
import com.example.day3.anli.contract.FirstContract;
import com.example.day3.anli.fragment.FirstNew;
import com.example.day3.anli.fragment.FirstStudent;
import com.example.day3.anli.presenter.FirstPresenter;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FirstBase<FirstPresenter> implements FirstContract.InFirstView {

    private Banner banner;
    private ArrayList<FirstBannerBean.BannerlistBean> bannerlist;
    private TabLayout firstTab;
    private ViewPager firstVp;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        present = new FirstPresenter(this);
//        initView();
//        initDate();
//    }

    protected int getLayout(){
        return R.layout.activity_main ;
    }

    protected void initDate() {
        present.getBanner();
    }

    @Override
    public FirstPresenter add() {
        return new FirstPresenter(this);
    }


    protected void initView() {
        banner = findViewById(R.id.banner);
        firstTab = findViewById(R.id.first_tab);
        firstVp = findViewById(R.id.first_vp);

        ArrayList<String> list = new ArrayList<>();
        list.add("学校新闻");
        list.add("班级成绩查询");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FirstNew());
        fragments.add(new FirstStudent());
        FirstTabAdatper adatper = new FirstTabAdatper(getSupportFragmentManager(), list, fragments);
        firstVp.setAdapter(adatper);
        firstTab.setupWithViewPager(firstVp);
    }

    @Override
    public void getBannerList(FirstBannerBean firstBean) {
        List<FirstBannerBean.BannerlistBean> bannerlist1 = firstBean.getBannerlist();
        bannerlist = new ArrayList<>();
        bannerlist.addAll(bannerlist1);
        banner.setImages(bannerlist);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                FirstBannerBean.BannerlistBean fb = (FirstBannerBean.BannerlistBean) path;
                Glide.with(context).load(fb.getImageurl()).into(imageView);
            }
        }).start();


    }

    @Override
    public void getError(String string) {

    }
}