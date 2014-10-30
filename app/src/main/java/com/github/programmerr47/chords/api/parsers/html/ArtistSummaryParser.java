package com.github.programmerr47.chords.api.parsers.html;

import com.github.programmerr47.chords.api.objects.ArtistSummary;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Parser for {@link ArtistSummary} that uses as source now only "popular artists" page.
 *
 * @author Michael Spitsin
 * @since 2014-10-30
 */
public class ArtistSummaryParser extends ParserFromHTML<ArtistSummary> {

    private static final String ITEMS_TAG = "table";
    private static final String ITEMS_BODY_TAG = "tbody";
    private static final String ITEM_TAG = "tr";
    private static final String IMAGE_TAG = "img";

    private static final String ITEMS_CLASS = "items";
    private static final String ITEM_INFO_CLASS = "artist_name";
    private static final String ARTIST_CLASS = "artist";
    private static final String NEW_FLAG_CLASS = "flag flag_new";
    private static final String NUMBER_CLASS = "number";

    private static final String IMAGE_SOURCE_ATTRIBUTE = "src";
    private static final String URL_ATTRIBUTE = "href";

    @Override
    protected ArtistSummary parseObjectFromDoc(Element element) {
        if ((element == null) || !ITEM_TAG.equals(element.tagName())) {
            return null;
        }

        ArtistSummary.Builder resultObjectBuilder = new ArtistSummary.Builder();
        resultObjectBuilder.setCoverThumbUrl(getItemImageUrl(element));

        Element chordsInfo = element.getElementsByClass(ITEM_INFO_CLASS).first();

        if (chordsInfo != null) {
            parseInfo(chordsInfo, resultObjectBuilder);
        }

        parserNumbers(element, resultObjectBuilder);

        return resultObjectBuilder.build();
    }

    @Override
    protected List<ArtistSummary> parseListFromDoc(Element element) {
        if (element == null) {
            return null;
        }

        List<ArtistSummary> result = new ArrayList<ArtistSummary>();
        Elements tables = element.getElementsByTag(ITEMS_TAG);

        for (Element table : tables) {
            if (ITEMS_CLASS.equals(table.className())) {
                Element tbody = table.getElementsByTag(ITEMS_BODY_TAG).first();

                if (tbody != null) {
                    Elements items = tbody.children();

                    for (Element item : items) {
                        ArtistSummary itemObject = parseObjectFromDoc(item);

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

    private void parseInfo(Element chordsInfo, ArtistSummary.Builder resultObjectBuilder) {
        Element artist = chordsInfo.getElementsByClass(ARTIST_CLASS).first();
        String chordsUrl = artist.attr(URL_ATTRIBUTE);
        String artistName = artist.val();

        resultObjectBuilder
                .setArtistName(artistName)
                .setArtistUrl(chordsUrl);
    }

    private void parserNumbers(Element item, ArtistSummary.Builder resultObjectBuilder) {
        Elements numbers = item.getElementsByClass(NUMBER_CLASS);
        int numbersLength = numbers.size();

        //Trying to get number of chords
        if (numbersLength > 0) {
            int countOfChords = 0;
            try {
                countOfChords = Integer.parseInt(numbers.get(0).val());
            } catch (NumberFormatException e) {
                //ignore
            }
            resultObjectBuilder.setNumberOfChords(countOfChords);
        }

        //Trying to get number of views
        if (numbersLength > 1) {
            int countOfViews = 0;
            try {
                countOfViews = Integer.parseInt(numbers.get(1).val());
            } catch (NumberFormatException e) {
                //ignore
            }
            resultObjectBuilder.setNumberOfViews(countOfViews);
        }
    }
}
