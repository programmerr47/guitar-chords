package com.github.programmerr47.chords.representation.adapter.holder.producer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.programmerr47.chords.R;
import com.github.programmerr47.chords.representation.adapter.holder.drawer.IconTitleItemHolder;

/**
 * Class that produces view holder for
 * {@link com.github.programmerr47.chords.representation.adapter.item.drawer.DrawerSecondaryItem}
 *
 * @author Michael Spitsin
 * @since 2015-04-06
 */
public class DrawerSecondaryItemHolderProducer implements HolderProducer {

    private final Context mContext;

    public DrawerSecondaryItemHolderProducer(@NonNull Context context) {
        mContext = context;
    }


    @Override
    public RecyclerView.ViewHolder produce(ViewGroup parentView) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.drawer_item_secondary, parentView, false);

        if (view == null) {
            throw new IllegalStateException("View not created");
        }

        IconTitleItemHolder.ResourceParams params = new IconTitleItemHolder.ResourceParams();
        params.iconLayoutId = R.id.icon;
        params.titleLayoutId = R.id.title;
        return new IconTitleItemHolder(view, params);
    }
}
