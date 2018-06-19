package com.cd.taobao.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.cd.taobao.R;
import com.cd.taobao.model.Book;
import com.cd.taobao.utils.DataAdapter;
import com.cd.taobao.utils.HttpRequest;
import com.cd.taobao.utils.SpacesItemDecoration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class WeiTaoFollowAllFragment extends Fragment {



    private static final String URL_BOOK = "http://www.xiaohongshu.com/api/sns/v2/note/5787b2f5d1d3b95bcc277086/related?page=1&tag_oid=&platform=Android&deviceId=604fae2e-8a44-3b43-8297-ec5b00f7bf66&versionName=4.10.100&channel=Xiaomi&sid=session.1160904632837462555&lang=zh-CN&t=1477039748&sign=9f71b5df21235ed4def87098cff60d9c";
    private RecyclerView mRecyclerView;
    private ArrayList<Book> books=new ArrayList<>();
    private View inflate;

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                mRecyclerView.setAdapter(new DataAdapter(getActivity(), books));
            }
            super.handleMessage(msg);
        }

    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (inflate == null)
        {
            inflate = LayoutInflater.from(getActivity()).inflate(R.layout.weitao_followall_fragment, null);
            initData();
            mRecyclerView = inflate.findViewById(R.id.recyclerview);
            mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            mRecyclerView.setPadding(8,8,8,8);
            mRecyclerView.addItemDecoration(new SpacesItemDecoration(8));

        }

        ViewGroup parent = (ViewGroup) inflate.getParent();
        if (parent != null)
        {
            parent.removeView(inflate);
        }
        return inflate;
    }


    private void initData() {

        // 接收网络访问完成的结果
        Response.Listener<String> listener = new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object =new JSONObject(response);
                    JSONArray data =object.getJSONArray("data");
                    for (int i = 0; i <data.length() ; i++) {
                        JSONObject bookObj =data.getJSONObject(i);
                        String content =bookObj.getString("desc");
                        JSONArray imgArray=bookObj.getJSONArray("images_list");
                        JSONObject imgObj =imgArray.getJSONObject(0);
                        String imgurl=imgObj.getString("url");
                        int width =imgObj.getInt("width");
                        int height=imgObj.getInt("height");
                        Book book =new Book(content,imgurl,width,height);
                        books.add(book);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                handler.sendEmptyMessage(0);

            }
        };
        // 接收网络异常的时候调用的方法
        Response.ErrorListener errorListener = new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "网络连接异常",
                        Toast.LENGTH_SHORT).show();
            }
        };
        StringRequest request = new StringRequest(Request.Method.GET, URL_BOOK, listener,
                errorListener);

        // 将这个request请求添加到请求队列中
        HttpRequest.getInstance(getActivity()).sendRequest(request);

    }

}
