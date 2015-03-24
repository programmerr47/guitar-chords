package com.github.programmerr47.chords.api.methods;

import com.github.programmerr47.chords.api.objects.Artist;
import com.github.programmerr47.chords.api.objects.SongChords;
import com.github.programmerr47.chords.api.objects.responses.ApiMethodResponse;
import com.github.programmerr47.chords.api.parsers.html.ArtistPageParser;
import com.github.programmerr47.chords.api.parsers.html.SongPageParser;

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
        getArtistMethod.setMethodResultParser(new ArtistPageParser());
        ApiMethodResponse<Artist> response = getArtistMethod.execute();
        //TODO add assertion
    }

    public void testConnectionAndParseChordsPage() throws Exception {
        ApiGetMethod<SongChords> getChordsMethod = new ApiGetMethod<>();
        getChordsMethod.setFullUrlWithoutParams("http://amdm.ru/akkordi/kino/95023/pachka_sigaret/");
        getChordsMethod.setMethodResultParser(new SongPageParser());
        ApiMethodResponse<SongChords> response = getChordsMethod.execute();
        //TODO add assertion
    }
}
