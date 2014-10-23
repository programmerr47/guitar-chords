package com.github.programmerr47.chords.api.objects;

import com.github.programmerr47.chords.api.utils.AvailableChords;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Class-info, result of request to chords of concrete song. Keeps all base needed info like
 * text, list of chords, important urls.
 *
 * @author Michael Spitsin
 * @since 2014-10-23
 */
public final class SongChords {
    private List<AvailableChords> songChords;
    private String textWithChords;
    private String artistName;
    private String songName;
    private String artistUrl;
    private String videoUrl;
    private GregorianCalendar creationDate;

    private SongChords(Builder builder) {
        this.songChords = builder.songChords;
        this.textWithChords = builder.textWithChords;
        this.artistName = builder.artistName;
        this.songName = builder.songName;
        this.artistUrl = builder.artistUrl;
        this.videoUrl = builder.videoUrl;
        this.creationDate = builder.creationDate;
    }

    @SuppressWarnings("unused")
    public List<AvailableChords> getSongChords() {
        return songChords;
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
    public GregorianCalendar getCreationDate() {
        return creationDate;
    }

    public static final class Builder {
        private List<AvailableChords> songChords;
        private String textWithChords;
        private String artistName;
        private String songName;
        private String artistUrl;
        private String videoUrl;
        private GregorianCalendar creationDate;

        public Builder setSongChords(List<AvailableChords> songChords) {
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
            this.creationDate = new GregorianCalendar(year, month, day);
            return this;
        }

        public Builder setCreationDate(GregorianCalendar creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public SongChords build() {
            return new SongChords(this);
        }
    }
}
