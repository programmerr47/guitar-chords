package com.github.programmerr47.chords.representation.adapter.holder.producer;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Interface-behaviour that used only for producing new instances of
 * ViewHolder depends on realisation. The main purpose is using in
 * {@link com.github.programmerr47.chords.representation.adapter.item.AdapterItem}.
 * This class has method
 * {@link com.github.programmerr47.chords.representation.adapter.item.AdapterItem#getViewHolderProducer()}
 * that retrieves instance of interface implementation that will produce necessary
 * {@link android.support.v7.widget.RecyclerView.ViewHolder} implementation.
 *
 * @author Michael Spitsin
 * @since 2015-04-05
 */
public interface HolderProducer {

    /**
     * Produces new instance of view holder.
     *
     * @param parentView parent view of view of the adapter element.
     *                   <strong>Note: </strong> it's only a parent view, <strong>not</strong>
     *                   a element view. So inheritor should implement logic of getting view
     *                   from parent one.
     * @return specific to {@link com.github.programmerr47.chords.representation.adapter.item.AdapterItem}
     *          view holder.
     */
    RecyclerView.ViewHolder produce(ViewGroup parentView);
}
