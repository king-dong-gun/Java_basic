package oop.sec01.example02;

public class MusicPlayerMain03 {
    public MusicPlayerMain03() {
    }

    public static void main(String[] args) {
        MusicPlayerData musicPlayerData = new MusicPlayerData();
        on(musicPlayerData);
        volumeUp(musicPlayerData);
        volumeUp(musicPlayerData);
        volumeDown(musicPlayerData);
        showStatus(musicPlayerData);
        off(musicPlayerData);
    }

    static void on(MusicPlayerData musicPlayerData) {
        musicPlayerData.isOn = true;
        System.out.println("음악을 플레이 합니다.");
    }

    static void off(MusicPlayerData musicPlayerData) {
        musicPlayerData.isOn = false;
        System.out.println("음악 플레이어를 종료합니다..");
    }

    static void volumeUp(MusicPlayerData musicPlayerData) {
        ++musicPlayerData.volume;
        System.out.println("볼륨 증가 >> " + musicPlayerData.volume);
    }

    static void volumeDown(MusicPlayerData musicPlayerData) {
        --musicPlayerData.volume;
        System.out.println("볼륨 감소 >> " + musicPlayerData.volume);
    }

    static void showStatus(MusicPlayerData musicPlayerData) {
        System.out.println("음악 플레이어 상태를 확인합니다.");
        if (musicPlayerData.isOn) {
            System.out.println("플레이어가 재생중입니다. 현재 볼륨 >> " + musicPlayerData.volume);
        } else {
            System.out.println("플레이어가 재생중이 아닙니다.");
        }

    }
}
