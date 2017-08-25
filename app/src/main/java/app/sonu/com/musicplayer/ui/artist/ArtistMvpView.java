package app.sonu.com.musicplayer.ui.artist;

import android.support.v4.media.MediaBrowserCompat;

import java.util.List;

import app.sonu.com.musicplayer.base.ui.BaseMvpView;

/**
 * Created by sonu on 21/8/17.
 */

public interface ArtistMvpView extends BaseMvpView {
    void displayList(List<MediaBrowserCompat.MediaItem> itemList);
    void displayArtistData(String title, String subtitle, String artPath);
    void displayToast(String message);
}
