package com.github.programmerr47.chords.api.objects;

/**
 * Class-info, result of request of song summary info. Keeps all base and service information
 * like title, url to chords, number of views. As optional there is date of additional to site
 * and e.t.c
 *
 * @author Michael Spitsin
 * @since 2014-10-24
 */
//TODO Add artist url if has
public final class SongChordsSummary {
    private String songName;
    private String artistName;
    private String chordsUrl;
    private String coverThumbUrl;
    //---Optional params---//
    private boolean isNew;
    private boolean hasVideo;
    private int numberOfViews;

    private SongChordsSummary(Builder builder) {
        this.songName = builder.songName;
        this.artistName = builder.artistName;
        this.chordsUrl = builder.chordsUrl;
        this.coverThumbUrl = builder.coverThumbUrl;
        this.isNew = builder.isNew;
        this.hasVideo = builder.hasVideo;
        this.numberOfViews = builder.numberOfViews;
    }

    @SuppressWarnings("unused")
    public String getSongName() {
        return songName;
    }

    @SuppressWarnings("unused")
    public String getArtistName() {
        return artistName;
    }

    @SuppressWarnings("unused")
    public String getChordsUrl() {
        return chordsUrl;
    }

    public String getCoverThumbUrl() {
        return coverThumbUrl;
    }

    public boolean isNew() {
        return isNew;
    }

    @SuppressWarnings("unused")
    public boolean hasVideo() {
        return hasVideo;
    }

    @SuppressWarnings("unused")
    public int getNumberOfViews() {
        return numberOfViews;
    }

    public static final class Builder {
        private String songName;
        private String artistName;
        private String chordsUrl;
        private String coverThumbUrl;
        private boolean isNew;
        private boolean hasVideo;
        private int numberOfViews;

        public Builder setSongName(String songName) {
            this.songName = songName;
            return this;
        }

        public Builder setArtistName(String artistName) {
            this.artistName = artistName;
            return this;
        }

        public Builder setChordsUrl(String chordsUrl) {
            this.chordsUrl = chordsUrl;
            return this;
        }

        public Builder setCoverThumbUrl(String coverThumbUrl) {
            this.coverThumbUrl = coverThumbUrl;
            return this;
        }

        public Builder setIsNew(boolean isNew) {
            this.isNew = isNew;
            return this;
        }

        public Builder setHasVideo(boolean hasVideo) {
            this.hasVideo = hasVideo;
            return this;
        }

        public Builder setNumberOfViews(int numberOfViews) {
            this.numberOfViews = numberOfViews;
            return this;
        }

        public SongChordsSummary build() {
            return new SongChordsSummary(this);
        }
    }
}
