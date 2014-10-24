package com.github.programmerr47.chords.api.objects;

/**
 * Class-info, result of request of artist biography. Contains info such biography text,
 * artist art, artist name.
 *
 * @author Michael Spitsin
 * @since 2014-10-24
 */
public final class ArtistBiography {
    private String artistName;
    private String artistArt;
    private String biographyText;

    private ArtistBiography(Builder builder) {
        this.artistName = builder.artistName;
        this.artistArt = builder.artistArt;
        this.biographyText = builder.biographyText;
    }

    @SuppressWarnings("unused")
    public String getArtistName() {
        return artistName;
    }

    @SuppressWarnings("unused")
    public String getArtistArt() {
        return artistArt;
    }

    @SuppressWarnings("unused")
    public String getBiographyText() {
        return biographyText;
    }

    public static final class Builder {
        private String artistName;
        private String artistArt;
        private String biographyText;

        public Builder setArtistName(String artistName) {
            this.artistName = artistName;
            return this;
        }

        public Builder setArtistArt(String artistArt) {
            this.artistArt = artistArt;
            return this;
        }

        public Builder setBiographyText(String biographyText) {
            this.biographyText = biographyText;
            return this;
        }

        public ArtistBiography build() {
            return new ArtistBiography(this);
        }
    }
}
