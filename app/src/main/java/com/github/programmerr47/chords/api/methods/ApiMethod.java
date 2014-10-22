package com.github.programmerr47.chords.api.methods;

import java.io.IOException;

/**
 * Common interface for all supported methods for this application.
 * If new methods will be available or needed to be written,
 * they must implement this interface or one of its inheritors.
 * <br><br>
 * <strong>Mark for 2014-10-20: </strong> Now, when there is no official API, just
 * page parsing, only GET methods will be available. However it is needed to make
 * common interface for future extension. For example, when API will be available.
 *
 * @author Michael Spitsin
 * @since 2014-10-20
 */
public interface ApiMethod<MethodResult> {

    /**
     * Starts executing method described by certain inheritor.
     *
     * @return result of certain method. It can be some response object (for GET methods),
     * or it can be just null object (for some POST methods or e.t.c)
     */
    @SuppressWarnings("unused")
    MethodResult execute() throws IOException;
}
