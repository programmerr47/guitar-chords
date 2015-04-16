package com.github.programmerr47.chords.api.parsers.html;

import com.github.programmerr47.chords.api.objects.SongSummary;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Default parser for {@link SongSummary} that uses most of pages with song summaries to
 * parse like "popular songs" page, "new songs" page, "search result" page etc.
 * <br><br>
 * <strong>Note:</strong>
 * This parser parses only one summary from list of song summaries, that stored in "new songs"
 * page and etc. and returns only one instance of {@link SongSummary}. So default purpose of this parser
 * is being used by {@link SongSummariesParser}, that must parse entire list of song summaries.
 *
 * @author Michael Spitsin
 * @since 2014-10-28
 */
public final class SoloSongSummaryParser extends ParserFromHTML<SongSummary> {

    private static final String ITEM_TAG = "tr";
    private static final String IMAGE_TAG = "img";
    private static final String SPAN_TAG = "span";

    private static final String ITEM_INFO_CLASS = "artist_name";
    private static final String ARTIST_CLASS = "artist";
    private static final String NEW_FLAG_CLASS = "flag flag_new";

    private static final String IMAGE_SOURCE_ATTRIBUTE = "src";
    private static final String URL_ATTRIBUTE = "href";

    @Override
    protected SongSummary parseObjectFromDoc(Element element) {
        if ((element == null) || !ITEM_TAG.equals(element.tagName())) {
            return null;
        }

        SongSummary.Builder resultObjectBuilder = new SongSummary.Builder();
        resultObjectBuilder.setCoverThumbUrl(getItemImageUrl(element));

        Element chordsInfo = element.getElementsByClass(ITEM_INFO_CLASS).first();

        if (chordsInfo != null) {
            parseInfo(chordsInfo, resultObjectBuilder);
        }

        return resultObjectBuilder.build();
    }

    private String getItemImageUrl(Element item) {
        Element image = item.getElementsByTag(IMAGE_TAG).first();

        if (image != null) {
            return image.attr(IMAGE_SOURCE_ATTRIBUTE);
        }

        return null;
    }

    private void parseInfo(Element chordsInfo, SongSummary.Builder resultObjectBuilder) {
        Elements artistTitle = chordsInfo.getElementsByClass(ARTIST_CLASS);
        int artistTitleLength = artistTitle.size();

        //Trying to get artist name
        if (artistTitleLength > 0) {
            String artist = artistTitle.get(0).val();
            String artistUrl = artistTitle.get(0).attr(URL_ATTRIBUTE);
            resultObjectBuilder
                    .setArtistName(artist)
                    .setArtistUrl(artistUrl);
        }

        //Trying to get song title and url to chords
        if (artistTitleLength > 1) {
            String title = artistTitle.get(1).val();
            String chordsUrl = artistTitle.get(1).attr(URL_ATTRIBUTE);
            resultObjectBuilder
                    .setSongName(title)
                    .setChordsUrl(chordsUrl);
        }

        //Trying to find flag that indicates that those chords is new
        Elements spans = chordsInfo.getElementsByTag(SPAN_TAG);
        for (Element span : spans) {
            if (NEW_FLAG_CLASS.equals(span.className())) {
                resultObjectBuilder.setIsNew(true);
            }
        }
    }
}
