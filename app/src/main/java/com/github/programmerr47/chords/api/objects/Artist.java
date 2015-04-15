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
    private List<SongSummary> chords;

    private Artist(Builder builder) {
        this.artistName = builder.artistName;
        this.artistArtUrl = builder.artistArtUrl;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Artist artist = (Artist) o;

        return artistName.equals(artist.artistName);
    }

    @Override
    public int hashCode() {
        return artistName.hashCode();
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistName='" + artistName + '\'' +
                ", artistArtUrl='" + artistArtUrl + '\'' +
                ", chords=" + chords +
                '}';
    }

    @SuppressWarnings("unused")
    public List<SongSummary> getChords() {
        return chords;
    }

    public static final class Builder {
        private String artistName;
        private String artistArtUrl;
        private List<SongSummary> chords;

        public Builder setArtistName(String artistName) {
            this.artistName = artistName;
            return this;
        }

        public Builder setArtistArtUrl(String artistArtUrl) {
            this.artistArtUrl = artistArtUrl;
            return this;
        }

        public Builder setChords(List<SongSummary> chords) {
            this.chords = chords;
            return this;
        }

        public Artist build() {
            return new Artist(this);
        }
    }
}
