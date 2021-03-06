package com.github.programmerr47.chords.api.parsers.html;

import com.github.programmerr47.chords.api.objects.SongSummary;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Default parser for {@link com.github.programmerr47.chords.api.objects.SongSummary} that uses artist page for parsing.
 * This parser parses whole list of songs in artist page and returns list of results.
 *
 * @author Michael Spitsin
 * @since 2015-03-24
 */
public final class ArtistSongSummariesParser extends ParserFromHTML<List<SongSummary>> {

    private static final String ITEMS_TAG = "table";
    private static final String ITEMS_BODY_TAG = "tbody";

    private static final String ITEMS_CLASS = "items";

    @Override
    protected List<SongSummary> parseObjectFromDoc(Element element) {
        if (element == null) {
            return null;
        }

        ParserFromHTML<SongSummary> songChordsSummaryParser = getSongChordsSummaryParser();
        List<SongSummary> result = new ArrayList<>();
        Elements tables = element.getElementsByTag(ITEMS_TAG);

        for (Element table : tables) {
            if (ITEMS_CLASS.equals(table.className())) {
                Element tbody = table.getElementsByTag(ITEMS_BODY_TAG).first();

                if (tbody != null) {
                    Elements items = tbody.children();

                    for (Element item : items) {
                        SongSummary itemObject = songChordsSummaryParser.parseObjectFromDoc(item);

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
    private ParserFromHTML<SongSummary> getSongChordsSummaryParser() {
        return new ArtistSoloSongSummaryParser();
    }
}
