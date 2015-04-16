package com.github.programmerr47.chords.api.objects;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Class-info, result of request to chords of concrete song. Keeps all base needed info like
 * text, list of chords, important urls.
 *
 * @author Michael Spitsin
 * @since 2014-10-23
 */
public final class Song {
    private final List<Chord> songChords;
    private final String textWithChords;
    private final String artistName;
    private final String songName;
    private final String artistUrl;
    private final String videoUrl;
    private final long creationDate;
    private final int numberOfViews;

    private Song(Builder builder) {
        this.songChords = builder.songChords;
        this.textWithChords = builder.textWithChords;
        this.artistName = builder.artistName;
        this.songName = builder.songName;
        this.artistUrl = builder.artistUrl;
        this.videoUrl = builder.videoUrl;
        this.creationDate = builder.creationDate;
        this.numberOfViews = builder.numberOfViews;
    }

    @SuppressWarnings("unused")
    public List<Chord> getSongChords() {
        return Collections.unmodifiableList(songChords);
    }

    @SuppressWarnings("unused")
    public String getTextWithChords() {
        return textWithChords;
    }

    @SuppressWarnings("unused")
    public String getArtistName() {
        return artistName;
    }

    @SuppressWarnings("unused")
    public String getSongName() {
        return songName;
    }

    @SuppressWarnings("unused")
    public String getArtistUrl() {
        return artistUrl;
    }

    @SuppressWarnings("unused")
    public String getVideoUrl() {
        return videoUrl;
    }

    @SuppressWarnings("unused")
    public Date getCreationDate() {
        return new Date(creationDate);
    }

    @SuppressWarnings("unused")
    public int getNumberOfViews() {
        return numberOfViews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song that = (Song) o;

        return artistName.equals(that.artistName) && songName.equals(that.songName);
    }

    @Override
    public int hashCode() {
        int result = artistName.hashCode();
        result = 31 * result + songName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SongChords{" +
                "songChords=" + songChords +
                ", textWithChords='" + textWithChords + '\'' +
                ", artistName='" + artistName + '\'' +
                ", songName='" + songName + '\'' +
                ", artistUrl='" + artistUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", creationDate=" + creationDate +
                ", numberOfViews=" + numberOfViews +
                '}';
    }

    public static final class Builder {
        private List<Chord> songChords;
        private String textWithChords;
        private String artistName;
        private String songName;
        private String artistUrl;
        private String videoUrl;
        private long creationDate;
        private int numberOfViews;

        public Builder setSongChords(List<Chord> songChords) {
            this.songChords = songChords;
            return this;
        }

        public Builder setTextWithChords(String textWithChords) {
            this.textWithChords = textWithChords;
            return this;
        }

        public Builder setArtistName(String artistName) {
            this.artistName = artistName;
            return this;
        }

        public Builder setSongName(String songName) {
            this.songName = songName;
            return this;
        }

        public Builder setArtistUrl(String artistUrl) {
            this.artistUrl = artistUrl;
            return this;
        }

        public Builder setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
            return this;
        }

        public Builder setCreationDate(int year, int month, int day) {
            this.creationDate = new GregorianCalendar(year, month, day).getTimeInMillis();
            return this;
        }

        public Builder setCreationDate(Calendar creationDate) {
            this.creationDate = creationDate.getTimeInMillis();
            return this;
        }

        public Builder setCreationDate(long creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Builder setCreationDate(Date date) {
            this.creationDate = date.getTime();
            return this;
        }

        public Builder setNumberOfViews(int numberOfViews) {
            this.numberOfViews = numberOfViews;
            return this;
        }

        public Song build() {
            return new Song(this);
        }
    }
}
