package com.cd.taobao.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.cd.taobao.MainActivity;
import com.cd.taobao.R;
import com.liuting.sliderlayout.SliderLayout;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {
    private SliderLayout layoutTaobao;//自定义自动轮播图片View
    private List<Object> listTaobao;//图片列表
    private Dialog dialog;//提示框
    private View inflate;

    //淘宝头条数据源
    private List testList;
    private int count;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (inflate == null)
        {
            inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_main, null);

            //轮播图
            layoutTaobao = inflate.findViewById(R.id.main_layout_taobao);
            dialog = new ProgressDialog(getActivity());
            initTaoBao();

            //淘宝头条
            ViewFlipper flipper = inflate.findViewById(R.id.vf);
            //初始化list数据
            testList = new ArrayList();
            testList.add(0, "爸妈爱的“白”娃娃，真是孕期吃出来的吗？");
            testList.add(1, "如果徒步真的需要理由，十四个够不够？");
            testList.add(2, "享受清爽啤酒的同时，这些常识你真的了解吗？");
            testList.add(3, "三星Galaxy S8定型图无悬念");
            testList.add(4, "家猫为何如此高冷？");
            count = testList.size();
            for (int i = 0; i < count; i++) {
                final View ll_content = View.inflate(getActivity(), R.layout.view_itemflipper, null);
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
    //滚动图数据源
    private void initTaoBao(){
        layoutTaobao.setVisibility(View.GONE);
        layoutTaobao.stopAutoPlay();
        layoutTaobao.setVisibility(View.VISIBLE);
        layoutTaobao.setPictureIndex(0);
        listTaobao = new ArrayList<>();
        listTaobao.add(R.drawable.pic6);
        listTaobao.add(R.drawable.pic1);
        listTaobao.add(R.drawable.pic2);
        listTaobao.add(R.drawable.pic3);
        listTaobao.add(R.drawable.pic4);
        layoutTaobao.setList(listTaobao);
        layoutTaobao.setListener(new SliderLayout.IOnClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(),"第 "+(position+1)+" 张图片",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
