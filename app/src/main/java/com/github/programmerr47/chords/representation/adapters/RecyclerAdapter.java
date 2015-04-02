package com.github.programmerr47.chords.representation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.github.programmerr47.chords.representation.adapters.elements.RecyclerElement;

/**
 * Created by MS on 01.04.2015.
 */
public class RecyclerAdapter<Element extends RecyclerElement> extends RecyclerView.Adapter<Element> {



    @Override
    public Element onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(Element holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
