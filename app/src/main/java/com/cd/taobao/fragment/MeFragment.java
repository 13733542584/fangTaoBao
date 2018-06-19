package com.cd.taobao.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.cd.taobao.R;

import java.util.ArrayList;
import java.util.List;


public class MeFragment extends Fragment {

    private View inflate;
    private List testList;
    private int count;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (inflate == null)
        {
            inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_me, null);



            //淘宝头条
            ViewFlipper flipper = inflate.findViewById(R.id.vf);
            //初始化list数据
            testList = new ArrayList();
            testList.add(0, "阿里系免流神器0元抢");
            testList.add(1, "阿里系免流神器0元抢");
            testList.add(2, "阿里系免流神器0元抢");
            testList.add(3, "阿里系免流神器0元抢");
            testList.add(4, "阿里系免流神器0元抢");
            count = testList.size();
            for (int i = 0; i < count; i++) {
                final View ll_content = View.inflate(getActivity(), R.layout.me_view_itemflipper, null);
                TextView tv_content =  ll_content.findViewById(R.id.tv_content);
                tv_content.setText(testList.get(i).toString());
                flipper.addView(ll_content);
            }

        }


        ViewGroup parent = (ViewGroup) inflate.getParent();
        if (parent != null)
        {
            parent.removeView(inflate);
        }
        return inflate;
    }


}
