package com.github.programmerr47.chords.representation.adapters.elements;

/**
 * Simple expansion of interface {@link AdapterElement} for organization of
 * "selection mode".
 *
 * @author Michael Spitsin
 * @since 2014-10-08
 */
public interface SelectionModeAdapterElement extends AdapterElement {

    /**
     * Selects/deselects element. It is needed for selection mode to keep the "selection"
     * state in element.
     *
     * @param isSelected true if need to select element, false if need to deselect element
     */
    void setElementSelected(boolean isSelected);

    /**
     * Retrieves "selection" state of concrete element.
     *
     * @return true if element is selected and false if elements is deselected
     */
    boolean isElementSelected();
}
