package access.ex.exam01;

public class CounterMain {
    public CounterMain() {
    }

    public static void main(String[] args) {
        MaxCounter maxCounter = new MaxCounter(3);
        maxCounter.increment();
        maxCounter.increment();
        maxCounter.increment();
        maxCounter.increment();
        int count = maxCounter.getCount();
        System.out.println(count);
    }
}
