package com.bradleycurran.velocadapter;

import android.util.SparseArray;
import android.view.View;

class ViewHolder {

    private View              mView;

    private SparseArray<View> mCache;

    ViewHolder(View view) {
        mView = view;
        mCache = new SparseArray<View>();
    }

    @SuppressWarnings("unchecked")
    <T extends View> T get(int id) {
        View view = mCache.get(id);

        if (view == null) {
            view = mView.findViewById(id);
            mCache.append(id, view);
        }

        return (T)view;
    }
}
