package com.bradleycurran.velocadapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class SimpleVelocAdapter<T> extends ArrayVelocAdapter<T> {

    private int mLayoutId;

    public SimpleVelocAdapter(Context context, int layoutId) {
        super(context);
        mLayoutId = layoutId;
    }

    public SimpleVelocAdapter(Context context, int layoutId, List<T> list) {
        super(context, list);
        mLayoutId = layoutId;
    }

    @Override
    public View newView(LayoutInflater inflator, int position, ViewGroup parent) {
        return inflator.inflate(mLayoutId, parent, false);
    }
}
