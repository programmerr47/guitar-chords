package com.github.programmerr47.chords.representation.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Abstract implementation of {@link android.widget.BaseAdapter}, that separates
 * getView into creating new view {@link BindBaseAdapter#newView(android.view.ViewGroup, int)}
 * and binding existing view {@link BindBaseAdapter#bindView(android.view.View, int)}.
 *
 * @author Michael Spitsin
 * @since 2014-07-09
 */
public abstract class BindBaseAdapter extends BaseAdapter {

    @Override
    public final View getView(int position, View convertView, ViewGroup parent) {

        View v;
        if (convertView == null) {
            v = newView(parent, position);
        } else {
            v = convertView;
        }

        bindView(v, position);
        return v;
    }

    /**
     * Calls when another taken in {@link BindBaseAdapter#getView(int, android.view.View, android.view.ViewGroup)}
     * element is not exists and it is needed to create it from layout.
     *
     * @param parent parent view group
     * @param position position of element that will be represented by this view
     * @return created View
     */
    protected abstract View newView(ViewGroup parent, int position);

    /**
     * Calls when another taken in {@link BindBaseAdapter#getView(int, android.view.View, android.view.ViewGroup)}
     * element is exists and it is needed to bind it (set up it).
     *
     * @param view given created of existing view
     * @param position position of this view
     */
    protected abstract void bindView(View view, int position);
}
