package com.github.programmerr47.chords.api.methods;

import android.util.Log;

import com.github.programmerr47.chords.api.objects.Artist;
import com.github.programmerr47.chords.api.objects.responses.ApiMethodResponse;
import com.github.programmerr47.chords.api.parsers.html.ArtistParser;

import junit.framework.TestCase;

/**
 * @author MichaelSpitsin
 * @since 2015-03-20
 */
public class ApiGetMethodTest extends TestCase{

    @Override
    public void setUp() throws Exception {

    }

    @Override
    public void tearDown() throws Exception {

    }

    public void testConnectionAndParseArtistPage() throws Exception {
        ApiGetMethod<Artist> getArtistMethod = new ApiGetMethod<>();
        getArtistMethod.setFullUrlWithoutParams("http://amdm.ru/akkordi/kino/");
        getArtistMethod.setMethodResultParser(new ArtistParser());
        ApiMethodResponse<Artist> response = getArtistMethod.execute();

        if (response.isResponseValid()) {
            Log.d("TESTING", "Artist response is valid with object: " + response.getResponseObject());
        } else {
            Log.d("TESTING", "Artist response is not valid, because of reason: " + response.getReason());
        }
    }
}
