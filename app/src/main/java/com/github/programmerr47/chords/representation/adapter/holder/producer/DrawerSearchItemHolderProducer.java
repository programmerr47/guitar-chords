package com.github.programmerr47.chords.representation.adapter.holder.producer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.programmerr47.chords.R;
import com.github.programmerr47.chords.representation.adapter.holder.drawer.SearchItemHolder;

/**
 * Class that produces view holder for
 * {@link com.github.programmerr47.chords.representation.adapter.item.drawer.DrawerSearchItem}
 *
 * @author Michael Spitsin
 * @since 2015-04-06
 */
public class DrawerSearchItemHolderProducer implements HolderProducer {

    private final Context mContext;

    public DrawerSearchItemHolderProducer(@NonNull Context context) {
        mContext = context;
    }


    @Override
    public RecyclerView.ViewHolder produce(ViewGroup parentView) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.drawer_item_search, parentView, false);

        if (view == null) {
            throw new IllegalStateException("View not created");
        }

        SearchItemHolder.ResourceParams params = new SearchItemHolder.ResourceParams();
        params.iconLayoutId = R.id.icon;
        params.searchFieldLayoutId = R.id.searchField;
        return new SearchItemHolder(view, params);
    }
}
