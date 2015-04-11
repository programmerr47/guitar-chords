package com.github.programmerr47.chords.representation;


import com.github.programmerr47.chords.representation.adapter.item.drawer.DrawerItem;

/**
 * Callbacks interface that all activities using this fragment must implement.
 *
 * @author Michael Spitsin
 * @since 2015-04-12
 */
public interface NavigationDrawerCallbacks {

    /**
     * Called when an item in the navigation drawer is selected.
     *
     * @param selectedItem item that was selected
     * @param position position of item that was selected
     */
    void onNavigationDrawerItemSelected(DrawerItem selectedItem, int position);
}
