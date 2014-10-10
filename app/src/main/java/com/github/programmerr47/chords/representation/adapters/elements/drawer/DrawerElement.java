package com.github.programmerr47.chords.representation.adapters.elements.drawer;

import android.content.Context;

import com.github.programmerr47.chords.representation.adapters.elements.SelectionModeAdapterElement;

/**
 * Represents abstract drawer element
 *
 * @author Michael Spitsin
 * @since 2014-10-10
 */
public abstract class DrawerElement extends SelectionModeAdapterElement {

    protected Context mContext;
    protected DrawerElementName mName;

    public DrawerElement(Context context, DrawerElementName type) {
        if (context == null) {
            throw new NullPointerException("Context must be not null");
        }

        if (type == null) {
            throw new NullPointerException("Type must be not null");
        }

        mContext = context;
        mName = type;
    }

    public DrawerElementName getType() {
        return mName;
    }
}
