package access.ex.exam01;

public class MaxCounter {
    private int count = 0;
    private int max;

    public MaxCounter(int max) {
        this.max = max;
    }

    public void increment() {
        if (this.count >= this.max) {
            System.out.println("최대값을 초과할 수 없습니다.");
        } else {
            ++this.count;
        }
    }

    public int getCount() {
        return this.count;
    }
}

