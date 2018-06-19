package com.cd.taobao.utils;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cd.taobao.fragment.WeiTaoFindFragment;
import com.cd.taobao.fragment.WeiTaoFollowAllFragment;
import com.cd.taobao.fragment.WeiTaoFollowFragment;

/**
 * Created by Administrator on 2017/10/24.
 */

public class WeiTaoFollowFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"全部","上新","直播","关注","达人"};

    public WeiTaoFollowFragmentPagerAdapter(FragmentManager fm) {
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
