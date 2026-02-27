package umg.edu.gt.handler;

public class Song {
    private String title;
    private String artist;
    private int duration; // en segundos (5-30)
    private int priority; // 1 = Alta, 2 = Normal

    public Song(String title, String artist, int duration, int priority) {
        this.title = title;
        this.artist = artist;
        this.duration = Math.max(5, Math.min(30, duration)); // Validación de rango
        this.priority = priority;
    }

    // Getters
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getDuration() { return duration; }
    public int getPriority() { return priority; }

    @Override
    public String toString() {
        return title + " - " + artist + " (" + duration + "s)";
    }
}