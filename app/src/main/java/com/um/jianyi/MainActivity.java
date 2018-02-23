package com.um.jianyi;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener {
    private ViewPager mViewPager;
    private List<View> mViews = new ArrayList<View>();
    private PagerAdapter mAdapter;

    private LinearLayout mTabGoout;
    private LinearLayout mTabHomepage;
    private LinearLayout mTabMemorandum;

    private ImageButton mGooutImg;
    private ImageButton mHomepageImg;
    private ImageButton mMemorandumImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initEvents();

    }

    private void initEvents(){
        mTabMemorandum.setOnClickListener(this);
        mTabGoout.setOnClickListener(this);
        mTabHomepage.setOnClickListener(this);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int currentItem = mViewPager.getCurrentItem();
                //resetImg();
                switch (currentItem)
                {
                    case 0:
                        mGooutImg.setImageResource(R.drawable.haha);
                        break;
                    case 1:
                        mHomepageImg.setImageResource(R.drawable.haha);
                        break;
                    case 2:
                        mMemorandumImg.setImageResource(R.drawable.haha);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private  void  initView(){
        mViewPager = (ViewPager)findViewById(R.id.id_ViewPager);

        mTabGoout = (LinearLayout)findViewById(R.id.id_goout);
        mTabHomepage = (LinearLayout)findViewById(R.id.id_homepage);
        mTabMemorandum = (LinearLayout)findViewById(R.id.id_memorandum);

        mGooutImg = (ImageButton)findViewById(R.id.id_goout_img);
        mHomepageImg = (ImageButton)findViewById(R.id.id_homepage_img);
        mMemorandumImg = (ImageButton)findViewById(R.id.id_memorandum_img);

        LayoutInflater mInflater =LayoutInflater.from(this);
        View goout =mInflater.inflate(R.layout.goout,null);
        View hompage =mInflater.inflate(R.layout.homepage,null);
        View memorandum =mInflater.inflate(R.layout.memorandum,null);
        mViews.add(goout);
        mViews.add(hompage);
        mViews.add(memorandum);

        mAdapter = new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public int getCount() {
                return mViews.size();
            }
        };
        mViewPager.setAdapter(mAdapter);
    }

    public void onClick(View v){
       // resetImg();
        switch (v.getId()){
            case R.id.id_goout:
                mViewPager.setCurrentItem(0);
               //mGooutImg.setImageResource(R.drawable."tupian");
                break;
            case R.id.id_homepage:
                mViewPager.setCurrentItem(1);
                //mHomepageImg.setImageResource(R.drawable."tupian");
                break;
            case R.id.id_memorandum:
                mViewPager.setCurrentItem(2);
                //mMemorandumImg.setImageResource(R.drawable."tupian");
                break;
            default:
                break;
        }
    }
    /**
     * 点击变暗
     * */
    /*
    private void resetImg()
    {
        mGooutImg.setImageResource(R.drawable."暗色图片");
        mHomepageImg.setImageResource(R.drawable.tab_find_frd_normal);
        mMemorandumImg.setImageResource(R.drawable.tab_address_normal);
    }
    */
}
