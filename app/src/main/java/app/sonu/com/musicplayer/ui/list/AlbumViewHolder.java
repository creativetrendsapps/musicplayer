package app.sonu.com.musicplayer.ui.list;

import android.content.Context;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.v4.media.MediaMetadataCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import app.sonu.com.musicplayer.R;
import app.sonu.com.musicplayer.base.list.BaseViewHolder;
import butterknife.BindView;

/**
 * Created by sonu on 30/7/17.
 */

public class AlbumViewHolder extends BaseViewHolder<AlbumVisitable, AlbumOnClickListener> {

    @LayoutRes
    public static final int LAYOUT = R.layout.item_album;

    @BindView(R.id.albumTitleTv)
    TextView albumTitleTv;

    @BindView(R.id.albumNoOfSongsTv)
    TextView albumNoOfSongsTv;

    @BindView(R.id.albumArtistTv)
    TextView albumArtistTv;

    @BindView(R.id.parentRl)
    View parentView;

    @BindView(R.id.iconIv)
    ImageView iconIv;

    public AlbumViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(final AlbumVisitable visitable,
                     final AlbumOnClickListener onClickListener,
                     Context context) {
        albumTitleTv.setText(visitable.getMediaItem().getDescription().getTitle());
        albumArtistTv.setText(visitable.getMediaItem().getDescription().getSubtitle());

        RequestOptions options = new RequestOptions();
        options.centerCrop();

        if (visitable.getMediaItem().getDescription().getIconUri() != null) {
            Glide.with(context)
                    .load(visitable.getMediaItem().getDescription().getIconUri().getEncodedPath())
                    .apply(options)
                    .into(iconIv);
        } else {
            Glide.with(context).clear(iconIv);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                iconIv.setImageDrawable(context.getDrawable(R.drawable.default_album_art_album));
            } else {
                iconIv.setImageDrawable(
                        context
                                .getResources()
                                .getDrawable(R.drawable.default_album_art_album));
            }
        }

//        albumNoOfSongsTv.setText(
//                visitable
//                        .getMediaItem()
//                        .getDescription()
//                        .getExtras()
//                        .getLong(MediaMetadataCompat.METADATA_KEY_NUM_TRACKS)+" tracks");

        parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onAlbumClick(visitable.getMediaItem());
            }
        });
    }
}