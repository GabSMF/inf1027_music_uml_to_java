package musicapp;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Listener listener = new Listener("Gabriel", "gabriel", "123456");

        Music firstMusic = new Music(List.of(5, 4, 5));
        Music secondMusic = new Music(List.of(4, 4, 3));

        Playlist playlist = listener.createPlaylist();
        playlist.addMusic(firstMusic);
        playlist.addMusic(secondMusic);
        playlist.editPlaylist();

        listener.listenMusic(firstMusic);
        listener.favoriteMusic(secondMusic);

        Album album = new Album("Acoustic Sessions", 2024);
        album.addMusic(firstMusic);
        album.addMusic(secondMusic);

        Artist artist = new Artist("Gabs Sound", "Gabriel Silva", LocalDate.of(1998, 5, 1));
        artist.addAlbum(album);
        artist.addMusic(firstMusic);
        artist.addMusic(secondMusic);

        System.out.println("Listener login valid: " + listener.login());
        System.out.println("Playlist owner: " + playlist.getUser().getName());
        System.out.println("Playlist music count: " + playlist.getNMusics());
        System.out.println("Album summary: " + album.operation());
        System.out.println("Artist album count: " + artist.getNAlbums());
        System.out.println("Artist music count: " + artist.getNMusics());
        System.out.println("First music mean stars: " + firstMusic.getMeanStars());
        System.out.println("Favorite musics: " + listener.getFavoriteMusics().size());
    }
}
