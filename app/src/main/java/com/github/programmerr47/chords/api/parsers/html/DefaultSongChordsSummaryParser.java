package com.github.programmerr47.chords.api.parsers.html;

import com.github.programmerr47.chords.api.objects.SongChordsSummary;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Default parser for {@link SongChordsSummary} that uses "popular chords" page
 * and "new chords" page for parsing.
 *
 * @author Michael Spitsin
 * @since 2014-10-28
 */
@SuppressWarnings("unused")
public final class DefaultSongChordsSummaryParser extends ParserFromHTML<SongChordsSummary> {

    private static final String ITEMS_TAG = "table";
    private static final String ITEMS_BODY_TAG = "tbody";
    private static final String ITEM_TAG = "tr";
    private static final String IMAGE_TAG = "img";
    private static final String SPAN_TAG = "span";

    private static final String ITEMS_CLASS = "items";
    private static final String ITEM_INFO_CLASS = "artist_name";
    private static final String ARTIST_CLASS = "artist";
    private static final String NEW_FLAG_CLASS = "flag flag_new";

    private static final String IMAGE_SOURCE_ATTRIBUTE = "src";
    private static final String URL_ATTRIBUTE = "href";

    @Override
    protected SongChordsSummary parseObjectFromDoc(Element element) {
        if ((element == null) || !ITEM_TAG.equals(element.tagName())) {
            return null;
        }

        SongChordsSummary.Builder resultObjectBuilder = new SongChordsSummary.Builder();
        resultObjectBuilder.setCoverThumbUrl(getItemImageUrl(element));

        Element chordsInfo = element.getElementsByClass(ITEM_INFO_CLASS).first();

        if (chordsInfo != null) {
            parseInfo(chordsInfo, resultObjectBuilder);
        }

        return resultObjectBuilder.build();
    }

    @Override
    protected List<SongChordsSummary> parseListFromDoc(Element element) {
        if (element == null) {
            return null;
        }

        List<SongChordsSummary> result = new ArrayList<SongChordsSummary>();
        Elements tables = element.getElementsByTag(ITEMS_TAG);

        for (Element table : tables) {
            if (ITEMS_CLASS.equals(table.className())) {
                Element tbody = table.getElementsByTag(ITEMS_BODY_TAG).first();

                if (tbody != null) {
                    Elements items = tbody.children();

                    for (Element item : items) {
                        SongChordsSummary itemObject = parseObjectFromDoc(item);

                        if (itemObject != null) {
                            result.add(itemObject);
                        }
                    }
                }
            }
        }

        return result;
    }

    private String getItemImageUrl(Element item) {
        Element image = item.getElementsByTag(IMAGE_TAG).first();

        if (image != null) {
            return image.attr(IMAGE_SOURCE_ATTRIBUTE);
        }

        return null;
    }

    private void parseInfo(Element chordsInfo, SongChordsSummary.Builder resultObjectBuilder) {
        Elements artistTitle = chordsInfo.getElementsByClass(ARTIST_CLASS);
        String artist = artistTitle.get(0).val();
        String title = artistTitle.get(1).val();
        String chordsUrl = artistTitle.get(1).attr(URL_ATTRIBUTE);

        resultObjectBuilder
                .setArtistName(artist)
                .setSongName(title)
                .setChordsUrl(chordsUrl);

        Elements spans = chordsInfo.getElementsByTag(SPAN_TAG);
        for (Element span : spans) {
            if (NEW_FLAG_CLASS.equals(span.className())) {
                resultObjectBuilder.setIsNew(true);
            }
        }
    }
}
