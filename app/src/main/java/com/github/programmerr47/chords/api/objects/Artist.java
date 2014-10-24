package com.github.programmerr47.chords.api.objects;

import java.util.List;

/**
 * Class-info, result of request of concrete artist. Keeps all base needed info like
 * artist art, biography, list of chords and e.t.c
 *
 * @author Michael Spitsin
 * @since 2014-10-24
 */
public final class Artist {
    private String artistName;
    private String artistArtUrl;
    private String shortBiography;
    private String biographyUrl;
    private List<SongChordsSummary> chords;

    private Artist(Builder builder) {
        this.artistName = builder.artistName;
        this.artistArtUrl = builder.artistArtUrl;
        this.shortBiography = builder.shortBiography;
        this.biographyUrl = builder.biographyUrl;
        this.chords = builder.chords;
    }

    @SuppressWarnings("unused")
    public String getArtistName() {
        return artistName;
    }

    @SuppressWarnings("unused")
    public String getArtistArtUrl() {
        return artistArtUrl;
    }

    @SuppressWarnings("unused")
    public String getShortBiography() {
        return shortBiography;
    }

    @SuppressWarnings("unused")
    public String getBiographyUrl() {
        return biographyUrl;
    }

    @SuppressWarnings("unused")
    public List<SongChordsSummary> getChords() {
        return chords;
    }

    public static final class Builder {
        private String artistName;
        private String artistArtUrl;
        private String shortBiography;
        private String biographyUrl;
        private List<SongChordsSummary> chords;

        public Builder setArtistName(String artistName) {
            this.artistName = artistName;
            return this;
        }

        public Builder setArtistArtUrl(String artistArtUrl) {
            this.artistArtUrl = artistArtUrl;
            return this;
        }

        public Builder setShortBiography(String shortBiography) {
            this.shortBiography = shortBiography;
            return this;
        }

        public Builder setBiographyUrl(String biographyUrl) {
            this.biographyUrl = biographyUrl;
            return this;
        }

        public Builder setChords(List<SongChordsSummary> chords) {
            this.chords = chords;
            return this;
        }

        public Artist build() {
            return new Artist(this);
        }
    }
}
