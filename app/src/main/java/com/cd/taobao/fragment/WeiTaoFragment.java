package com.cd.taobao.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cd.taobao.R;
import com.cd.taobao.utils.WeiTaoTitleFragmentPagerAdapter;


public class WeiTaoFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private WeiTaoTitleFragmentPagerAdapter myFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;

    private View inflate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (inflate == null)
        {
            inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_wei_tao, null);
            //使用适配器将ViewPager与Fragment绑定在一起
            mViewPager=  inflate.findViewById(R.id.viewPager);
            myFragmentPagerAdapter = new WeiTaoTitleFragmentPagerAdapter(getActivity().getSupportFragmentManager());
            mViewPager.setAdapter(myFragmentPagerAdapter);

            //将TabLayout与ViewPager绑定在一起
            mTabLayout =  inflate.findViewById(R.id.tabLayout);
            mTabLayout.setupWithViewPager(mViewPager);
            //设置居中
            mTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
            mTabLayout.setTabMode(TabLayout.MODE_FIXED);
            //指定Tab的位置
            one = mTabLayout.getTabAt(0);
            two = mTabLayout.getTabAt(1);
        }

        ViewGroup parent = (ViewGroup) inflate.getParent();
        if (parent != null)
        {
            parent.removeView(inflate);
        }
        return inflate;
    }

}
