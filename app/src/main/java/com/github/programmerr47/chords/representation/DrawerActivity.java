package com.github.programmerr47.chords.representation;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.programmerr47.chords.R;
import com.github.programmerr47.chords.representation.adapters.elements.drawer.DrawerElement;
import com.github.programmerr47.chords.representation.adapters.elements.drawer.DrawerElementName;
import com.github.programmerr47.chords.representation.utils.Util;

/**
 * Main activity for all fragments that represented by drawer items.
 *
 * @author Michael Spitsin
 * @since 2014-10-15
 */
public class DrawerActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    /**
     * New action bar for material design
     */
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Change drawer width dynamically following by android guidelines
        // http://www.google.com/design/spec/layout/metrics-and-keylines.html#metrics-and-keylines-keylines-and-spacing
        //TODO replace this to another place
        ViewGroup.LayoutParams params = mNavigationDrawerFragment.getView().getLayoutParams();
        params.width = Util.getDrawerWidthPixels(getApplicationContext(), mToolbar.getLayoutParams().height);
        mNavigationDrawerFragment.getView().setLayoutParams(params);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(DrawerElement element, int position) {
        if ((element != null) && (element.getName() != null)) {
            // update the main content by replacing fragments
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, getFragmentInstanceByName(element.getName()))
                    .commit();
        }
    }

    @Override
    public void onSearchStarted(String searchText) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(100500))
                .commit();
    }

    /**
     * Retrieves new instance of fragment associated with specified name.
     *
     * @param name name of fragment
     * @return new instance of fragment
     * @throws java.lang.IllegalArgumentException
     */
    private Fragment getFragmentInstanceByName(DrawerElementName name) {
        switch (name) {
            case NEW_CHORDS:
                return PlaceholderFragment.newInstance(111);
            case POPULAR_CHORDS:
                return PlaceholderFragment.newInstance(121);
            case POPULAR_ARTISTS:
                return PlaceholderFragment.newInstance(113);
            case SAVED_CHORDS:
                return PlaceholderFragment.newInstance(411);
            case ALL_CHORDS:
                return PlaceholderFragment.newInstance(155);
            case ABOUT:
                return PlaceholderFragment.newInstance(7);
            case SEND_FEEDBACK:
                return PlaceholderFragment.newInstance(88);
            default:
                throw new IllegalArgumentException("There is no fragment associated with name: " + name);
        }
    }

    public void onSectionAttached(int number) {
        mTitle = number + "";
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle(mTitle);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.drawer, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.test_fragment, container, false);
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((DrawerActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }
}
