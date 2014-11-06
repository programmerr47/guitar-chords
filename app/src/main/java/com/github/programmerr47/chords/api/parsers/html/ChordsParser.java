package com.github.programmerr47.chords.api.parsers.html;

import com.github.programmerr47.chords.api.objects.ArtistSummary;
import com.github.programmerr47.chords.api.objects.Chord;
import com.github.programmerr47.chords.api.parsers.ParserFrom;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Additional to {@link SongParser} parser for {@link Chord} from song page.
 *
 * @author Michael Spitsin
 * @since 2014-11-06
 */
public final class ChordsParser extends ParserFromHTML<Chord>{

    private static final String CHORD_TAG = "img";
    private static final String CHORDS_TAG = "div";

    private static final String CHORDS_ATTRIBUTE = "id";
    private static final String CHORD_IMAGE_URL_ATTRIBUTE = "src";
    private static final String CHORD_NAME_ATTRIBUTE = "alt";

    private static final String CHORDS_IDENTIFICATOR = "song_chords";

    @Override
    protected Chord parseObjectFromDoc(Element element) {
        if ((element == null) || !CHORD_TAG.equals(element.tagName())) {
            return null;
        }

        Chord.Builder resultObjectBuilder = new Chord.Builder();

        //Getting url to image representation of chord
        String imageUrl = element.attr(CHORD_IMAGE_URL_ATTRIBUTE);
        //Getting full description for chord
        String descr = element.attr(CHORD_NAME_ATTRIBUTE);
        String name = getNameChordFromDescription(descr);

        resultObjectBuilder
                .setImageUrl(imageUrl)
                .setName(name);

        return resultObjectBuilder.build();
    }

    @Override
    protected List<Chord> parseListFromDoc(Element element) {
        if (element == null) {
            return null;
        }

        List<Chord> result = new ArrayList<Chord>();
        Element chords = element.getElementsByTag(CHORDS_TAG).first();

        if ((chords != null) && isChordsValid(chords)) {
            Elements items = chords.children();

            for (Element item : items) {
                Chord itemObject = parseObjectFromDoc(item);

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
     * Parses description, that always is "Аккорд 'name of chord'".
     * Yea, it is hardcode. But all off this html parses is hardcode.
     * So it is allocated in some function for fast changing if html
     * layout will be changed.
     *
     * @param description
     * @return
     */
    private String getNameChordFromDescription(String description) {
        String[] words = description.split(" ");
        return words[1];
    }
}
