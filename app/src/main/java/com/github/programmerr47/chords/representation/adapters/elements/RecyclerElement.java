package com.github.programmerr47.chords.representation.adapters.elements;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Represents abstract item of abstract adapter. This is can be just opening item, item with some
 * buttons, search item, anything.
 * <strong>Note:</strong> It's a new alternative to previous interface AdapterElement,
 * because now we have a {@link android.support.v7.widget.RecyclerView} and
 * {@link android.support.v7.widget.RecyclerView.Adapter}. And we have to handle
 * their elements in a different way. Specifically we need to extend each item from
 * {@link android.support.v7.widget.RecyclerView.ViewHolder} to provide new
 * implemented "view holder" pattern in {@link android.support.v7.widget.RecyclerView.Adapter}.
 *
 * @author Michael Spitsin
 * @since 2015-04-02
 */
public abstract class RecyclerElement extends RecyclerView.ViewHolder {

    public RecyclerElement(View itemView) {
        super(itemView);
    }

    /**
     * Calls when another taken in {@link com.github.programmerr47.chords.representation.adapters.BindBaseAdapter#getView(int, android.view.View, android.view.ViewGroup)}
     * element is not exists and it is needed to create it from layout.
     *
     * @param parent parent view group
     * @param position position of element that will be represented by this view
     * @return created View
     */
    public abstract View newView(ViewGroup parent, int position);

    /**
     * Calls when another taken in {@link com.github.programmerr47.chords.representation.adapters.BindBaseAdapter#getView(int, android.view.View, android.view.ViewGroup)}
     * element is exists and it is needed to bind it (set up it).
     *
     * @param view given created of existing view
     * @param position position of this view
     */
    public abstract void bindView(View view, int position);
}
