package com.github.programmerr47.chords.api.objects.responses;

import android.support.annotation.NonNull;

/**
 * Common interface for all responses of {@link com.github.programmerr47.chords.api.methods.ApiMethod}.
 * Used for wrap response objects that received from {@link com.github.programmerr47.chords.api.methods.ApiMethod#execute()}.
 * So when ApiMethod will be executed, client will not receive null or will need to catch some exception,
 * but will receive response object wrapper that now valid response or not, now reason if object is not valid,
 * and provide a response object, if response will be valid.
 *
 * @author Michael Spitsin
 * @since 2015-03-20
 */
public interface ApiMethodResponse<ResponseObject> {

    /**
     * Simple method, that provides information about success of
     * {@link com.github.programmerr47.chords.api.methods.ApiMethod#execute()}.
     *
     * @return true, if succeed, false otherwise
     */
    boolean isResponseValid();

    /**
     * Method, that gets a reason if response will be negative. If response
     * will positive, it should return
     * {@link ApiMethodResponseReason#NO_REASON}.
     *
     * @return reason of such response
     */
    @NonNull
    ApiMethodResponseReason getReason();

    /**
     * Method, that return valid and built response object if
     * {@link com.github.programmerr47.chords.api.methods.ApiMethod#execute()} method
     * was successfully completed. If not it return not valid object or null.
     *
     * @return valid or not result object, depends on success of executing function
     */
    ResponseObject getResponseObject();
}