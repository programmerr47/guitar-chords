package com.github.programmerr47.chords.api.parsers.html;

import com.github.programmerr47.chords.api.objects.Chord;
import com.github.programmerr47.chords.api.objects.Song;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Parser for {@link com.github.programmerr47.chords.api.objects.Song} based on song page.
 *
 * @author Michael Spitsin
 * @since 2014-11-06
 */
public final class SongParser extends ParserFromHTML<Song> {

    private static final String DEFAULT_AMDM_DATE_FORMAT = "dd.MM.yyyy";

    private static final String ID_ATTRIBUTE = "id";
    private static final String ITEM_PROP_ATTRIBUTE = "itemprop";
    private static final String URL_ATTRIBUTE = "href";
    private static final String VIDEO_URL_ATTRIBUTE = "src";

    private static final String ARTIST_ITEM_PROP = "byArtist";
    private static final String CHORDS_ITEM_PROP = "chordsBlock";
    private static final String TITLE_ITEM_PROP = "name";

    private static final String CLASS = "class";
    private static final String NAVIGATION_BAR_CLASS = "b-nav hidden-phone";
    private static final String STATS_CLASS = "b-stats";
    private static final String VIDEO_CONTAINER_CLASS = "b-video-container";

    private static final String ALL_SONG_CHORDS_ID = "song_chords";

    @Override
    protected Song parseObjectFromDoc(Element element) {
        if (element == null) {
            return null;
        }

        Song.Builder resultObjectBuilder = new Song.Builder();

        //Trying to get artist
        Element artist = element.getElementsByAttributeValue(ITEM_PROP_ATTRIBUTE, ARTIST_ITEM_PROP).first();
        if (artist != null) {
            resultObjectBuilder.setArtistName(artist.text());
        }

        //Trying to get title
        Element title = element.getElementsByAttributeValue(ITEM_PROP_ATTRIBUTE, TITLE_ITEM_PROP).first();
        if (title != null) {
            resultObjectBuilder.setSongName(title.text());
        }

        //Trying to get text with chords
        Element text = element.getElementsByAttributeValue(ITEM_PROP_ATTRIBUTE, CHORDS_ITEM_PROP).first();
        if (text != null) {
            resultObjectBuilder.setTextWithChords(text.text());
        }

        //Trying to get artist url
        Element navigationUrls = element.getElementsByAttributeValue(CLASS, NAVIGATION_BAR_CLASS).first();
        if (navigationUrls != null) {
            Element artistUrl = navigationUrls.children().last();

            if (artistUrl != null) {
                resultObjectBuilder.setArtistUrl(artistUrl.attr(URL_ATTRIBUTE));
            }
        }

        //Trying to get chords
        Element chords = element.getElementsByAttributeValue(ID_ATTRIBUTE, ALL_SONG_CHORDS_ID).first();
        ParserFromHTML<List<Chord>> chordsParser = getChordsParser();
        List<Chord> chordList = chordsParser.parseObjectFromDoc(chords);
        resultObjectBuilder.setSongChords(chordList);

        tryToGetStatsInfo(element, resultObjectBuilder);
        tryToGetVideoUrl(element, resultObjectBuilder);

        return resultObjectBuilder.build();
    }

    /**
     * Trying to get stats: number of views and date of creation.
     * If something not found then nothing happens.
     *
     * @param element             page element
     * @param resultObjectBuilder builder of {@link Song}
     */
    private void tryToGetStatsInfo(Element element, Song.Builder resultObjectBuilder) {
        Element stats = element.getElementsByAttributeValue(CLASS, STATS_CLASS).first();
        if (stats != null) {
            Elements statsList = stats.children();

            Element numberOfViewsStat = statsList.get(0);
            if (numberOfViewsStat != null) {
                int count = 0;
                try {
                    count = Integer.parseInt(numberOfViewsStat.text().replaceAll(",", ""));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                resultObjectBuilder.setNumberOfViews(count);
            }

            Element creationDateStat = statsList.get(2);
            if (creationDateStat != null) {
                DateFormat dateFormat = new SimpleDateFormat(DEFAULT_AMDM_DATE_FORMAT, Locale.getDefault());
                try {
                    Date date = dateFormat.parse(creationDateStat.text());
                    resultObjectBuilder.setCreationDate(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void tryToGetVideoUrl(Element element, Song.Builder resultObjectBuilder) {
        Element videoContainer = element.getElementsByAttributeValue(CLASS, VIDEO_CONTAINER_CLASS).first();

        if (videoContainer != null) {
            Element videoUrl = element.getElementsByAttribute(VIDEO_URL_ATTRIBUTE).first();

            if (videoUrl != null) {
                String url = videoUrl.attr(VIDEO_URL_ATTRIBUTE);
                resultObjectBuilder.setVideoUrl(url);
            }
        }
    }

    /**
     * Used as method for fast and harmless changing of Chords parser.
     *
     * @return song chords summary parser
     */
    private ParserFromHTML<List<Chord>> getChordsParser() {
        return new ChordsParser();
    }
}
