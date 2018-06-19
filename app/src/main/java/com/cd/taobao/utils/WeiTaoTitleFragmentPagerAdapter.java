package com.cd.taobao.utils;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cd.taobao.fragment.WeiTaoFindFragment;
import com.cd.taobao.fragment.WeiTaoFollowFragment;

/**
 * Created by Administrator on 2017/10/24.
 */

public class WeiTaoTitleFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"关注",  "发现"};

    public WeiTaoTitleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new WeiTaoFindFragment();
        }
        return new WeiTaoFollowFragment();
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
