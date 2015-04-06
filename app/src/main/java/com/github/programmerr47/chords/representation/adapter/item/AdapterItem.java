package com.github.programmerr47.chords.representation.adapter.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.programmerr47.chords.representation.adapter.holder.producer.HolderProducer;

/**
 * Represents abstract item of abstract adapter. This is can be just opening item, item with some
 * buttons, search item, anything.
 * <br><br>
 * <strong>Update 2015-04-02: </strong>
 * Because of moving to {@link android.support.v7.widget.RecyclerView.Adapter}, logic have to be
 * slightly changed. So know this is interface to work with binding view and producing holder
 * for view, related to this element.
 *
 * @author Michael Spitsin
 * @since 2014-10-07
 */
public interface AdapterItem {

    /**
     * Calls when element taken in
     * {@link com.github.programmerr47.chords.representation.adapter.RecyclerAdapter#onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder, int)}
     * is exists and it is needed to bind it (set up it).
     *
     * @param viewHolder holder for view, that need to be bound
     * @param position position of this view
     */
    void bindView(RecyclerView.ViewHolder viewHolder, int position);

    /**
     * Produce new instance of
     * {@link com.github.programmerr47.chords.representation.adapter.holder.producer.HolderProducer}
     * or any of it inheritor. Choosing what is needed to be created or produced depends on
     * implementation of this interface. So it is inheritor responsibility to providing context
     * and information to creating correct producer.
     * <br><br>
     * <strong>Not that: </strong> subclasses should only create new producer. All other manipulations
     * must be done in {@link this#bindView(android.support.v7.widget.RecyclerView.ViewHolder, int)}
     * method (like filling view with specific information) or in
     * {@link com.github.programmerr47.chords.representation.adapter.holder.producer.HolderProducer#produce()}
     * method (like creation of new holder).
     *
     * @return instance of specific producer that can build new holder
     */
    HolderProducer getViewHolderProducer();
}
