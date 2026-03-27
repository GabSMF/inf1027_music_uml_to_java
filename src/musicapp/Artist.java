package musicapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Artist {

    private String artName;
    private String name;
    private int nAlbums;
    private LocalDate birthDate;
    private int nMusics;
    private final List<Album> albums;
    private final List<Music> musics;

    public Artist(String artName, String name, LocalDate birthDate) {
        this.artName = artName;
        this.name = name;
        this.birthDate = birthDate;
        this.albums = new ArrayList<>();
        this.musics = new ArrayList<>();
        updateCounters();
    }

    public String getArtName() {
        return artName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getNAlbums() {
        return nAlbums;
    }

    public int getNMusics() {
        return nMusics;
    }

    public String getName() {
        return name;
    }

    public List<Album> getAlbums() {
        return Collections.unmodifiableList(albums);
    }

    public List<Music> getMusics() {
        return Collections.unmodifiableList(musics);
    }

    public void addAlbum(Album album) {
        Objects.requireNonNull(album, "album cannot be null");
        if (!albums.contains(album)) {
            albums.add(album);
            updateCounters();
        }
    }

    public void addMusic(Music music) {
        Objects.requireNonNull(music, "music cannot be null");
        if (!musics.contains(music)) {
            musics.add(music);
            updateCounters();
        }
    }

    public void removeAlbum(Album album) {
        if (album == null) {
            return;
        }
        albums.remove(album);
        updateCounters();
    }

    public void removeMusic(Music music) {
        if (music == null) {
            return;
        }
        musics.remove(music);
        updateCounters();
    }

    private void updateCounters() {
        nAlbums = albums.size();
        nMusics = musics.size();
    }

    @Override
    public String toString() {
        return "Artist{artName='" + artName + "', name='" + name + "', nAlbums=" + nAlbums
                + ", nMusics=" + nMusics + "}";
    }
}
