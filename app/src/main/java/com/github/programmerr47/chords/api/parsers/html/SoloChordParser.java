package com.github.programmerr47.chords.api.parsers.html;

import com.github.programmerr47.chords.api.objects.Chord;

import org.jsoup.nodes.Element;

/**
 * Additional to {@link SongParser} parser for {@link Chord} from song page.
 * <br><br>
 * <strong>Note:</strong>
 * This parser parses only one chord from list of chords, that stored in song page
 * and return only one instance of {@link Chord}. So default purpose of this parser
 * is being used by {@link ChordsParser}, that must parse entire list of chords.
 *
 * @author Michael Spitsin
 * @since 2014-11-06
 */
public final class SoloChordParser extends ParserFromHTML<Chord> {

    private static final String CHORD_TAG = "img";

    private static final String CHORD_IMAGE_URL_ATTRIBUTE = "src";
    private static final String CHORD_NAME_ATTRIBUTE = "alt";

    @Override
    protected Chord parseObjectFromDoc(Element element) {
        if ((element == null) || !CHORD_TAG.equals(element.tagName())) {
            return null;
        }

        Chord.Builder resultObjectBuilder = new Chord.Builder();

        //Getting url to image representation of chord
        String imageUrl = element.attr(CHORD_IMAGE_URL_ATTRIBUTE);
        //Getting full description for chord
        String description = element.attr(CHORD_NAME_ATTRIBUTE);
        String name = getNameChordFromDescription(description);

        resultObjectBuilder
                .setImageUrl(imageUrl)
                .setName(name);

        return resultObjectBuilder.build();
    }

    /**
     * Parses description, that always is "Аккорд 'name of chord'".
     * Yea, it is hardcode. But all off this html parses is hardcode.
     * So it is allocated in some function for fast changing if html
     * layout will be changed.
     *
     * @param description chords description
     * @return only chords name
     */
    private String getNameChordFromDescription(String description) {
        String[] words = description.split(" ");
        return words[1];
    }
}
