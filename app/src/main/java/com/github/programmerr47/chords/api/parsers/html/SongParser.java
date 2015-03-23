package com.github.programmerr47.chords.api.parsers.html;

import com.github.programmerr47.chords.api.objects.Chord;
import com.github.programmerr47.chords.api.objects.SongChords;
import com.github.programmerr47.chords.api.objects.SongChordsSummary;

import org.jsoup.nodes.Element;

import java.util.List;

/**
 * Parser for {@link SongChords} based on song page.
 *
 * @author Michael Spitsin
 * @since 2014-11-06
 */
public final class SongParser extends ParserFromHTML<SongChords> {

    private static final String ID_ATTRIBUTE = "id";
    private static final String ITEM_PROP_ATTRIBUTE = "itemprop";
    private static final String URL_ATTRIBUTE = "href";

    private static final String ARTIST_ITEM_PROP = "byArtist";
    private static final String CHORDS_ITEM_PROP = "chordsBlock";
    private static final String TITLE_ITEM_PROP = "name";

    private static final String CLASS = "class";
    private static final String NAVIGATION_BAR_CLASS = "b-nav hidden-phone";

    private static final String ALL_SONG_CHORDS_ID = "song_chords";

    @Override
    protected SongChords parseObjectFromDoc(Element element) {
        if (element == null) {
            return null;
        }

        SongChords.Builder resultObjectBuilder = new SongChords.Builder();

        //Trying to get artist
        Element artist = element.getElementsByAttributeValue(ITEM_PROP_ATTRIBUTE, ARTIST_ITEM_PROP).first();
        if (artist != null) {
            resultObjectBuilder.setArtistName(artist.val());
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
            Element artistUrl = element.children().last();

            if (artistUrl != null) {
                resultObjectBuilder.setArtistUrl(artistUrl.attr(URL_ATTRIBUTE));
            }
        }

        //Trying to get chords
        Element chords = element.getElementsByAttributeValue(ID_ATTRIBUTE, ALL_SONG_CHORDS_ID).first();
        ParserFromHTML<Chord> chordsParser = getChordsParser();
        List<Chord> chordList = chordsParser.parseListFromDoc(chords);
        resultObjectBuilder.setSongChords(chordList);

        //TODO finish

        return resultObjectBuilder.build();
    }

    @Override
    protected List<SongChords> parseListFromDoc(Element element) {
        throw new UnsupportedOperationException("Cannot parse list of artist pages");
    }

    /**
     * Used as method for fast and harmless changing of Chords parser.
     *
     * @return song chords summary parser
     */
    private ParserFromHTML<Chord> getChordsParser() {
        return new ChordsParser();
    }
}
