package com.github.programmerr47.chords.api.parsers.html;

import com.github.programmerr47.chords.api.objects.Artist;
import com.github.programmerr47.chords.api.objects.SongChordsSummary;

import org.jsoup.nodes.Element;

import java.util.List;

/**
 * Parser for {@link Artist} based of HTML artist page.
 *
 * @author Michael Spitsin
 * @since 2014-10-31
 */
public final class ArtistParser extends ParserFromHTML<Artist> {

    private static final String ARTIST_ART_TAG = "img";
    private static final String ARTIST_TITLE_TAG = "h1";

    private static final String ARTIST_INFO_CLASS = "artist-profile__info";
    private static final String ARTIST_CHORDS_CLASS = "items";

    private static final String ARTIST_ART_ATTRIBUTE = "src";

    private static final String CONTENT = "content-table";

    @Override
    protected Artist parseObjectFromDoc(Element element) {
        if (element == null) {
            return null;
        }

        Artist.Builder resultObjectBuilder = new Artist.Builder();
        Element content = element.getElementsByClass(CONTENT).first();

        //Trying to get artist title
        Element artistInfo = content.getElementsByClass(ARTIST_INFO_CLASS).first();
        if (artistInfo != null) {
            Element artistTitleElement = artistInfo.getElementsByTag(ARTIST_TITLE_TAG).first();
            if (artistTitleElement != null) {
                String artistTitle = artistTitleElement.text();
                resultObjectBuilder.setArtistName(artistTitle);
            }
        }

        //Trying to get artist art
        Element image = content.getElementsByTag(ARTIST_ART_TAG).first();
        if (image != null) {
            String url = image.attr(ARTIST_ART_ATTRIBUTE);
            resultObjectBuilder.setArtistArtUrl(url);
        }

        //Trying to get list of chords
        Element items = content.getElementsByClass(ARTIST_CHORDS_CLASS).first();
        ParserFromHTML<SongChordsSummary> songChordsSummaryParser = getSongChordsSummaryParser();
        List<SongChordsSummary> parsingResult = songChordsSummaryParser.parseListFromDoc(items);
        resultObjectBuilder.setChords(parsingResult);

        return resultObjectBuilder.build();
    }

    @Override
    protected List<Artist> parseListFromDoc(Element element) {
        throw new UnsupportedOperationException("Cannot parse list of artist pages");
    }

    /**
     * Used as method for fast and harmless changing of SongChords parser.
     *
     * @return song chords summary parser
     */
    private ParserFromHTML<SongChordsSummary> getSongChordsSummaryParser() {
        return new ArtistSongChordsSummaryParser();
    }
}
