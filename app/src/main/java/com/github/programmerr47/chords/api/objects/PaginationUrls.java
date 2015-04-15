package com.github.programmerr47.chords.api.objects;

/**
 * Class-info. Keeps all base information about urls related to pages.
 *
 * @author Michael Spitsin
 * @since 2014-10-24
 */
public final class PaginationUrls {
    private final String prevUrl;
    private final String nextUrl;

    private PaginationUrls(Builder builder) {
        this.prevUrl = builder.prevUrl;
        this.nextUrl = builder.nextUrl;
    }

    @SuppressWarnings("unused")
    public String getPrevUrl() {
        return prevUrl;
    }

    @SuppressWarnings("unused")
    public String getNextUrl() {
        return nextUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaginationUrls that = (PaginationUrls) o;

        if (nextUrl != null ? !nextUrl.equals(that.nextUrl) : that.nextUrl != null) return false;
        if (prevUrl != null ? !prevUrl.equals(that.prevUrl) : that.prevUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prevUrl != null ? prevUrl.hashCode() : 0;
        result = 31 * result + (nextUrl != null ? nextUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PaginationUrls{" +
                "prevUrl='" + prevUrl + '\'' +
                ", nextUrl='" + nextUrl + '\'' +
                '}';
    }

    public static final class Builder {
        private String prevUrl;
        private String nextUrl;

        public Builder setPrevUrl(String prevUrl) {
            this.prevUrl = prevUrl;
            return this;
        }

        public Builder setNextUrl(String nextUrl) {
            this.nextUrl = nextUrl;
            return this;
        }

        public PaginationUrls build() {
            return new PaginationUrls(this);
        }
    }
}
