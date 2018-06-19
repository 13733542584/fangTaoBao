package com.cd.taobao.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cd.taobao.R;
import com.cd.taobao.model.News;

import java.util.List;

/**
 * Created by 13733 on 2018/5/13.
 */

public class NewsAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<News> data;


    public NewsAdpter(Context context, List<News> data) {
        this.context = context;
        this.data = data;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent,
                    false);
            return new ItemViewHolder(view);

    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ItemViewHolder) {
            if (onItemClickListener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = holder.getLayoutPosition();
                        onItemClickListener.onItemClick(holder.itemView, position);
                    }
                });

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int position = holder.getLayoutPosition();
                        onItemClickListener.onItemLongClick(holder.itemView, position);
                        return false;
                    }
                });
            }

            //加载数据
            ((ItemViewHolder) holder).title.setText(data.get(position).getTitle());
            ((ItemViewHolder) holder).content.setText(data.get(position).getContent());
            ((ItemViewHolder) holder).date.setText(data.get(position).getDate());
            ((ItemViewHolder) holder).image.setImageResource(data.get(position).getImage());

        }
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView title,content,date;
        ImageView image;

        public ItemViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            content = (TextView) view.findViewById(R.id.content);
            date = (TextView) view.findViewById(R.id.date);
            image = (ImageView) view.findViewById(R.id.image);
        }
    }


}
