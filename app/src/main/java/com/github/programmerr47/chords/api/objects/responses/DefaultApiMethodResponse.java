package com.github.programmerr47.chords.api.objects.responses;

import android.support.annotation.NonNull;

/**
 * Standard implementation of {@link com.github.programmerr47.chords.api.objects.responses.ApiMethodResponse}
 * that contains all basic logic of working with response object of
 * {@link com.github.programmerr47.chords.api.methods.ApiMethod#execute()} method.
 * So it enough to use this implementation in most of cases.
 *
 * @author Michael Spitsin
 * @since 2015-03-20
 */
public class DefaultApiMethodResponse<ResponseObject> implements ApiMethodResponse<ResponseObject> {

    private ResponseObject responseObject;
    private boolean isValid;
    private ApiMethodResponseReason reason;

    public DefaultApiMethodResponse(ResponseObject responseObject, @NonNull ResponseInfoBuilder additionalInfo) {
        this.responseObject = responseObject;
        this.isValid = additionalInfo.isValid;
        this.reason = additionalInfo.reason;
    }

    public DefaultApiMethodResponse(@NonNull ResponseInfoBuilder additionalInfo) {
        this(null, additionalInfo);
    }

    @Override
    public boolean isResponseValid() {
        return isValid;
    }

    @NonNull
    @Override
    public ApiMethodResponseReason getReason() {
        return reason;
    }

    @Override
    public ResponseObject getResponseObject() {
        return responseObject;
    }

    /**
     * Standard builder that gather all additional info for
     * {@link com.github.programmerr47.chords.api.objects.responses.DefaultApiMethodResponse}.
     *
     * @author Michael Spitsin
     * @since 2015-03-20
     */
    public static class ResponseInfoBuilder {
        private boolean isValid = true;
        private ApiMethodResponseReason reason = ApiMethodResponseReason.NO_REASON;

        @SuppressWarnings("unused")
        public ResponseInfoBuilder setValid(boolean isValid) {
            this.isValid = isValid;
            return this;
        }

        @SuppressWarnings("unused")
        public ResponseInfoBuilder setReason(@NonNull ApiMethodResponseReason reason) {
            this.reason = reason;
            return this;
        }
    }
}
