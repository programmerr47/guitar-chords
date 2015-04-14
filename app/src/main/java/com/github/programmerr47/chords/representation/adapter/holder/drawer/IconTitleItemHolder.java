package com.github.programmerr47.chords.representation.adapter.holder.drawer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Standard view holder for most of items of {@link android.support.v7.widget.RecyclerView}.
 * Contains only two view, that can provide and handle: one of them represents icon, second
 * main text.
 *
 * @author Michael Spitsin
 * @since 2015-04-07
 */
public final class IconTitleItemHolder extends RecyclerView.ViewHolder {

    private ImageView mIcon;
    private TextView mTitle;

    public IconTitleItemHolder(View itemView, ResourceParams params) {
        super(itemView);

        mIcon = (ImageView) itemView.findViewById(params.iconLayoutId);
        mTitle = (TextView) itemView.findViewById(params.titleLayoutId);
    }

    public ImageView getIcon() {
        return mIcon;
    }

    public TextView getTitle() {
        return mTitle;
    }

    public static final class ResourceParams {
        public int iconLayoutId;
        public int titleLayoutId;
    }
}
