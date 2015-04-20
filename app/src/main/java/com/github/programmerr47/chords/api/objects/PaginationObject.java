package com.github.programmerr47.chords.api.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Common class for representing all list-responses from amdm-html-'api'.
 * Simply contains list of {@code <{@link ResponseObject}>} and pack of urls
 * to next or previous pages.
 *
 * @author MichaelSpitsin
 * @since 2015-04-17
 */
public class PaginationObject<ResponseObject> {
    private final PaginationUrls paginationUrls;
    private final List<ResponseObject> objects = new ArrayList<>();

    private PaginationObject(Builder<ResponseObject> builder) {
        this.paginationUrls = builder.paginationUrls;
        Collections.copy(objects, builder.objects);
    }

    @SuppressWarnings("unused")
    public PaginationUrls getPaginationUrls() {
        return paginationUrls;
    }

    @SuppressWarnings("unused")
    public List<ResponseObject> getObjects() {
        return objects;
    }

    @Override
    public String toString() {
        return "PaginationObject{" +
                "paginationUrls=" + paginationUrls +
                ", objects=" + objects +
                '}';
    }

    public static final class Builder<ResponseObject> {
        private PaginationUrls paginationUrls;
        private List<ResponseObject> objects;

        public Builder setObjects(List<ResponseObject> objects) {
            this.objects = objects;
            return this;
        }

        public Builder setPaginationUrls(PaginationUrls paginationUrls) {
            this.paginationUrls = paginationUrls;
            return this;
        }

        public PaginationObject<ResponseObject> build() {
            return new PaginationObject<>(this);
        }
    }
}
