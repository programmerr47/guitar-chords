package com.github.programmerr47.chords.api.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Common api functions.
 *
 * @author Michael Spitsin
 * @since 2015-04-14
 */
public class Util {

    /**
     * Converts given input stream (<strong>without</strong> closing it) to {@link String}.
     *
     * @param is given input stream
     * @return converted stream to string
     */
    //TODO replace to API.utils
    public static String covertInputStreamToString(InputStream is) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String line;
        String result = "";

        try {
            while((line = bufferedReader.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
            //ignored
        }

        return result;
    }
}
