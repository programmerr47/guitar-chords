package com.github.programmerr47.chords.api.parsers.html;

import com.github.programmerr47.chords.api.objects.ArtistSummary;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Parser for {@link ArtistSummary} that uses as source now for "popular artists" page
 * for example or for "artists on letter <n>" page. This parser parses whole list of
 * artists in those types of pages and returns list of results.
 *
 * @author Michael Spitsin
 * @since 2014-10-30
 */
public class ArtistSummariesParser extends ParserFromHTML<List<ArtistSummary>> {

    private static final String ITEMS_TAG = "table";
    private static final String ITEMS_BODY_TAG = "tbody";

    private static final String ITEMS_CLASS = "items";

    @Override
    protected List<ArtistSummary> parseObjectFromDoc(Element element) {
        if (element == null) {
            return null;
        }

        ParserFromHTML<ArtistSummary> artistSummaryParser = getSoloArtistSummaryParser();
        List<ArtistSummary> result = new ArrayList<>();
        Elements tables = element.getElementsByTag(ITEMS_TAG);

        for (Element table : tables) {
            if (ITEMS_CLASS.equals(table.className())) {
                Element tbody = table.getElementsByTag(ITEMS_BODY_TAG).first();

                if (tbody != null) {
                    Elements items = tbody.children();

                    for (Element item : items) {
                        ArtistSummary itemObject = artistSummaryParser.parseObjectFromDoc(item);

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
    private ParserFromHTML<ArtistSummary> getSoloArtistSummaryParser() {
        return new SoloArtistSummaryParser();
    }
}
