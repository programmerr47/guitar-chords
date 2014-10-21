package com.github.programmerr47.chords.api.methods;

import android.support.annotation.NonNull;

import com.github.programmerr47.chords.api.methods.params.MethodParams;

/**
 * Common template for all GET-methods. All new implemented GET-methods
 * must extend this class.
 *
 * @author Michael Spitsin
 * @since 2014-10-21
 */
public abstract class ApiGetMethod<MethodResult> implements ApiMethod<MethodResult> {

    protected MethodParams mParams;

    public ApiGetMethod(@NonNull MethodParams params) {
        mParams = params;
    }

    @Override
    public MethodResult execute() {
        return null; //TODO finish
    }

    /**
     * Retrieves method url base on type of method. Basically all api method
     * has common part of url (it is a API url), but for more flexibility
     * we has not getMethodName method but getUrl method for maintenance cases
     * when you has no official api and need to parse some page for example.
     *
     * @return method url
     */
    protected abstract @NonNull String getFullUrlWithoutParams();
}
