package com.github.programmerr47.chords.api.objects;

/**
 * Class-info, result of request of artist summary info. Keeps all base and service information
 * like title, url to artist, number of views, number of chords.
 *
 * @author Michael Spitsin
 * @since 2014-10-24
 */
public final class ArtistSummary {
    private final String artistName;
    private final String artistUrl;
    private final String coverThumbUrl;
    private final int numberOfViews;
    private final int numberOfChords;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistSummary artistSummary = (ArtistSummary) o;

        return artistName.equals(artistSummary.artistName);
    }

    @Override
    public int hashCode() {
        return artistName.hashCode();
    }

    @Override
    public String toString() {
        return "ArtistSummary{" +
                "artistName='" + artistName + '\'' +
                ", artistUrl='" + artistUrl + '\'' +
                ", coverThumbUrl='" + coverThumbUrl + '\'' +
                ", numberOfViews=" + numberOfViews +
                ", numberOfChords=" + numberOfChords +
                '}';
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
