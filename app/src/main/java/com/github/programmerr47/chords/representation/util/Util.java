package com.github.programmerr47.chords.representation.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.github.programmerr47.chords.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Common presentation functions.
 *
 * @author Michael Spitsin
 * @since 2014-10-08
 */
public class Util {

    /**
     * Retrieve {@link List} with names of all different realisations of some class/interface from
     * given collection.
     * <br><br>
     * <strong>For example:</strong> there is interface I, and implemented classes A, B, C, and
     * there is a {@code List<I>} that contains A, A, B, A. Then this function will return List with
     * two strings: name of class A and  name of class B, because in this list there are objects of
     * only two different classes.
     * <br><br>
     * <strong>Note that:</strong> return value is Map for better performance, because retrieving map element
     * is faster than, for example, list.indexOf.
     *
     * @param collection given collection of objects
     * @return List with names of different classes
     */
    public static List<String> getAllDifferentClassesFromCollection(Collection<?> collection) {
        if (collection == null) {
            return null;
        } else {
            Set<String> preResult = new HashSet<>();

            for (Object item : collection) {
                String className = item.getClass().getName();
                preResult.add(className);
            }

            return new ArrayList<>(preResult);
        }
    }

    /**
     * Retrieves dynamic width of the drawer base on height of presented Toolbar.
     * <br><br>
     * <strong>Link: </strong> http://www.google.com/design/spec/layout/metrics-and-keylines.html#metrics-and-keylines-keylines-and-spacing
     * <br><br>
     * According to this link drawer_width = screen_width - toolbar_height.
     * <br><br>
     * <strong>Note </strong> that drawer has max_width defined by values/integer.xml resources
     * in <strong>independent pixels</strong>. Those xml-s specifying for different platforms.
     *
     * @param applicationContext given context of application to work with screen metrics
     * @return width of drawer in <strong>pixels</strong>
     */
    public static int getDrawerWidthPixels(Context applicationContext) {
        Resources resources = applicationContext.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int toolbarStandardHeight = resources.getInteger(R.integer.TOOLBAR_STANDARD_HEIGHT);
        int drawerMaxWidth = resources.getInteger(R.integer.DRAWER_MAX_WIDTH);
        float resultWidth = metrics.widthPixels - toolbarStandardHeight * metrics.density;

        if (resultWidth > drawerMaxWidth * metrics.density) {
            resultWidth = (int)(drawerMaxWidth * metrics.density);
        }

        return (int)resultWidth;
    }
}
