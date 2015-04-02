package com.github.programmerr47.chords.representation.adapters.factory;

import android.view.View;

import com.github.programmerr47.chords.representation.adapters.elements.drawer.DrawerElement;

/**
 * Abs
 *
 * @author Michael Spitsin
 * @since 2015-04-02
 */
public interface AbstractRecyclerHolderFactory<ParameterType> {
    
     DrawerElement produceHolder(View elementParentView, ParameterType viewType);
}
