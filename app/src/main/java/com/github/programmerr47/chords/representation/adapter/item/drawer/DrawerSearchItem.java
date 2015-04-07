package com.github.programmerr47.chords.representation.adapter.item.drawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.github.programmerr47.chords.R;
import com.github.programmerr47.chords.representation.adapter.holder.drawer.DrawerSearchItemHolder;
import com.github.programmerr47.chords.representation.adapter.holder.drawer.DrawerStandardItemHolder;
import com.github.programmerr47.chords.representation.adapter.holder.producer.DrawerSecondaryItemHolderProducer;
import com.github.programmerr47.chords.representation.adapter.holder.producer.HolderProducer;

/**
 * Search element of drawer, that represents simple {@link EditText}. Can search artist, songs.
 * After typing and pressing button redirects to SearchResultPage.
 *
 * @author Michael Spitsin
 * @since 2014-10-13
 */
public final class DrawerSearchItem extends DrawerItem {

    private static final int LAYOUT_ID = R.layout.drawer_item_search;

    private DrawerSearchItem(Builder builder) {
        super(builder);
    }

    @Override
    public void bindView(RecyclerView.ViewHolder viewHolder, int position) {
        DrawerSearchItemHolder holder = (DrawerSearchItemHolder) viewHolder;
        bindView(holder, isSelected);
    }

    @Override
    public HolderProducer getViewHolderProducer() {
        return new DrawerSecondaryItemHolderProducer(mContext);
    }

    @Override
    public void bindView(View view, int position) {
        if (view.getTag() == null) {
            throw new IllegalArgumentException("View must contain its own holder");
        }

        final EditText searchField = (EditText) view.getTag();
        searchField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                boolean handled = false;

                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    if (onSearchListener != null) {
                        onSearchListener.onSearchStarted(textView.getText().toString());
                    }
                    handled = true;
                }

                return handled;
            }
        });

        searchField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    searchField.setText("");

                    InputMethodManager inputMethodManager =  (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(searchField.getWindowToken(), 0);
                } else {
                    InputMethodManager inputMethodManager = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.showSoftInput(searchField, InputMethodManager.SHOW_IMPLICIT);
                }
            }
        });
    }

    @Override
    protected void setViewSelected() {
        //ignore
    }

    /**
     * @author Michael Spitsin
     * @since 2014-10-13
     */
    public static final class Builder extends DrawerItem.Builder {

        public Builder(@NonNull Context context) {
            super(context);
        }

        @Override
        public DrawerSearchItem build() {
            return new DrawerSearchItem(this);
        }
    }
}
