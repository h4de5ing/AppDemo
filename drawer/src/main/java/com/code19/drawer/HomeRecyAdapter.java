package com.code19.drawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by Administrator on 2016/7/0008.
 */

public class HomeRecyAdapter extends RecyclerView.Adapter<HomeRecyAdapter.HomeRecViewHolder> {
    private LayoutInflater mLayoutInflater;
    private List<HomeBean> mDates;
    private Context mContext;

    public HomeRecyAdapter(Context context, List<HomeBean> list) {
        mContext = context;
        mDates = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public HomeRecViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new HomeRecViewHolder(mLayoutInflater.inflate(R.layout.home_recy_adapter, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(HomeRecViewHolder homeRecViewHolder, int i) {
        homeRecViewHolder.mImageView.setImageResource(mDates.get(i).getIcon());
        homeRecViewHolder.mTextView.setText(mDates.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return mDates.size();
    }

    class HomeRecViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;

        public HomeRecViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.home_recy_icon);
            mTextView = (TextView) itemView.findViewById(R.id.home_recy_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "点击了" + mDates.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
