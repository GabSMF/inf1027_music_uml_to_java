package musicapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Listener {

    private String name;
    private String login;
    private String password;
    private final List<Playlist> playlists;
    private final List<Music> listenedMusics;
    private final List<Music> favoriteMusics;

    public Listener(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.playlists = new ArrayList<>();
        this.listenedMusics = new ArrayList<>();
        this.favoriteMusics = new ArrayList<>();
    }

    public boolean login() {
        return login != null && !login.isBlank() && password != null && !password.isBlank();
    }

    public Playlist createPlaylist() {
        Playlist playlist = new Playlist();
        addPlaylistInternal(playlist);
        return playlist;
    }

    public void listenMusic(Music music) {
        Objects.requireNonNull(music, "music cannot be null");
        if (!listenedMusics.contains(music)) {
            listenedMusics.add(music);
        }
    }

    public void favoriteMusic(Music music) {
        Objects.requireNonNull(music, "music cannot be null");
        listenMusic(music);
        if (!favoriteMusics.contains(music)) {
            favoriteMusics.add(music);
        }
    }

    public String getName() {
        return name;
    }

    public String getLoginName() {
        return login;
    }

    public List<Playlist> getPlaylists() {
        return Collections.unmodifiableList(playlists);
    }

    public List<Music> getListenedMusics() {
        return Collections.unmodifiableList(listenedMusics);
    }

    public List<Music> getFavoriteMusics() {
        return Collections.unmodifiableList(favoriteMusics);
    }

    void addPlaylistInternal(Playlist playlist) {
        Objects.requireNonNull(playlist, "playlist cannot be null");

        Listener currentOwner = playlist.getUser();
        if (currentOwner != null && currentOwner != this) {
            currentOwner.removePlaylistInternal(playlist);
        }

        if (!playlists.contains(playlist)) {
            playlists.add(playlist);
        }

        playlist.setUserInternal(this);
    }

    void removePlaylistInternal(Playlist playlist) {
        if (playlist == null) {
            return;
        }

        playlists.remove(playlist);
        if (playlist.getUser() == this) {
            playlist.setUserInternal(null);
        }
    }

    @Override
    public String toString() {
        return "Listener{name='" + name + "', playlists=" + playlists.size() + ", listenedMusics="
                + listenedMusics.size() + ", favoriteMusics=" + favoriteMusics.size() + "}";
    }
}
