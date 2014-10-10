package com.github.programmerr47.chords.representation.adapters.elements.drawer;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.programmerr47.chords.R;
import com.github.programmerr47.chords.representation.Constants;

/**
 * Represents drawer elements that show primary pages (New chords, Popular chords/artists and etc).
 *
 * @author Michael Spitsin
 * @since 2014-10-10
 */
public final class DrawerPrimaryElement extends DrawerElement {

    private static final int LAYOUT_ID = R.layout.drawer_item_primary;

    private Typeface selectedStateTypeface;
    private Typeface defaultStateTypeface;

    public DrawerPrimaryElement(Context context, DrawerElementName type) {
        super(context, type);

        selectedStateTypeface = Typeface.createFromAsset(mContext.getAssets(), Constants.ASSETS_FONTS_DIR + Constants.ROBOTO_BOLD);
        selectedStateTypeface = Typeface.createFromAsset(mContext.getAssets(), Constants.ASSETS_FONTS_DIR + Constants.ROBOTO_REGULAR);
    }

    @Override
    public View newView(ViewGroup parent, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(LAYOUT_ID, parent, false);

        if (view == null) {
            throw new IllegalStateException("View not created");
        }

        ViewHolder holder = new ViewHolder();
        holder.icon = (ImageView) view.findViewById(R.id.icon);
        holder.title = (TextView) view.findViewById(R.id.title);
        view.setTag(holder);

        return view;
    }

    @Override
    public void bindView(View view, int position) {
        if (view.getTag() == null) {
            throw new IllegalArgumentException("View must contain its own holder");
        }

        ViewHolder holder = (ViewHolder) view.getTag();
        //TODO finish
    }

    /**
     * @author Michael Spitsin
     * @since 2014-10-10
     */
    public static class ViewHolder {
        private ImageView icon;
        private TextView title;
    }
}
