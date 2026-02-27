package umg.edu.gt.handler;

public class Main {
    public static void main(String[] args) {
        SpotifySimulation spotify = new SpotifySimulation();

        // Aunque "Normal Song" se agrega primero, "High Priority" debe sonar antes.
        spotify.addSong(new Song("Cancion Normal 1", "Artista B", 7, 2));
        spotify.addSong(new Song("Pista Prioritaria", "Artista A", 5, 1)); 
        spotify.addSong(new Song("Cancion Normal 2", "Artista C", 10, 2));
        spotify.addSong(new Song("Top Hit", "Artista D", 6, 1));
        spotify.addSong(new Song("Hells Bells", "AC/DC", 10, 1));

        spotify.startPlaylist();
    }
}