package com.bradleycurran.velocadapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewBinderAdapter extends ArrayVelocAdapter<ViewBinder> {

    public ViewBinderAdapter(Context context, List<ViewBinder> list) {
        super(context, list);
    }

    public ViewBinderAdapter(Context context) {
        super(context);
    }

    @Override
    public View newView(LayoutInflater inflator, int position, ViewGroup parent) {
        ViewBinder viewBinder = getItem(position);
        return viewBinder.newView(inflator, position, parent);
    }

    @Override
    public void bindView(Context context, View view, ViewHolder holder, int position) {
        ViewBinder viewBinder = getItem(position);
        viewBinder.bindView(context, view, holder, position);
    }
}
