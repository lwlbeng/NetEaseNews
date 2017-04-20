package com.lwl.live;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.lwl.neteasenews.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by uk on 2017/4/7.
 */

public class LiveFragment extends Fragment{


    private RecyclerView mRecyclerView;

    private Down mdown = new Down();

    private List<LiveBean> LiveFragBean = new ArrayList<>();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setReenterTransition(true);
        new DownTask().execute();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fg_live, container, false);

        mRecyclerView = ((RecyclerView) view.findViewById(R.id.fg_live_RecyclerView));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        setupAdapter();
        return view;
    }

    private void setupAdapter() {

            mRecyclerView.setAdapter(new MyAdapter(LiveFragBean));

    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImage;
        private TextView mTname;
        private TextView mRoomName;
        private ImageView mLiveStatus;
        private TextView mUserCount;


        public ViewHolder(View itemView) {
            super(itemView);

            mImage = (ImageView) itemView.findViewById(R.id.fg_live_re_item_image);
            mTname = (TextView) itemView.findViewById(R.id.fg_live_re_item_tname);
            mRoomName = (TextView) itemView.findViewById(R.id.fg_live_re_item_roomName);
            mLiveStatus = (ImageView) itemView.findViewById(R.id.fg_live_re_item_liveStatus);
            mUserCount = (TextView) itemView.findViewById(R.id.fg_live_re_item_userCount);
        }

        public void bindView(final LiveBean bean) {

            mImage.setImageBitmap(bean.getBitmap());
            if (!(bean.getTname()==null)){
                mTname.setText(bean.getTname());
            }else {
                mTname.setVisibility(View.INVISIBLE);
            }

            mRoomName.setText(bean.getRoomName());
            switch (bean.getLiveStatus()) {
                case 1:
                    mLiveStatus.setImageResource(R.drawable.a6h);
                    break;
                case 2:
                    mLiveStatus.setImageResource(R.drawable.a6k);
                    break;
                default:
                    mLiveStatus.setImageResource(R.drawable.a6f);
                    break;
            }

            mUserCount.setText(bean.getUserCount() + "参与");

        }
    }

    private class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

        private List<LiveBean> mAdaLiveBeans;

        public MyAdapter(List<LiveBean> mLiveBeans){
            this.mAdaLiveBeans = mLiveBeans;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.fg_live_re_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            LiveBean bean = mAdaLiveBeans.get(position);
            holder.bindView(bean);
        }

        @Override
        public int getItemCount() {
            return mAdaLiveBeans.size();
        }
    }

    private class DownTask extends AsyncTask<Void, Void, List<LiveBean>> {
        @Override
        protected List<LiveBean> doInBackground(Void... params) {
            return mdown.getListLiveBean();
        }

        @Override
        protected void onPostExecute(List<LiveBean> liveBeen) {
            LiveFragBean = liveBeen;
            setupAdapter();
        }
    }


}