package com.nurif.qluetest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nurif.qluetest.R;
import com.nurif.qluetest.model.QlueModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by if_alan on 03/05/18.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<QlueModel> mItems = new ArrayList<>();
    private Context mContext;

    public ListAdapter(Context context) {
        mContext = context;
    }

    public void setItems(List<QlueModel> posts) {
        mItems = posts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivPhoto;
        public TextView tvUsername, tvDesc, tvKel;

        public ViewHolder(View itemView) {
            super(itemView);
            ivPhoto = (ImageView) itemView.findViewById(R.id.iv_image);
            tvUsername = (TextView) itemView.findViewById(R.id.tv_username);
            tvDesc = (TextView) itemView.findViewById(R.id.tv_desc);
            tvKel = (TextView) itemView.findViewById(R.id.tv_kel);
        }
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list
                        , parent, false);

        return new ListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, int position) {
        QlueModel item = mItems.get(position);

        Glide.with(mContext)
                .load(item.getImageUrl())
                .into(holder.ivPhoto);

        holder.tvUsername.setText(item.getUsername());
        holder.tvDesc.setText(item.getDescription());
        holder.tvKel.setText(item.getKelurahan());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
