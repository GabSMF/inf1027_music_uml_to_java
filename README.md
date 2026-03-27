# Music UML Eclipse Project

Plain Java Eclipse project that implements the UML specification with these classes:

- `Playlist`
- `Listener`
- `Artist`
- `Album`
- `Music`

All source files are under `src/musicapp`.

## UML Mapping

- `Playlist` keeps `Listener user`, `int nMusics`, and `List<Music> musics`.
- `Listener` keeps `List<Playlist> playlists`, `List<Music> listenedMusics`, and `List<Music> favoriteMusics`.
- `Artist` keeps `List<Album> albums` and `List<Music> musics`, plus derived counters `nAlbums` and `nMusics`.
- `Album` keeps `List<Music> musics`.
- `Music` keeps `List<Integer> starsList` and `double meanStars`.

## Eclipse Import

1. Install a JDK compatible with Java 17 or newer.
2. Install an Eclipse package with Java support, such as Eclipse IDE for Java Developers.
3. Open Eclipse.
4. Go to `File > Import > Existing Projects into Workspace`.
5. Select this folder: `teste_medicao_uml_java`.
6. Finish the import and run `musicapp.Main`.

## Terminal Build

```bash
javac -d bin src/musicapp/*.java
java -cp bin musicapp.Main
```
