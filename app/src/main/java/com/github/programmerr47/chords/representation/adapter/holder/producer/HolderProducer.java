package com.github.programmerr47.chords.representation.adapter.holder.producer;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * @author Michael Spitsin
 * @since 2015-04-05
 */
//TODO javadocs
public interface HolderProducer {

    /**
     * Produces new instance of view holder.
     *
     *
     * @param parentView parent view of view of the adapter element.
     *                   <strong>Note: </strong> it's only a parent view, <strong>not</strong>
     *                   a element view. So inheritor should implement logic of getting view
     *                   from parent one.
     * @return
     */
    RecyclerView.ViewHolder produce(ViewGroup parentView);
}
