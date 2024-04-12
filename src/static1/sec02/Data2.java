package static1.sec02;

import static1.Counter;

public class Data2 {
    public String name;

    public Data2(String name, Counter counter) {
        this.name = name;
        counter.count ++;
    }
}
