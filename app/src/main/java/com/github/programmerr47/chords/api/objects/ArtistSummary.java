package com.github.programmerr47.chords.api.objects;

/**
 * Class-info, result of request of artist summary info. Keeps all base and service information
 * like title, url to artist, number of views, number of chords.
 *
 * @author Michael Spitsin
 * @since 2014-10-24
 */
public final class ArtistSummary {
    private String artistName;
    private String artistUrl;
    private String coverThumbUrl;
    private int numberOfViews;
    private int numberOfChords;

    private ArtistSummary(Builder builder) {
        this.artistName = builder.artistName;
        this.artistUrl = builder.artistUrl;
        this.coverThumbUrl = builder.coverThumbUrl;
        this.numberOfViews = builder.numberOfViews;
        this.numberOfChords = builder.numberOfChords;
    }

    @SuppressWarnings("unused")
    public String getArtistName() {
        return artistName;
    }

    @SuppressWarnings("unused")
    public String getArtistUrl() {
        return artistUrl;
    }

    @SuppressWarnings("unused")
    public String getCoverThumbUrl() {
        return coverThumbUrl;
    }

    @SuppressWarnings("unused")
    public int getNumberOfViews() {
        return numberOfViews;
    }

    @SuppressWarnings("unused")
    public int getNumberOfChords() {
        return numberOfChords;
    }

    public static final class Builder {
        private String artistName;
        private String artistUrl;
        private String coverThumbUrl;
        private int numberOfViews;
        private int numberOfChords;

        public Builder setArtistName(String artistName) {
            this.artistName = artistName;
            return this;
        }

        public Builder setArtistUrl(String artistUrl) {
            this.artistUrl = artistUrl;
            return this;
        }

        public Builder setCoverThumbUrl(String coverThumbUrl) {
            this.coverThumbUrl = coverThumbUrl;
            return this;
        }

        public Builder setNumberOfViews(int numberOfViews) {
            this.numberOfViews = numberOfViews;
            return this;
        }

        public Builder setNumberOfChords(int numberOfChords) {
            this.numberOfChords = numberOfChords;
            return this;
        }

        public ArtistSummary build() {
            return new ArtistSummary(this);
        }
    }
}
