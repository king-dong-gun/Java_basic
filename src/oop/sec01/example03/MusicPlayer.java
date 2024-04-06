package oop.sec01.example03;

public class MusicPlayer {
    int volume;
    boolean isOn = false;

    public MusicPlayer() {
    }

    void on() {
        this.isOn = true;
        System.out.println("뮤직 플레이어를 시작합니다.");
    }

    void off() {
        System.out.println("뮤직 플레이어를 종료합니다.");
    }

    void volumeUp() {
        ++this.volume;
        System.out.println("볼륨 증가 >> " + this.volume);
    }

    void volumeDown() {
        --this.volume;
        System.out.println("볼륨 감소 >> " + this.volume);
    }

    void setStatus() {
        System.out.println("--플레이어 상태 확인--");
        if (this.isOn) {
            System.out.println("전원이 켜져있습니다. 현재 볼륨 >> " + this.volume);
        } else {
            System.out.println("전원이 꺼져있습니다.");
        }

        System.out.println("------------------");
    }
}
