package com.github.programmerr47.chords.representation.utils;

import android.content.Context;
import android.util.DisplayMetrics;

import com.github.programmerr47.chords.representation.Constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Common functions.
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
            Set<String> preResult = new HashSet<String>();

            for (Object item : collection) {
                String className = item.getClass().getName();
                preResult.add(className);
            }

            return new ArrayList<String>(preResult);
        }
    }

    /**
     * Retrieves dynamic width of the drawer base on height of presented Toolbar.
     * <br><br>
     * <strong>Link: </strong> http://www.google.com/design/spec/layout/metrics-and-keylines.html#metrics-and-keylines-keylines-and-spacing
     * <br><br>
     * According to this link drawer_width = screen_width - toolbar_height.
     * <br><br>
     * <strong>Note </strong> that drawer has max_width defined by
     * {@link Constants#DRAWER_MAX_WIDTH_DP} in <strong>independent pixels</strong>.
     *
     * @param applicationContext given context of application to work with screen metrics
     * @param toolbarHeight height of currently displayed toolbar in <strong>pixels</strong>
     * @return width of drawer in <strong>pixels</strong>
     */
    public static int getDrawerWidthPixels(Context applicationContext, int toolbarHeight) {
        DisplayMetrics metrics = applicationContext.getResources().getDisplayMetrics();
        int resultWidth = metrics.widthPixels - toolbarHeight;

        if (resultWidth > Constants.DRAWER_MAX_WIDTH_DP * metrics.density) {
            resultWidth = (int)(Constants.DRAWER_MAX_WIDTH_DP * metrics.density);
        }

        return resultWidth;
    }
}
