package com.github.programmerr47.chords.representation.utils;

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
}
