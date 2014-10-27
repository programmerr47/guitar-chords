package com.github.programmerr47.chords.api.parsers;

import com.github.programmerr47.chords.representation.utils.Util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.InputStream;
import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2014-10-27
 */
public abstract class ParserFromHTML<ParseResult> implements ParserFrom<ParseResult> {

    @Override
    public ParseResult parseObjectFrom(String objectStr) {
        Document document = Jsoup.parse(objectStr);
        return parseObjectFromDoc(document);
    }

    @Override
    public ParseResult parseObjectFrom(InputStream objectIS) {
        String objectStr = Util.covertInputStreamToString(objectIS);
        Document document = Jsoup.parse(objectStr);
        return parseObjectFromDoc(document);
    }

    @Override
    public List<ParseResult> parseListFrom(String arrayStr) {
        Document document = Jsoup.parse(arrayStr);
        return parseListFromDoc(document);
    }

    @Override
    public List<ParseResult> parseListFrom(InputStream arrayIS) {
        String arrayStr = Util.covertInputStreamToString(arrayIS);
        Document document = Jsoup.parse(arrayStr);
        return parseListFromDoc(document);
    }

    /**
     * Gets object from {@link Document} that represented handled with special lib response.
     * For parsing HTMLs it is decided to use external lib {@code org.jsoup}.
     * <br><br>
     * Fro more information use: http://jsoup.org/
     *
     * @param document given document
     * @return object if it can be even partially created (when part of document is valid and part is invalid) of null, if not
     */
    protected abstract ParseResult parseObjectFromDoc(Document document);


    /**
     * Gets {@link List} of objects from {@link Document} that represented response with array of result objects.
     * For parsing HTMLs it is decided to use external lib {@code org.jsoup}.
     * <br><br>
     * Fro more information use: http://jsoup.org/
     *
     * @param document given document
     * @return list of objects if it can be even partially created (when part of document is valid and part is invalid) of null, if not
     */
    //TODO seems it must be implemented here.
    protected abstract List<ParseResult> parseListFromDoc(Document document);
}
