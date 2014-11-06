package com.github.programmerr47.chords.api.objects;

/**
 * //TODO descr
 * @author Michael Spitsin
 * @since 2014-11-06
 */
public final class Chord {
    private String name;
    private String imageUrl;

    private Chord(Builder builder) {
        this.name = builder.name;
        this.imageUrl = builder.imageUrl;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public String getImageUrl() {
        return imageUrl;
    }

    public static final class Builder {
        private String name;
        private String imageUrl;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Chord build() {
            return new Chord(this);
        }
    }
}
