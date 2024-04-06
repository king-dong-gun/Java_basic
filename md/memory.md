## 자바 메모리 구조






![자바메모리구조비유](https://github.com/king-dong-gun/Java_basic/assets/160683545/7920f4c1-fb3e-4556-a27b-b9a16e8acd3c)



1. **메소드 영역**: 클래스 정보 보관
2. **스택 영역**: 실제 프로그램이 실행되는 영역, 메소드를 실행할 때 마다 하나씩 쌓임
3. **힙 영역**: 객체(인스턴스)가 생성되는 영역
    - `new` 명령어는 힙영역!!
    - 배열도 힙영역!!






![자바 메모리구조 실제](https://github.com/king-dong-gun/Java_basic/assets/160683545/94b0482d-cb88-4777-883d-4fb6287d17a2)







1. **매소드 영역**: 프로그램을 실행하는데 필요한 공통 데이터 관리
   - 클래스 정보: 실행코드, 필드, 메소드, 생성자 코드 등 모든 실행 코드가 존재
   - `static` 영역: 
2. **스택 영역**: 자바를 실행시, 하나의 실행 스택이 생성됨 각 스텍 프레임은 지역변수, 중간 연산 결과, 메소드 호출등을 포함
    - 스택 프레임: 메소드를 호출할 때 마다 하나의 스택 프레임이 쌓이고, 메소드가 종료되면 스택 프레임이 제거
3. **힙 영역**: 객체(인스턴스)와 배열이 생성되는 영역


### 메소드 코드는 메소드 영역에




![메소드영역](https://github.com/king-dong-gun/Java_basic/assets/160683545/c42accd2-066d-48d5-8f36-00d4d951b140)








- 자바에서 특정 클래스로 100개의 인스턴스를 생성하면 힙 영역에 100개의 인스턴스가 생김,
- 같은 클래스로 부터 생성된 객체(인스턴스)라도 내부 변수 값은 다를수 있지만, 메소드는 공통된 코드를 공유
- 즉 객체가 생성될 때 인스턴스 변수에는 메모리가 할당 되지만 **메소드에 대한 새로운 메모리 할당은 없다**
- 메소드는 메소드 영역에서 공통으로 관리되고 실행되기 때문에!!!!
> 객체(인스턴스)의 메소드를 호풀하면 실제로는 메소드 영역에 있는 코드를 불러 수행한다.

### 스택 구조




![스택구조선입](https://github.com/king-dong-gun/Java_basic/assets/160683545/f02d70c8-e331-4203-a3aa-a634719d2a51)








![스택구조선출](https://github.com/king-dong-gun/Java_basic/assets/160683545/0a81714c-3108-425c-b550-3d7a9cd57796)






> 후입선출: 위와 같이 1 -> 2 -> 3 순으로 들어오면 나갈때도 3 -> 2 -> 1 순으로 나온다. (이런 자료구조를 스택이라 한다)

```java
package memory;

public class JavaMemoryMain01 {
    public static void main(String[] args) {
        System.out.println("main start");
        method1(10);
        System.out.println("main end");
    }
    static void method1(int m1) {
        System.out.println("method1 start");
        int cal = m1 * 2;
        method2(cal);
        System.out.println("method1 end");

    }
    static void method2(int m2) {
        System.out.println("method2 start");
        System.out.println("method2 end");
    }
}
```
> 출력결과





![스택 실행결과](https://github.com/king-dong-gun/Java_basic/assets/160683545/073ce738-5dbe-491d-b0ca-8d3ecf659d7b)






![큐자료구조](https://github.com/king-dong-gun/Java_basic/assets/160683545/dd560df1-4f8b-453b-a90f-bf343e3a31eb)



> 선입선출: 가장 먼저 넣은것이 가장 먼저 나오는 것 (이런 자료구조를 큐라고 한다)

#### 스택 정리
- 자바는 스택영역을 사용해 메소드 호출과 지역변수(매개변수 포함)를 관리
- 메소드를 계속 호출하면 스택 프레임이 쌓임
- 스택 프레임이 종료되면 지역변수도 함께 제거
- 스택 프레임이 모두 제거되면 프로그램 종료


### 스택영역과 힙 영역
```java
package memory.sec02;

public class JavaMemoryMain02 {
    public static void main(String[] args) {
        System.out.println("main start");
        method1();
        // method1이 종료되면서 x001 참조값을 가진 Data 인스턴스가 없음
        System.out.println("main end");
    }
    static void method1() {
        System.out.println("method1 start");
        Data data1 = new Data(10);
        method2(data1);
        System.out.println("method1 end");

    }
    // method1()가 method2()를 호출하면서 data2 매개변수에 참조값을 넘김
    static void method2(Data data2) {
        System.out.println("method2 start");
        // 메소드1과 메소드2가 같은 참조값을 가짐
        System.out.println("data.value= " + data2.getValue());
        System.out.println("method2 end");
    }
}
```
```java
package memory.sec02;

public class Data {
    private int value;

    public Data(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
```
> 출력결과




![스택힙출력결과](https://github.com/king-dong-gun/Java_basic/assets/160683545/aaa257e9-a21e-4730-a8c6-7eaac41ec0bd)





#### 정리
- 지역 변수는 스택영역, 객체(인스턴스)는 힙 영역에 관리된다.

