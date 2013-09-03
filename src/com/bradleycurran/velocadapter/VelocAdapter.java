package com.bradleycurran.velocadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class VelocAdapter extends BaseAdapter implements ViewBinder {

    private Context mContext;

    public VelocAdapter(Context context) {
        mContext = context;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (convertView == null) {
            view = newView(LayoutInflater.from(mContext), position, parent);
            view.setTag(new ViewHolder(view));
        }

        ViewHolder holder = (ViewHolder)view.getTag();
        bindView(mContext, view, holder, position);

        return view;
    }
}
