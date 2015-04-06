package com.github.programmerr47.chords.representation.adapter.holder.drawer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MS on 06.04.2015.
 */
//TODO describe
public final class DrawerPrimaryItemHolder extends RecyclerView.ViewHolder {

    private ImageView mIcon;
    private TextView mTitle;

    public DrawerPrimaryItemHolder(View itemView, ResourceParams params) {
        super(itemView);

        mIcon = (ImageView) itemView.findViewById(params.iconResId);
        mTitle = (TextView) itemView.findViewById(params.titleResId);
    }

    public ImageView getIcon() {
        return mIcon;
    }

    public TextView getTitle() {
        return mTitle;
    }

    public static final class ResourceParams {
        public int iconResId;
        public int titleResId;
    }
}
