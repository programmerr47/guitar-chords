package com.github.programmerr47.chords.representation.adapter.item;

import android.support.annotation.NonNull;

import com.github.programmerr47.chords.representation.adapter.holder.producer.HolderProducer;
import com.github.programmerr47.chords.representation.utils.Util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * @author Michael Spitsin
 * @since 2014-04-04
 */
//TODO javadocs
public class RecyclerItems<Item extends AdapterItem> implements List<Item> {

    private List<Item> mItems;
    private Map<Integer, HolderProducer> mHolderMap;
    private List<String> mTypeNames;

    public RecyclerItems(@NonNull List<Item> items) {
        mItems = items;
        mTypeNames = Util.getAllDifferentClassesFromCollection(items);
        mHolderMap = retrieveProducers(items, mTypeNames);
    }

    @Override
    public void add(int location, Item item) {
        mItems.add(location, item);
        checkAndAddNewType(item, mTypeNames, mHolderMap);
    }

    @Override
    public boolean add(Item item) {
        boolean result = mItems.add(item);
        checkAndAddNewType(item, mTypeNames, mHolderMap);
        return result;
    }

    @Override
    public boolean addAll(int location, Collection<? extends Item> collection) {
        boolean result = mItems.addAll(location, collection);

        for (Item item : collection) {
            checkAndAddNewType(item, mTypeNames, mHolderMap);
        }

        return result;
    }

    @Override
    public boolean addAll(Collection<? extends Item> collection) {
        boolean result = mItems.addAll(collection);

        for (Item item : collection) {
            checkAndAddNewType(item, mTypeNames, mHolderMap);
        }

        return result;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("clear not supported yet in RecyclerItems");
    }

    @Override
    public boolean contains(Object object) {
        return mItems.contains(object);
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> collection) {
        return mItems.containsAll(collection);
    }

    @Override
    public Item get(int location) {
        return mItems.get(location);
    }

    @Override
    public int indexOf(Object object) {
        return mItems.indexOf(object);
    }

    @Override
    public boolean isEmpty() {
        return mItems.isEmpty();
    }

    @NonNull
    @Override
    public Iterator<Item> iterator() {
        return mItems.iterator();
    }

    @Override
    public int lastIndexOf(Object object) {
        return mItems.lastIndexOf(object);
    }

    @NonNull
    @Override
    public ListIterator<Item> listIterator() {
        return mItems.listIterator();
    }

    @NonNull
    @Override
    public ListIterator<Item> listIterator(int location) {
        return mItems.listIterator(location);
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
    public boolean removeAll(@NonNull Collection<?> collection) {
        throw new UnsupportedOperationException("removeAll not supported yet in RecyclerItems");
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> collection) {
        throw new UnsupportedOperationException("retainAll not supported yet in RecyclerItems");
    }

    @Override
    public Item set(int location, Item object) {
        throw new UnsupportedOperationException("set not supported yet in RecyclerItems");
    }

    @Override
    public int size() {
        return mItems.size();
    }

    @NonNull
    @Override
    public RecyclerItems<Item> subList(int start, int end) {
        throw new UnsupportedOperationException("subList not supported yet in RecyclerItems");
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return mItems.toArray();
    }

    @NonNull
    @Override
    public <T> T[] toArray(@NonNull T[] array) {
        return mItems.toArray(array);
    }

    public Map<Integer, HolderProducer> getTypesMap() {
        return Collections.unmodifiableMap(mHolderMap);
    }


    public int getItemType(int position) {
        Item item = get(position);
        String className = item.getClass().getName();
        return mTypeNames.indexOf(className);
    }

    private Map<Integer, HolderProducer> retrieveProducers(List<Item> items, List<String> typeNames) {
        Map<Integer, HolderProducer> result = new HashMap<>();

        for (Item item : items) {
            String className = item.getClass().getName();

            int key = typeNames.indexOf(className);

            if (key == -1) {
                throw new IllegalArgumentException("Not filled collection of typeNames");
            } else if (!result.containsKey(key)) {
                result.put(key, item.getViewHolderProducer());
            }
        }

        return result;
    }

    private void checkAndAddNewType(Item item, List<String> typeNames, Map<Integer, HolderProducer> holderMap) {
        String typeName = item.getClass().getName();
        int key = typeNames.indexOf(typeName);

        if (key == -1) {
            typeNames.add(typeName);
            holderMap.put(typeNames.size() - 1, item.getViewHolderProducer());
        }
    }
}
