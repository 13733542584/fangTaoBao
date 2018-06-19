package com.cd.taobao.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cd.taobao.R;
import com.cd.taobao.model.Book;

import java.util.ArrayList;

/**
 * Created by KID on 2016/12/5.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder>{

    Context context;
    ArrayList<Book> mDatas;
    public DataAdapter(Context context, ArrayList<Book> mDatas){
        this.context=context;
        this.mDatas=mDatas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_recyclerview, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        final Book book =mDatas.get(position);
        holder.textView.setText(book.content);

        //获取item宽度，计算图片等比例缩放后的高度，为imageView设置参数
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.imageView.getLayoutParams();
        float itemWidth = (ScreenUtils.getScreenWidth(holder.itemView.getContext()) - 8*3) / 2;
        layoutParams.width = (int) itemWidth;
        float scale = (itemWidth+0f)/book.width;
        layoutParams.height= (int) (book.height*scale);
        holder.imageView.setLayoutParams(layoutParams);


        Glide.with(context).
                load(book.imgRes).
                override(layoutParams.width, layoutParams.height).
                into(holder.imageView);

    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        View card;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            card = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.img_recyclerview);
            textView = (TextView) itemView.findViewById(R.id.tv_recyclerview);
        }
    }
}



