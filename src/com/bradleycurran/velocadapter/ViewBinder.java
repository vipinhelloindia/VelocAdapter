package com.bradleycurran.velocadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface ViewBinder {

    public View newView(LayoutInflater inflator, int position, ViewGroup parent);

    public void bindView(Context context, View view, ViewHolder holder, int position);

}
