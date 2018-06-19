package com.cd.taobao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cd.taobao.R;
import com.cd.taobao.utils.WeiTaoFollowFragmentPagerAdapter;


public class WeiTaoFollowFragment extends Fragment {

    private TabLayout mTabLayout ;
    private ViewPager mViewPager;

    private WeiTaoFollowFragmentPagerAdapter myFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;

    private View inflate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (inflate == null)
        {
            inflate = LayoutInflater.from(getActivity()).inflate(R.layout.weitai_follow_fragment, null);
            //使用适配器将ViewPager与Fragment绑定在一起
            mViewPager=  inflate.findViewById(R.id.followViewPager);
            myFragmentPagerAdapter = new WeiTaoFollowFragmentPagerAdapter(getActivity().getSupportFragmentManager());
            mViewPager.setAdapter(myFragmentPagerAdapter);

            //将TabLayout与ViewPager绑定在一起
            mTabLayout =  inflate.findViewById(R.id.followtabLayout);
            mTabLayout.setupWithViewPager(mViewPager);
            //设置居中
           /* mTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
            mTabLayout.setTabMode(TabLayout.MODE_FIXED);*/
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
