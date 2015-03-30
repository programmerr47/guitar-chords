package com.github.programmerr47.chords.api.methods;

import com.github.programmerr47.chords.api.objects.Artist;
import com.github.programmerr47.chords.api.objects.Song;
import com.github.programmerr47.chords.api.objects.responses.ApiMethodResponse;
import com.github.programmerr47.chords.api.parsers.html.ArtistParser;
import com.github.programmerr47.chords.api.parsers.html.SongParser;

import junit.framework.TestCase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

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

        assertTrue(response.isResponseValid());

        Artist artist = response.getResponseObject();

        assertEquals(artist.getArtistName(), "Виктор Цой");
        assertEquals(artist.getArtistArtUrl(), "//amdm.ru/images/artist/250/588.jpg");
    }

    public void testConnectionAndParseChordsPage() throws Exception {
        ApiGetMethod<Song> getChordsMethod = new ApiGetMethod<>();
        getChordsMethod.setFullUrlWithoutParams("http://amdm.ru/akkordi/kino/95023/pachka_sigaret/");
        getChordsMethod.setMethodResultParser(new SongParser());
        ApiMethodResponse<Song> response = getChordsMethod.execute();

        assertTrue(response.isResponseValid());

        Song song = response.getResponseObject();

        assertEquals(song.getArtistName(), "Виктор Цой");
        assertEquals(song.getSongName(), "Пачка сигарет");


        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        Date date = dateFormat.parse("20.09.2011");
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        assertEquals(song.getCreationDate(), calendar);
    }
}
