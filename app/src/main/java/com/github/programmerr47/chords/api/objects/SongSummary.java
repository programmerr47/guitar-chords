package com.github.programmerr47.chords.api.objects;

/**
 * Class-info, result of request of song summary info. Keeps all base and service information
 * like title, url to chords, number of views. As optional there is date of additional to site
 * and e.t.c
 *
 * @author Michael Spitsin
 * @since 2014-10-24
 */
public final class SongSummary {
    private final String songName;
    private final String artistName;
    private final String songUrl;
    private final String coverThumbUrl;
    //---Optional params---//
    private final String artistUrl;
    private final boolean isNew;
    private final boolean hasVideo;
    private final int numberOfViews;

    private SongSummary(Builder builder) {
        this.songName = builder.songName;
        this.artistName = builder.artistName;
        this.songUrl = builder.chordsUrl;
        this.coverThumbUrl = builder.coverThumbUrl;
        this.artistUrl = builder.artistUrl;
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
    public String getSongUrl() {
        return songUrl;
    }

    @SuppressWarnings("unused")
    public String getCoverThumbUrl() {
        return coverThumbUrl;
    }

    @SuppressWarnings("unused")
    public String getArtistUrl() {
        return artistUrl;
    }

    @SuppressWarnings("unused")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SongSummary that = (SongSummary) o;

        return artistName.equals(that.artistName) && songName.equals(that.songName);
    }

    @Override
    public int hashCode() {
        int result = songName.hashCode();
        result = 31 * result + artistName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SongChordsSummary{" +
                "songName='" + songName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", songUrl='" + songUrl + '\'' +
                ", coverThumbUrl='" + coverThumbUrl + '\'' +
                ", isNew=" + isNew +
                ", hasVideo=" + hasVideo +
                ", numberOfViews=" + numberOfViews +
                '}';
    }

    public static final class Builder {
        private String songName;
        private String artistName;
        private String chordsUrl;
        private String coverThumbUrl;
        private String artistUrl;
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

        public Builder setArtistUrl(String artistUrl) {
            this.artistUrl = artistUrl;
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

        public SongSummary build() {
            return new SongSummary(this);
        }
    }
}
