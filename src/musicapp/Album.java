package musicapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Album {

    private String title;
    private int pubYear;
    private final List<Music> musics;

    public Album(String title, int pubYear) {
        this.title = title;
        this.pubYear = pubYear;
        this.musics = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Music> getMusics() {
        return Collections.unmodifiableList(musics);
    }

    public int getPubYear() {
        return pubYear;
    }

    public String operation() {
        return title + " (" + pubYear + ") has " + musics.size() + " music(s).";
    }

    public void addMusic(Music music) {
        Objects.requireNonNull(music, "music cannot be null");
        if (!musics.contains(music)) {
            musics.add(music);
        }
    }

    public void removeMusic(Music music) {
        if (music == null) {
            return;
        }
        musics.remove(music);
    }

    @Override
    public String toString() {
        return "Album{title='" + title + "', pubYear=" + pubYear + ", musics=" + musics.size() + "}";
    }
}
