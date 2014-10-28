package com.github.programmerr47.chords.api.parsers;

import com.github.programmerr47.chords.representation.utils.Util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.InputStream;
import java.util.List;

/**
 * Implements logic of working with HTML pages. Parse HTML layout and build new object(s).
 * <br><br>
 * <strong>Note:</strong> uses lib {@code org.jsoup} for parsing HTML.
 * <br><br>
 * All parsers that a using HTML layout as source for their result objects
 * must extend this class or its inheritors.
 *
 * @author Michael Spitsin
 * @since 2014-10-27
 */
public abstract class ParserFromHTML<ParseResult> implements ParserFrom<ParseResult> {

    @Override
    public ParseResult parseObjectFrom(String objectStr) {
        Document document = Jsoup.parse(objectStr);
        Element body = document.body();
        return parseObjectFromDoc(body);
    }

    @Override
    public ParseResult parseObjectFrom(InputStream objectIS) {
        String objectStr = Util.covertInputStreamToString(objectIS);
        Document document = Jsoup.parse(objectStr);
        Element body = document.body();
        return parseObjectFromDoc(body);
    }

    @Override
    public List<ParseResult> parseListFrom(String arrayStr) {
        Document document = Jsoup.parse(arrayStr);
        Element body = document.body();
        return parseListFromDoc(body);
    }

    @Override
    public List<ParseResult> parseListFrom(InputStream arrayIS) {
        String arrayStr = Util.covertInputStreamToString(arrayIS);
        Document document = Jsoup.parse(arrayStr);
        Element body = document.body();
        return parseListFromDoc(body);
    }

    /**
     * Gets object from {@link Element} that represented handled with special lib response.
     * For parsing HTMLs it is decided to use external lib {@code org.jsoup}.
     * <br><br>
     * Fro more information use: http://jsoup.org/
     *
     * @param element given document
     * @return object if it can be even partially created (when part of document is valid and part is invalid) of null, if not
     */
    protected abstract ParseResult parseObjectFromDoc(Element element);


    /**
     * Gets {@link List} of objects from {@link Element} that represented response with array of result objects.
     * For parsing HTMLs it is decided to use external lib {@code org.jsoup}.
     * <br><br>
     * Fro more information use: http://jsoup.org/
     *
     * @param element given document
     * @return list of objects if it can be even partially created (when part of document is valid and part is invalid) of null, if not
     */
    protected abstract List<ParseResult> parseListFromDoc(Element element);
}
