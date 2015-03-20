package com.github.programmerr47.chords.api.utils;

/**
 * List of available chords, that can be present in texts of songs.
 * This list made for comfortable treatment with texts, parsing chords,
 * for allocation of constants not in Strings but in enum.
 *
 * @author Michael Spitsin
 * @since 2014-10-24
 */
@SuppressWarnings("unused")
public enum AvailableChords {
    ;

    private String mStringRepresentation;
    private String mUrlRepresentation;

    private AvailableChords(String stringRepresentation, String urlRepresentation) {
        mStringRepresentation = stringRepresentation;
        mUrlRepresentation = urlRepresentation;
    }

    @Override
    public String toString() {
        return mStringRepresentation;
    }

    public String getStringRepresentation() {
        return mStringRepresentation;
    }

    public String getUrlRepresentation() {
        return mUrlRepresentation;
    }

    public static AvailableChords fromString(String strRepresentation) {
        //TODO
        return null;
    }
}
