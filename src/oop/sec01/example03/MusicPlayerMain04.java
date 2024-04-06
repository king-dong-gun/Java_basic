package oop.sec01.example03;

public class MusicPlayerMain04 {
    public MusicPlayerMain04() {
    }

    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.on();
        musicPlayer.volumeUp();
        musicPlayer.volumeUp();
        musicPlayer.volumeDown();
        musicPlayer.setStatus();
        musicPlayer.off();
    }
}
