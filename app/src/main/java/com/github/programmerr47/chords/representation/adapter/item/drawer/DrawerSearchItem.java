package com.github.programmerr47.chords.representation.adapter.item.drawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;

import com.github.programmerr47.chords.representation.adapter.holder.drawer.SearchItemHolder;
import com.github.programmerr47.chords.representation.adapter.holder.producer.DrawerSearchItemHolderProducer;
import com.github.programmerr47.chords.representation.adapter.holder.producer.HolderProducer;

/**
 * Search element of drawer, that represents simple {@link EditText}. Can search artist, songs.
 * After typing and pressing button redirects to SearchResultPage.
 *
 * @author Michael Spitsin
 * @since 2014-10-13
 */
public final class DrawerSearchItem extends DrawerItem {

    private DrawerSearchItem(Builder builder) {
        super(builder);
    }

    @Override
    public void bindView(RecyclerView.ViewHolder viewHolder, int position) {
        SearchItemHolder holder = (SearchItemHolder) viewHolder;
        bindView(holder, isSelected);
    }

    @Override
    public HolderProducer getViewHolderProducer() {
        return new DrawerSearchItemHolderProducer(mContext);
    }

    private void bindView(SearchItemHolder viewHolder, boolean isSelected) {
        ImageView icon = viewHolder.getIcon();
        EditText searchField = viewHolder.getSearchField();

        icon.setSelected(isSelected);
        searchField.setSelected(isSelected);
    }

    /**
     * @author Michael Spitsin
     * @since 2014-10-13
     */
    public static final class Builder extends DrawerItem.Builder {

        public Builder(@NonNull Context context) {
            super(context);
        }

        @Override
        public DrawerSearchItem build() {
            return new DrawerSearchItem(this);
        }
    }
}
