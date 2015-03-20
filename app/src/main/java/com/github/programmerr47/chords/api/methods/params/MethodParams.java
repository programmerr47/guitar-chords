package com.github.programmerr47.chords.api.methods.params;

import android.support.annotation.NonNull;

/**
 * Common interface for all additional params of any methods.
 * Each method has some pack of parameters, so this interface declare
 * some pack for some method.
 * <br><br>
 * If new method will be available, it will inherit {@link com.github.programmerr47.chords.api.methods.ApiMethod},
 * and its parameters must implement this interface of its inheritors.
 *
 * @author Michael Spitsin
 * @since 2014-10-20
 */
public interface MethodParams {

    /**
     * All subclasses must have some fields (param values) and constants (param names).
     * This method will return representation of all entered params for queries and requests.
     *
     * @return string representation of all built params.
     */
    @NonNull
    @SuppressWarnings("unused")
    String getParamsString();
}
