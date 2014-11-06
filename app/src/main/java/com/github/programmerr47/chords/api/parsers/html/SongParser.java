package com.github.programmerr47.chords.api.parsers.html;

import com.github.programmerr47.chords.api.objects.SongChords;

import org.jsoup.nodes.Element;

import java.util.List;

/**
 * Parser for {@link SongChords} based on song page.
 *
 * @author Michael Spitsin
 * @since 2014-11-06
 */
public final class SongParser extends ParserFromHTML<SongChords> {

    @Override
    protected SongChords parseObjectFromDoc(Element element) {
        //TODO finish
        return null;
    }

    @Override
    protected List<SongChords> parseListFromDoc(Element element) {
        throw new UnsupportedOperationException("Cannot parse list of artist pages");
    }
}
