package com.github.programmerr47.chords.api.parsers.html;

import com.github.programmerr47.chords.api.objects.SongChordsSummary;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Default parser for {@link com.github.programmerr47.chords.api.objects.SongChordsSummary} that uses artist page for parsing.
 * This parser parses whole list of songs in artist page and returns list of results.
 *
 * @author Michael Spitsin
 * @since 2015-03-24
 */
public final class ArtistSongSummariesParser extends ParserFromHTML<List<SongChordsSummary>> {

    private static final String ITEMS_TAG = "table";
    private static final String ITEMS_BODY_TAG = "tbody";

    private static final String ITEMS_CLASS = "items";

    @Override
    protected List<SongChordsSummary> parseObjectFromDoc(Element element) {
        if (element == null) {
            return null;
        }

        ParserFromHTML<SongChordsSummary> songChordsSummaryParser = getSongChordsSummaryParser();
        List<SongChordsSummary> result = new ArrayList<>();
        Elements tables = element.getElementsByTag(ITEMS_TAG);

        for (Element table : tables) {
            if (ITEMS_CLASS.equals(table.className())) {
                Element tbody = table.getElementsByTag(ITEMS_BODY_TAG).first();

                if (tbody != null) {
                    Elements items = tbody.children();

                    for (Element item : items) {
                        SongChordsSummary itemObject = songChordsSummaryParser.parseObjectFromDoc(item);

                        if (itemObject != null) {
                            result.add(itemObject);
                        }
                    }
                }
            }
        }

        return result;
    }

    /**
     * Used as method for fast and harmless changing of SongChords parser.
     *
     * @return song chords summary parser
     */
    private ParserFromHTML<SongChordsSummary> getSongChordsSummaryParser() {
        return new ArtistSoloSongSummaryParser();
    }
}
