package com.github.programmerr47.chords.representation.adapters.elements;

/**
 * Simple expansion of interface {@link AdapterElement} for organization of
 * "selection mode".
 *
 * @author Michael Spitsin
 * @since 2014-10-08
 */
public abstract class SelectionModeAdapterElement implements AdapterElement {

    protected boolean isSelected;

    /**
     * Selects/deselects element. It is needed for selection mode to keep the "selection"
     * state in element.
     *
     * @param isSelected true if need to select element, false if need to deselect element
     */
    public final void setElementSelected(boolean isSelected) {
        this.isSelected = isSelected;
        setViewSelected();
    }

    /**
     * Retrieves "selection" state of concrete element.
     *
     * @return true if element is selected and false if elements is deselected
     */
    public final boolean isElementSelected() {
        return isSelected;
    }

    /**
     * Changes view when calls {@link SelectionModeAdapterElement#setElementSelected(boolean)}.
     */
    protected abstract void setViewSelected();
}
