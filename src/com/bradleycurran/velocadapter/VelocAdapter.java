package com.bradleycurran.velocadapter;

import java.util.List;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public abstract class VelocAdapter<T> extends ArrayAdapter<T> {

    private int mLayoutId;

    public VelocAdapter(Context context) {
        super(context, 0);
        mLayoutId = 0;
    }

    public VelocAdapter(Context context, int layoutId) {
        super(context, 0);
        mLayoutId = layoutId;
    }

    public VelocAdapter(Context context, List<T> objects) {
        super(context, 0, objects);
        mLayoutId = 0;
    }

    public VelocAdapter(Context context, T[] objects) {
        super(context, 0, objects);
        mLayoutId = 0;
    }

    public VelocAdapter(Context context, int layoutId, List<T> objects) {
        super(context, 0, objects);
        mLayoutId = layoutId;
    }

    public VelocAdapter(Context context, int layoutId, T[] objects) {
        super(context, 0, objects);
        mLayoutId = layoutId;
    }

    /**
     * Implement this method to map the model to the view.
     * 
     * @param context
     *            The adapter context.
     * @param view
     *            The view that is being bound.
     * @param holder
     *            The view holder that contains all the cached child views.
     *            Use this to get child views using holder.get(int).
     * @param position
     */
    protected abstract void bindView(Context context, View view, ViewHolder holder, int position);

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (convertView == null) {
            view = newView(LayoutInflater.from(getContext()), position, parent);
            view.setTag(new ViewHolder(view));
        }

        ViewHolder holder = (ViewHolder)view.getTag();
        bindView(getContext(), view, holder, position);

        return view;
    }

    /**
     * Creates a new view based on the default layout resource ID.
     * 
     * @param inflater
     *            The layout inflater to inflate with.
     * @param position
     *            The position of the item to inflate.
     * @param parent
     * @return An inflated view.
     */
    protected View newView(LayoutInflater inflater, int position, ViewGroup parent) {
        return inflater.inflate(getLayoutId(position), parent, false);
    }

    /**
     * Override this if you want to provide multiple row layouts.
     * 
     * @param position
     *            The position for this layout.
     * @return The layout resource ID given a position.
     */
    protected int getLayoutId(int position) {
        return mLayoutId;
    }

    /**
     * Caches the child views for usage in bindView.
     */
    public static class ViewHolder {

        private View              mView;

        private SparseArray<View> mCache;

        ViewHolder(View view) {
            mView = view;
            mCache = new SparseArray<View>();
        }

        @SuppressWarnings("unchecked")
        public <T extends View> T get(int id) {
            View view = mCache.get(id);

            if (view == null) {
                view = mView.findViewById(id);
                mCache.append(id, view);
            }

            return (T)view;
        }
    }
}
