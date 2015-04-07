package com.github.programmerr47.chords.representation.adapter.holder.drawer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by MS on 07.04.2015.
 */
//TODO describe
public class DrawerSearchItemHolder extends RecyclerView.ViewHolder {

    private ImageView mIcon;
    private EditText mSearchField;

    public DrawerSearchItemHolder(View itemView, ResourceParams params) {
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
