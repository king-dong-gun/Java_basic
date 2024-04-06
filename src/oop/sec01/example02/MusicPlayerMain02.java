package oop.sec01.example02;

public class MusicPlayerMain02 {

    public static void main(String[] args) {
        MusicPlayerData musicPlayerData = new MusicPlayerData();
        musicPlayerData.isOn = true;
        System.out.println("음악을 플레이 합니다.");
        ++musicPlayerData.volume;
        System.out.println("볼륨 증가 >> " + musicPlayerData.volume);
        ++musicPlayerData.volume;
        System.out.println("볼륨 증가 >> " + musicPlayerData.volume);
        --musicPlayerData.volume;
        System.out.println("볼륨 감소 >> " + musicPlayerData.volume);
        System.out.println("음악 플레이어 상태를 확인합니다.");
        if (musicPlayerData.isOn) {
            System.out.println("플레이어가 재생중입니다. 현재 볼륨 >> " + musicPlayerData.volume);
        } else {
            System.out.println("플레이어가 재생중이 아닙니다.");
        }

        musicPlayerData.isOn = false;
        System.out.println("음악 플레이어를 종료합니다.");
    }
}
