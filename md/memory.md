## 자바 메모리 구조


![자바메모리구조비유.png](..%2Fimage%2F%EC%9E%90%EB%B0%94%EB%A9%94%EB%AA%A8%EB%A6%AC%EA%B5%AC%EC%A1%B0%EB%B9%84%EC%9C%A0.png)



1. **메소드 영역**: 클래스 정보 보관
2. **스택 영역**: 실제 프로그램이 실행되는 영역, 메소드를 실행할 때 마다 하나씩 쌓임
3. **힙 영역**: 객체(인스턴스)가 생성되는 영역
    - `new` 명령어는 힙영역!!
    - 배열도 힙영역!!


![자바 메모리구조 실제.png](..%2Fimage%2F%EC%9E%90%EB%B0%94%20%EB%A9%94%EB%AA%A8%EB%A6%AC%EA%B5%AC%EC%A1%B0%20%EC%8B%A4%EC%A0%9C.png)



1. **매소드 영역**: 프로그램을 실행하는데 필요한 공통 데이터 관리
   - 클래스 정보: 실행코드, 필드, 메소드, 생성자 코드 등 모든 실행 코드가 존재
   - `static` 영역: 
2. **스택 영역**: 자바를 실행시, 하나의 실행 스택이 생성됨 각 스텍 프레임은 지역변수, 중간 연산 결과, 메소드 호출등을 포함
    - 스택 프레임: 메소드를 호출할 때 마다 하나의 스택 프레임이 쌓이고, 메소드가 종료되면 스택 프레임이 제거
3. **힙 영역**: 객체(인스턴스)와 배열이 생성되는 영역


### 메소드 코드는 메소드 영역에

![메소드영역.png](..%2Fimage%2F%EB%A9%94%EC%86%8C%EB%93%9C%EC%98%81%EC%97%AD.png)


- 자바에서 특정 클래스로 100개의 인스턴스를 생성하면 힙 영역에 100개의 인스턴스가 생김,
- 같은 클래스로 부터 생성된 객체(인스턴스)라도 내부 변수 값은 다를수 있지만, 메소드는 공통된 코드를 공유
- 즉 객체가 생성될 때 인스턴스 변수에는 메모리가 할당 되지만 **메소드에 대한 새로운 메모리 할당은 없다**
- 메소드는 메소드 영역에서 공통으로 관리되고 실행되기 때문에!!!!
> 객체(인스턴스)의 메소드를 호풀하면 실제로는 메소드 영역에 있는 코드를 불러 수행한다.

### 스택 구조


![스택구조선입.png](..%2Fimage%2F%EC%8A%A4%ED%83%9D%EA%B5%AC%EC%A1%B0%EC%84%A0%EC%9E%85.png)





![스택구조선출.png](..%2Fimage%2F%EC%8A%A4%ED%83%9D%EA%B5%AC%EC%A1%B0%EC%84%A0%EC%B6%9C.png)



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

![스택 실행결과.png](..%2Fimage%2F%EC%8A%A4%ED%83%9D%20%EC%8B%A4%ED%96%89%EA%B2%B0%EA%B3%BC.png)



![큐자료구조.png](..%2Fimage%2F%ED%81%90%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0.png)



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


![스택힙출력결과.png](..%2Fimage%2F%EC%8A%A4%ED%83%9D%ED%9E%99%EC%B6%9C%EB%A0%A5%EA%B2%B0%EA%B3%BC.png)


#### 정리
- 지역 변수는 스택영역, 객체(인스턴스)는 힙 영역에 관리된다.

