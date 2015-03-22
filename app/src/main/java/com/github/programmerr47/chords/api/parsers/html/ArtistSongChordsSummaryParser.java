package com.github.programmerr47.chords.api.parsers.html;

import com.github.programmerr47.chords.api.objects.SongChordsSummary;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Default parser for {@link SongChordsSummary} that uses artist page for parsing.
 *
 * @author Michael Spitsin
 * @since 2014-10-29
 */
public final class ArtistSongChordsSummaryParser extends ParserFromHTML<SongChordsSummary>{

    private static final String ITEMS_TAG = "table";
    private static final String ITEMS_BODY_TAG = "tbody";
    private static final String ITEM_TAG = "tr";
    private static final String SPAN_TAG = "span";

    private static final String ITEMS_CLASS = "items";
    private static final String NEW_FLAG_CLASS = "flag flag_new";
    private static final String VIDEO_FlAG_CLASS = "fa fa-youtube-play";
    private static final String SONG_TITLE_CLASS = "g-link";
    private static final String VIEW_COUNT_CLASS = "number hidden-phone";

    private static final String URL_ATTRIBUTE = "href";
    private static final String CLASS_ATTRIBUTE = "class";

    @Override
    protected SongChordsSummary parseObjectFromDoc(Element element) {
        if ((element == null) || !ITEM_TAG.equals(element.tagName())) {
            return null;
        }

        SongChordsSummary.Builder resultObjectBuilder = new SongChordsSummary.Builder();

        //Get song title and chords url
        Element title = element.getElementsByClass(SONG_TITLE_CLASS).first();
        if (title != null) {
            resultObjectBuilder
                    .setSongName(title.text())
                    .setChordsUrl(title.attr(URL_ATTRIBUTE));
        }

        //Trying to find "new flag" that indicates, that chord is new
        Elements spans = element.getElementsByTag(SPAN_TAG);
        for (Element span : spans) {
            if (NEW_FLAG_CLASS.equals(span.className())) {
                resultObjectBuilder.setIsNew(true);
                break;
            }
        }

        //Trying to find video flag
        Elements video = element.getElementsByAttributeValue(CLASS_ATTRIBUTE, VIDEO_FlAG_CLASS);
        if (video.size() > 0) {
            resultObjectBuilder.setHasVideo(true);
        }

        //Getting number of views
        Element viewCount = element.getElementsByAttributeValue(CLASS_ATTRIBUTE, VIEW_COUNT_CLASS).first();
        int count = 0;
        try {
            count = Integer.parseInt(viewCount.text().replaceAll(",", ""));
        } catch (NumberFormatException e) {
            //ignore
        }
        resultObjectBuilder.setNumberOfViews(count);

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
}
