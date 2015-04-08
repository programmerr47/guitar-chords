package com.github.programmerr47.chords.representation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.github.programmerr47.chords.representation.adapter.holder.producer.HolderProducer;
import com.github.programmerr47.chords.representation.adapter.item.AdapterItem;
import com.github.programmerr47.chords.representation.adapter.item.RecyclerItems;

import java.util.Collection;
import java.util.Map;

/**
 * @author Michael Spitsin
 * @since 2015-04-08
 */
//TODO describe
public class RecyclerAdapter<Item extends AdapterItem> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private RecyclerItems<Item> mItems;

    public RecyclerAdapter(@NonNull RecyclerItems<Item> items) {
        mItems = items;
    }

    public RecyclerAdapter() {
        mItems = new RecyclerItems<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Map<Integer, HolderProducer> typeProducers = mItems.getTypesMap();
        HolderProducer producer = typeProducers.get(viewType);
        return producer.produce(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Item item = mItems.get(position);
        item.bindView(holder, position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.getItemType(position);
    }

    public void updateItems(@NonNull RecyclerItems<Item> newItems) {
        mItems = newItems;
        notifyDataSetChanged();
    }

    public void addItem(@NonNull Item newItem) {
        addItem(mItems.size(), newItem);
    }

    public void addItem(int position, @NonNull Item newItem) {
        mItems.add(position, newItem);
        notifyItemInserted(position);
    }

    public void addItems(@NonNull Collection<? extends Item> newItems) {
        addItems(mItems.size(), newItems);
    }

    public void addItems(int position, @NonNull Collection<? extends Item> newItems) {
        mItems.addAll(position, newItems);
        notifyItemRangeInserted(position, newItems.size());
    }
}
