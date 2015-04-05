package com.github.programmerr47.chords.representation.adapters.element;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.github.programmerr47.chords.representation.adapters.holder.producer.HolderProducer;
import com.github.programmerr47.chords.representation.utils.Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * @author Michael Spitsin
 * @since 2014-04-04
 */
//TODO
public class RecyclerItems<Item extends AdapterItem> extends ArrayList<Item> {

    private Map<Integer, HolderProducer> mHolderMap;
    private List<String> mTypeNames;

    public RecyclerItems() {
        super();
        mTypeNames = new ArrayList<>();
        mHolderMap= new HashMap<>();
    }

    public RecyclerItems(List<Item> items) {
        super(items);
        mTypeNames = Util.getAllDifferentClassesFromCollection(items);
        mHolderMap = retrieveTypes(items);
    }

    @Override
    public void add(int location, Item object) {
        //TODO
    }

    @Override
    public boolean add(Item object) {
        //TODO
    }

    @Override
    public boolean addAll(int location, Collection<? extends Item> collection) {
        throw new UnsupportedOperationException("addAll not supported yet in RecyclerItems");
    }

    @Override
    public boolean addAll(Collection<? extends Item> collection) {
        throw new UnsupportedOperationException("addAll not supported yet in RecyclerItems");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("clear not supported yet in RecyclerItems");
    }

    @Override
    public Item remove(int location) {
        throw new UnsupportedOperationException("remove not supported yet in RecyclerItems");
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException("remove not supported yet in RecyclerItems");
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("removeAll not supported yet in RecyclerItems");
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("retainAll not supported yet in RecyclerItems");
    }

    @Override
    public Item set(int location, Item object) {
        throw new UnsupportedOperationException("set not supported yet in RecyclerItems");
    }

    @NonNull
    @Override
    public RecyclerItems<Item> subList(int start, int end) {
        throw new UnsupportedOperationException("subList not supported yet in RecyclerItems");
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    private Map<Integer, HolderProducer> retrieveProducers(List<Item> items, List<String> typeNames) {
        Map<Integer, HolderProducer> result = new HashMap<>();

        for (Item item : items) {
            String className = item.getClass().getName();

            int key = typeNames.indexOf(className);

            if (key == -1) {
                throw new IllegalArgumentException("Not filled collection of typeNames");
            } else {
                //TODO
            }
        }

        return new HashMap<>();
    }
}
