package com.github.programmerr47.chords.api.objects;

/**
 * //TODO descr
 * @author Michael Spitsin
 * @since 2014-11-06
 */
public final class Chord {
    private final String name;
    private final String imageUrl;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chord chord = (Chord) o;

        return name.equals(chord.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Chord{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
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
