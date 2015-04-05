package com.github.programmerr47.chords.representation.adapters.element.drawer;

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
 * Represents drawer elements that show secondary pages (About).
 *
 * @author Michael Spitsin
 * @since 2014-10-12
 */
public final class DrawerSecondaryItem extends DrawerItem {

    private static final int LAYOUT_ID = R.layout.drawer_item_secondary;

    private Typeface selectedStateTypeface;
    private Typeface defaultStateTypeface;

    private int iconResId;
    private int titleResId;

    private ViewHolder holder;

    private DrawerSecondaryItem(Builder builder) {
        super(builder);

        this.iconResId = builder.iconResId;
        this.titleResId = builder.titleResId;

        selectedStateTypeface = Typeface.createFromAsset(mContext.getAssets(), Constants.ASSETS_FONTS_DIR + Constants.ROBOTO_BOLD);
        defaultStateTypeface = Typeface.createFromAsset(mContext.getAssets(), Constants.ASSETS_FONTS_DIR + Constants.ROBOTO_REGULAR);
    }

    @Override
    public View newView(ViewGroup parent, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(LAYOUT_ID, parent, false);

        if (view == null) {
            throw new IllegalStateException("View not created");
        }

        holder = new ViewHolder();
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
        bindView(holder, isSelected);
    }

    @Override
    protected void setViewSelected() {
        if (holder != null) {
            bindView(holder, isSelected);
        }
    }

    private void bindView(ViewHolder holder, boolean isSelected) {
        holder.icon.setImageResource(iconResId);
        holder.title.setText(titleResId);

        holder.icon.setSelected(isSelected);

        if (isSelected) {
            holder.title.setTypeface(selectedStateTypeface);
        } else {
            holder.title.setTypeface(defaultStateTypeface);
        }
    }

    /**
     * @author Michael Spitsin
     * @since 2014-10-12
     */
    public static final class ViewHolder {
        private ImageView icon;
        private TextView title;
    }

    /**
     * @author Michael Spitsin
     * @since 2014-10-12
     */
    public static final class Builder extends DrawerItem.Builder {
        private int iconResId;
        private int titleResId;

        public Builder(Context context) {
            super(context);
        }

        public Builder setIcon(int iconResId) {
            this.iconResId = iconResId;
            return this;
        }

        public Builder setTitle(int titleResId) {
            this.titleResId = titleResId;
            return this;
        }

        @Override
        public DrawerSecondaryItem build() {
            return new DrawerSecondaryItem(this);
        }
    }
}
