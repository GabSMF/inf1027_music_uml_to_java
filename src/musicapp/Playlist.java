package musicapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Playlist {

    private Listener user;
    private int nMusics;
    private final List<Music> musics;

    public Playlist() {
        this.musics = new ArrayList<>();
        this.nMusics = 0;
    }

    public Playlist(Listener user) {
        this();
        if (user != null) {
            user.addPlaylistInternal(this);
        }
    }

    public void deletePlaylist() {
        musics.clear();
        updateMusicCount();

        if (user != null) {
            user.removePlaylistInternal(this);
        }
    }

    public void addMusic(Music music) {
        Objects.requireNonNull(music, "music cannot be null");
        if (!musics.contains(music)) {
            musics.add(music);
            updateMusicCount();
        }
    }

    public void removeMusic(Music music) {
        if (music == null) {
            return;
        }

        musics.remove(music);
        updateMusicCount();
    }

    public void editPlaylist() {
        musics.sort(Comparator.comparingDouble(Music::getMeanStars).reversed());
        updateMusicCount();
    }

    public Listener getUser() {
        return user;
    }

    public int getNMusics() {
        return nMusics;
    }

    public List<Music> getMusics() {
        return Collections.unmodifiableList(musics);
    }

    void setUserInternal(Listener user) {
        this.user = user;
    }

    private void updateMusicCount() {
        nMusics = musics.size();
    }

    @Override
    public String toString() {
        String ownerName = user == null ? "none" : user.getName();
        return "Playlist{owner=" + ownerName + ", nMusics=" + nMusics + "}";
    }
}
