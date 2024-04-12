package static1.ex.test02;

public class MathArrayUtils {
    private MathArrayUtils() {
        // private 인스턴스 생성을 막음
    }

    public static int sum(int[] values) {
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }

    public static double average(int[] values) {
        return (double) sum(values) / values.length;

    }

    public static int min(int[] values) {
        int minValue = values[0];       // 최소값을 value 배열 0번에서 가져옴
        for (int value : values) {      // for문으로 배열을 하나씩 비교
            if (value < minValue) {     // value가 minValue 보다 작으면 min = value
                minValue = value;
            }
        }
        return minValue;                // 최소값 리턴
    }

    public static int max(int[] values) {
        int maxValue = values[0];
        for (int value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
