package com.github.programmerr47.chords.representation.adapter.holder.drawer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Standard view holder for all simple search items of any
 * {@link android.support.v7.widget.RecyclerView}. Simply
 * contains icon of search and search field.
 *
 * @author Michael Spitsin
 * @since 2015-04-07
 */
public class SearchItemHolder extends RecyclerView.ViewHolder {

    private ImageView mIcon;
    private EditText mSearchField;

    public SearchItemHolder(View itemView, ResourceParams params) {
        super(itemView);

        mIcon = (ImageView) itemView.findViewById(params.iconLayoutId);
        mSearchField = (EditText) itemView.findViewById(params.searchFieldLayoutId);
    }

    public ImageView getIcon() {
        return mIcon;
    }

    public EditText getSearchField() {
        return mSearchField;
    }

    public static final class ResourceParams {
        public int iconLayoutId;
        public int searchFieldLayoutId;
    }
}
