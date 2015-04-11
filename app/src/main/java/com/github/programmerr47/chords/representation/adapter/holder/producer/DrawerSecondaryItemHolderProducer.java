package com.github.programmerr47.chords.representation.adapter.holder.producer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.programmerr47.chords.R;
import com.github.programmerr47.chords.representation.adapter.holder.drawer.DrawerStandardItemHolder;

/**
 * Created by MS on 07.04.2015.
 */
//TODO describe
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

        DrawerStandardItemHolder.ResourceParams params = new DrawerStandardItemHolder.ResourceParams();
        params.iconLayoutId = R.id.icon;
        params.titleLayoutId = R.id.title;
        return new DrawerStandardItemHolder(view, params);
    }
}
