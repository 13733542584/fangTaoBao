package com.cd.taobao.utils;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cd.taobao.fragment.WeiTaoFollowAllFragment;

/**
 * Created by Administrator on 2017/10/24.
 */

public class WeiTaoFindFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"精选","视频","数码","运动","美搭","美食","美妆"};

    public WeiTaoFindFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new WeiTaoFollowAllFragment();
        }
        return new WeiTaoFollowAllFragment();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }


}
