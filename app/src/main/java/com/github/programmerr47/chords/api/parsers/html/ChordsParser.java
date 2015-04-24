package com.github.programmerr47.chords.api.parsers.html;

import com.github.programmerr47.chords.api.objects.Chord;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Parser for {@link Chord} that uses as source song page. This parser parses whole list of
 * chords in those types of pages and returns list of results.
 *
 * @author Michael Spitsin
 * @since 2015-03-24
 */
public final class ChordsParser extends ParserFromHTML<List<Chord>> {

    private static final String CHORDS_TAG = "div";

    private static final String CHORDS_ATTRIBUTE = "id";

    private static final String CHORDS_IDENTIFICATOR = "song_chords";

    @Override
    protected List<Chord> parseObjectFromDoc(Element element) {
        if (element == null) {
            return null;
        }

        ParserFromHTML<Chord> chordParser = getSoloChordParser();
        List<Chord> result = new ArrayList<>();
        Element chords = element.getElementsByTag(CHORDS_TAG).first();

        if ((chords != null) && isChordsValid(chords)) {
            Elements items = chords.children();

            for (Element item : items) {
                Chord itemObject = chordParser.parseObjectFromDoc(item);

                if (itemObject != null) {
                    result.add(itemObject);
                }
            }
        }

        return result;
    }

    private boolean isChordsValid(Element chords) {
        Map<String, String> attrs = chords.dataset();

        if (attrs.containsKey(CHORDS_ATTRIBUTE)) {
            String value = attrs.get(CHORDS_ATTRIBUTE);
            if (CHORDS_IDENTIFICATOR.equals(value)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Used as method for fast and harmless changing of SongChords parser.
     *
     * @return song chords summary parser
     */
    private ParserFromHTML<Chord> getSoloChordParser() {
        return new SoloChordParser();
    }
}
