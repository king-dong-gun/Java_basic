package access.sec01;

public class SpeakerMain {
    public SpeakerMain() {
    }

    public static void main(String[] args) {
        Speaker speaker01 = new Speaker(98);
        speaker01.volumUp();
        speaker01.showVolume();
        speaker01.volumUp();
        Speaker speaker02 = new Speaker(2);
        speaker02.volumDown();
        speaker02.showVolume();
        speaker02.volumDown();
        speaker01.volume = 200;
        speaker01.showVolume();
    }
}
