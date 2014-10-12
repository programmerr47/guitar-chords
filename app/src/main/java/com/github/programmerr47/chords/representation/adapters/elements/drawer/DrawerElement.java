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

    public DrawerElement(Builder builder) {
        if (builder.context == null) {
            throw new NullPointerException("Context must be not null");
        }

        if (builder.name == null) {
            throw new NullPointerException("Type must be not null");
        }

        mContext = builder.context;
        mName = builder.name;
    }

    public final DrawerElementName getName() {
        return mName;
    }


    /**
     * @author Michael Spitsin
     * @since 2014-10-12
     */
    public static abstract class Builder {
        private Context context;
        private DrawerElementName name;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setName(DrawerElementName name) {
            this.name = name;
            return this;
        }

        public abstract DrawerElement build();
    }
}
