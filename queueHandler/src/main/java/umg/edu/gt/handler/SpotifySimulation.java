package umg.edu.gt.handler;

import umg.edu.gt.datastructure.queue.Queue; 

public class SpotifySimulation {
    private Queue<Song> highPriorityQueue = new Queue<>();
    private Queue<Song> normalPriorityQueue = new Queue<>();
    private int totalSongsPlayed = 0;
    private int totalAccumulatedTime = 0;

    public void addSong(Song song) {
        if (song.getPriority() == 1) {
            highPriorityQueue.enqueue(song);
        } else {
            normalPriorityQueue.enqueue(song);
        }
    }

    public void startPlaylist() {
        System.out.println("[LOG] Iniciando Playlist...");

        while (!highPriorityQueue.isEmpty()) {
            playSong(highPriorityQueue.dequeue());
        }

        while (!normalPriorityQueue.isEmpty()) {
            playSong(normalPriorityQueue.dequeue());
        }

        System.out.println("\n[LOG] Playlist finalizada.");
        System.out.println("[LOG] Total de canciones reproducidas: " + totalSongsPlayed);
        System.out.println("[LOG] Total de tiempo reproducido: " + totalAccumulatedTime + "s");
    }

    private void playSong(Song song) {
        System.out.println("\n[LOG] Reproduciendo: " + song);

        for (int i = 1; i <= song.getDuration(); i++) {
            try {
                Thread.sleep(1000); 
                updateProgress(song.getTitle(), i, song.getDuration());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n[LOG] Finalizado: " + song.getTitle());
        totalSongsPlayed++;
        totalAccumulatedTime += song.getDuration();
    }

    private void updateProgress(String title, int current, int total) {
        int percent = (current * 100) / total;
        int bars = percent / 10;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 10; i++) {
            sb.append(i < bars ? "#" : "-");
        }
        sb.append("]");
        
        String output = String.format("\r[LOG] Reproduciendo: %s | %s %ds / %ds", title, sb.toString(), current, total);
        System.out.print(output);
        
        System.out.flush();
    }
}