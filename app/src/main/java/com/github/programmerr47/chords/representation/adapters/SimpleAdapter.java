package com.github.programmerr47.chords.representation.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.github.programmerr47.chords.representation.adapters.elements.AdapterElement;
import com.github.programmerr47.chords.representation.utils.Util;

import java.util.Collections;
import java.util.List;

/**
 * Simple realisation of {@link BindBaseAdapter} that provides all common operations with items
 * like: updating and realisation of common abstract methods.
 * <br><br>
 * <strong>Note</strong> that items, that will be used by this adapter, must implement
 * {@link com.github.programmerr47.chords.representation.adapters.elements.AdapterElement} interface.
 *
 * @author Michael Spitsin
 * @since 2014-10-08
 */
public class SimpleAdapter<Item extends AdapterElement> extends BindBaseAdapter {

    protected Context mContext;
    protected List<Item> mItems;

    private List<String> mItemTypes;

    public SimpleAdapter(Context context, List<Item> items) {
        if (context == null) {
            throw new NullPointerException("Context must be not null");
        }

        mContext = context;
        mItems = items;

        mItemTypes = Util.getAllDifferentClassesFromCollection(mItems);
    }

    @Override
    protected View newView(ViewGroup parent, int position) {
        Item item = mItems.get(position);
        return item.newView(parent, position);
    }

    @Override
    protected void bindView(View view, int position) {
        Item item = mItems.get(position);
        item.bindView(view, position);
    }

    @Override
    public int getCount() {
        if (mItems == null) {
            return 0;
        } else {
            return mItems.size();
        }
    }

    @Override
    public Object getItem(int i) {
        if (mItems == null) {
            return null;
        } else {
            return mItems.get(i);
        }
    }

    @Override
    public long getItemId(int i) {
        if (mItems == null) {
            return -1;
        } else {
            return i;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if ((mItemTypes == null) || (mItems == null)) {
            return 0;
        } else {
            Item item = mItems.get(position);
            String itemClassName = item.getClass().getName();

            return mItemTypes.indexOf(itemClassName);
        }
    }

    @Override
    public int getViewTypeCount() {
        if (mItemTypes == null) {
            return 0;
        } else {
            return mItemTypes.size();
        }
    }

    public void updateItems(List<Item> newItems) {
        mItems = newItems;
        mItemTypes = Util.getAllDifferentClassesFromCollection(mItems);

        notifyDataSetChanged();
    }

    public List<Item> getItems() {
        return mItems;
    }
}