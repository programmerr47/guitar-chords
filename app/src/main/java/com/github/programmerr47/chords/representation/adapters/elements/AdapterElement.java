package com.github.programmerr47.chords.representation.adapters.elements;

import android.view.View;
import android.view.ViewGroup;

/**
 * Represents abstract item of abstract adapter. This is can be just opening item, item with some
 * buttons, search item, anything.
 *
 * @author Michael Spitsin
 * @since 2014-10-07
 */
public interface AdapterElement {

    /**
     * Retrieves id of type of specific implementation.
     * ListView has different types of elements, with different layouts.
     * Therefor it is needed to specify type identifier to refresh we,
     * if new view differs from old view, when you scrolling.
     *
     * @return id of type
     */
    int getTypeId();

    /**
     * Retrieves unique identificator of {@link AdapterElement}. This is needed for
     * specify behavior of each concrete item, if It cannot be done inside specific class.
     *
     * @return id of element
     */
    int getElementId();

    /**
     * Calls when another taken in {@link com.github.programmerr47.chords.representation.adapters.BindBaseAdapter#getView(int, android.view.View, android.view.ViewGroup)}
     * element is not exists and it is needed to create it from layout.
     *
     * @param parent parent view group
     * @param position position of element that will be represented by this view
     * @return created View
     */
    View newView(ViewGroup parent, int position);

    /**
     * Calls when another taken in {@link com.github.programmerr47.chords.representation.adapters.BindBaseAdapter#getView(int, android.view.View, android.view.ViewGroup)}
     * element is exists and it is needed to bind it (set up it).
     *
     * @param view given created of existing view
     * @param position position of this view
     */
    void bindView(View view, int position);
}
