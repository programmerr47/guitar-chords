package com.github.programmerr47.chords.representation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.github.programmerr47.chords.representation.adapters.element.AdapterItem;
import com.github.programmerr47.chords.representation.adapters.element.RecyclerElement;

/**
 * Created by MS on 01.04.2015.
 */
public class RecyclerAdapter<Item extends AdapterItem> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}