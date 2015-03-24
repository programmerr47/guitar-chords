package com.github.programmerr47.chords.api.parsers;

import java.io.InputStream;
import java.util.List;

/**
 * Basic interface for all parsers from some response from AmDm.ru to {@code ParserResult} that
 * specified by some realisation. Assumed that AmDm.ru can be changed. For example, now it has no
 * API, so the only way to get som information is to parse pages. But it is not so effective. So
 * this interface is made for case, when above site moves to real API.
 * <br><br>
 * So if it is needed to provide some new parsers (there are new objects or new response format)
 * all parsers must implement this interface.
 *
 * @author Michael Spitsin
 * @since 2014-10-20
 */
public interface ParserFrom<ParseResult> {

    /**
     * Gets object from {@link String} that represented response.
     *
     * @param objectStr response string
     * @return object if it can be even partially created (when part of objectStr is valid and part is invalid) of null, if not
     */
    ParseResult parseObjectFrom(String objectStr);

    /**
     * Gets object from {@link InputStream} that represented response.
     *
     * @param objectIS response input stream
     * @return object if it can be even partially created (when part of objectIS is valid and part is invalid) of null, if not
     */
    ParseResult parseObjectFrom(InputStream objectIS);
}
