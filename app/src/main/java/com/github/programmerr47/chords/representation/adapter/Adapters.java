package com.github.programmerr47.chords.representation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.programmerr47.chords.representation.NavigationDrawerCallbacks;
import com.github.programmerr47.chords.representation.adapter.item.RecyclerItems;
import com.github.programmerr47.chords.representation.adapter.item.drawer.DrawerItem;

/**
 * Created by Spoke on 11.04.2015.
 */
//todo describe
public class Adapters {

    public static <Item extends DrawerItem> AbstractRecyclerAdapter<Item> createDrawerAdapter(@NonNull final RecyclerItems<Item> items, final NavigationDrawerCallbacks callbacks) {
        return new AbstractRecyclerAdapter<Item>(items) {
            @Override
            protected void onPostBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
                if (callbacks != null) {
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            callbacks.onNavigationDrawerItemSelected(items.get(position), position);
                        }
                    });
                }
            }
        };
    }
}
