package com.github.programmerr47.chords.representation.adapter.item.drawer;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.programmerr47.chords.representation.Constants;
import com.github.programmerr47.chords.representation.adapter.holder.drawer.DrawerStandardItemHolder;
import com.github.programmerr47.chords.representation.adapter.holder.producer.DrawerSecondaryItemHolderProducer;
import com.github.programmerr47.chords.representation.adapter.holder.producer.HolderProducer;

/**
 * Represents drawer elements that show secondary pages (About).
 *
 * @author Michael Spitsin
 * @since 2014-10-12
 */
public final class DrawerSecondaryItem extends DrawerItem {

    private Typeface selectedStateTypeface;
    private Typeface defaultStateTypeface;

    private int iconResId;
    private int titleResId;

    private DrawerSecondaryItem(Builder builder) {
        super(builder);

        this.iconResId = builder.iconResId;
        this.titleResId = builder.titleResId;

        selectedStateTypeface = Typeface.createFromAsset(mContext.getAssets(), Constants.ASSETS_FONTS_DIR + Constants.ROBOTO_BOLD);
        defaultStateTypeface = Typeface.createFromAsset(mContext.getAssets(), Constants.ASSETS_FONTS_DIR + Constants.ROBOTO_REGULAR);
    }

    @Override
    public void bindView(RecyclerView.ViewHolder viewHolder, int position) {
        DrawerStandardItemHolder holder = (DrawerStandardItemHolder) viewHolder;
        bindView(holder, isSelected);
    }

    @Override
    public HolderProducer getViewHolderProducer() {
        return new DrawerSecondaryItemHolderProducer(mContext);
    }

    private void bindView(DrawerStandardItemHolder holder, boolean isSelected) {
        ImageView icon = holder.getIcon();
        TextView title = holder.getTitle();

        icon.setImageResource(iconResId);
        title.setText(titleResId);

        icon.setSelected(isSelected);

        if (isSelected) {
            title.setTypeface(selectedStateTypeface);
        } else {
            title.setTypeface(defaultStateTypeface);
        }
    }

    /**
     * @author Michael Spitsin
     * @since 2014-10-12
     */
    public static final class Builder extends DrawerItem.Builder {
        private int iconResId;
        private int titleResId;

        public Builder(@NonNull Context context) {
            super(context);
        }

        public Builder setIcon(int iconResId) {
            this.iconResId = iconResId;
            return this;
        }

        public Builder setTitle(int titleResId) {
            this.titleResId = titleResId;
            return this;
        }

        @Override
        public DrawerSecondaryItem build() {
            return new DrawerSecondaryItem(this);
        }
    }
}
