package com.cd.taobao.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.cd.taobao.R;
import com.cd.taobao.model.News;
import com.cd.taobao.utils.NewsAdpter;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends Fragment {
    boolean isLoading;
    private List<News> data = new ArrayList<>();
    private NewsAdpter adapter;
    private Handler handler = new Handler();

    RecyclerView recyclerView;
//刷新
    //SwipeRefreshLayout swipeRefreshLayout;
    private View inflate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (inflate == null) {
            inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_news, null);
        }
        adapter = new NewsAdpter(getActivity(), data);
        initView();
        initData();
        return inflate;
    }



    public void initView() {

    /*    swipeRefreshLayout=inflate.findViewById(R.id.refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        data.clear();
                        getData();
                    }
                }, 2000);
            }
        });*/
        recyclerView=  inflate.findViewById(R.id.news_list);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d("test", "StateChanged = " + newState);


            }

         /*   @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.d("test", "onScrolled");

                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPosition + 1 == adapter.getItemCount()) {
                    Log.d("test", "loading executed");

                   // boolean isRefreshing = swipeRefreshLayout.isRefreshing();
                   *//* if (isRefreshing) {
                        adapter.notifyItemRemoved(adapter.getItemCount());
                        return;
                    }*//*
               *//*     if (!isLoading) {
                        isLoading = true;
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                getData();
                                Log.d("test", "load more completed");
                                isLoading = false;
                            }
                        }, 1000);
                    }*//*
                }
            }*/
        });

        //添加点击事件
        adapter.setOnItemClickListener(new NewsAdpter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("test", "item position = " + position);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }


    public void initData() {
       /* handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getData();
            }
        }, 1500);*/
        getData();
    }



    /**
     * 获取测试数据
     */
    News news;
    private void getData() {
        for (int i = 0; i < 1; i++) {
            news = new News(R.drawable.news_tbtt,"淘宝头条","马云征婚:婚姻算法就是“算了吧”","星期五");
            data.add(news);
            news = new News(R.drawable.news_lotiyo,"lotiyo旗舰店","[验收提醒]","星期五");
            data.add(news);
            news = new News(R.drawable.news_snyg,"苏宁易购官方旗舰店","您收到一个客服邀评","星期五");
            data.add(news);
            news = new News(R.drawable.news_tb,"X特步","年轻就要一起耍酷，带你浪","星期四");
            data.add(news);
            news = new News(R.drawable.news_mn99,"mn99旗舰店","[请您核对验收信息]","星期一");
            data.add(news);
            news = new News(R.drawable.news_jgtx,"金冠通讯店","同武汉可以到店维修吗","18/05/03");
            data.add(news);
            news = new News(R.drawable.news_stsd,"飞腾时代数码专营店","亲，已经看到您支付成功了，我们会...","18/04/03");
            data.add(news);
            news = new News(R.drawable.news_kq,"cooskin酷奇云饮专卖店","亲，请核对一下收货地址哦","18/04/02");
            data.add(news);
            news = new News(R.drawable.news_rc,"日超家具旗舰店","[亲，请您核对订单信息]","18/03/18");
            data.add(news);
            news = new News(R.drawable.news_gnht,"公牛辉腾","你好，亲","18/03/16");
            data.add(news);
            news = new News(R.drawable.news_gjdg,"互特家用电器","对的","18/03/12");
            data.add(news);
        }
        //adapter.notifyDataSetChanged();
       // swipeRefreshLayout.setRefreshing(false);
        //adapter.notifyItemRemoved(adapter.getItemCount());
    }


}
