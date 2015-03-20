package com.github.programmerr47.chords.api.objects.responses;

import android.support.annotation.NonNull;

/**
 * Simple enums, that provides reasons of failing while executing
 * {@link com.github.programmerr47.chords.api.methods.ApiMethod#execute()} method.
 * This is used instead of throwing exceptions to provide more beautiful and flexible
 * code. For example for not always using "throws" or (instead of "throws") not just catch
 * and ignore exceptions and forget about them.
 *
 * @author Michael Spitsin
 * @since 2015-03-20
 */
public enum ApiMethodResponseReason {
    NO_REASON("Method was successful"),
    NO_URL("Method has no url for providing a call"),
    NO_PARSER("There is no parser for providing conversion from response to object"),
    ERROR_CONNECTION_CODE("Connection return wrong code: %s with message %s"),
    ERROR_CONNECTION("Error while working with url connection"),
    NO_RESULT("Empty result stream, no result stream");

    private String reason;

    private ApiMethodResponseReason(@NonNull String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public ApiMethodResponseReason formatReason(Object... args) {
        reason = String.format(reason, args);
        return this;
    }

    @Override
    public String toString() {
        return reason;
    }
}
