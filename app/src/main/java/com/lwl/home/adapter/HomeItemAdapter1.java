package com.lwl.home.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lwl.home.bean.NewsBean;
import com.lwl.neteasenews.R;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by uk on 2017/4/8.
 */

public class HomeItemAdapter1 implements ItemViewDelegate<NewsBean>{
    private Context context;
    public HomeItemAdapter1(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.fg_home_item1;
    }

    @Override
    public boolean isForViewType(NewsBean item, int position) {
        return true;
    }

    @Override
    public void convert(ViewHolder holder, NewsBean bean, int position) {
        holder.setText(R.id.fg_home_item1_title, bean.getTitle());
        holder.setText(R.id.fg_home_item1_type, bean.getSource());
        holder.setText(R.id.fg_home_item1_replyCount, bean.getReplyCount());
        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.fg_home_item1_iv);

        setImage(imageView, bean.getImgsrc());
    }
    private void setImage(ImageView view, String url) {
        Glide
                .with(context)
                .load(url)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }
}
