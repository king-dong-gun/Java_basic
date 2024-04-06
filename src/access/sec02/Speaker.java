package access.sec02;

public class Speaker {
    private int volume;

    Speaker(int volume) {
        this.volume = volume;
    }

    void volumUp() {
        if (this.volume >= 99) {
            System.out.println("음량을 올릴 수 없습니다. 최대 볼륨 >> 99");
        } else {
            ++this.volume;
            System.out.println("볼륨을 1 높힙니다.");
        }

    }

    void volumDown() {
        if (this.volume <= 1) {
            System.out.println("음량을 내릴 수 없습니다. 최소 볼륨 >> 1");
        } else {
            --this.volume;
            System.out.println("볼륨을 1 줄입니다.");
        }

    }

    void showVolume() {
        System.out.println("현재 볼륨 >> " + this.volume);
    }
}
