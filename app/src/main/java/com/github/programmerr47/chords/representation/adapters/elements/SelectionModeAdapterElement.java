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
    public void setElementSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    /**
     * Retrieves "selection" state of concrete element.
     *
     * @return true if element is selected and false if elements is deselected
     */
    public boolean isElementSelected() {
        return isSelected;
    }

}
