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
   - `static` 영역
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



#### static
> `static` 키워드는 주로 맴버 변수와 메소드에 사용된다.
```java
 package static1;

public class Data3 {
    public String name;
    public static int count; //static

    public Data3(String name) {
        this.name = name;
        count++;
    }
}
```
- `static int count` 부분에서 변수 타입앞에 `static` 키워드가 붙어있다.
- 이렇게 맴버변수에 `static`을 붙이면 **static 변수**, **정적 변수**, **클래스 변수**라고 한다.

```java
 package static1;

public class DataCountMain3 {
    public static void main(String[] args) {
        Data3 data1 = new Data3("A");
        System.out.println("A count=" + Data3.count);
        Data3 data2 = new Data3("B");
        System.out.println("B count=" + Data3.count);
        Data3 data3 = new Data3("C");
        System.out.println("C count=" + Data3.count);
    }
}
```
- 코드를 보면 `count` 정적 변수에 접근하는 방법이 조금 특이한데 `Data3.count`와 같이 클래스명에 .(dot)을 사용한다.
  - 마치 클래스에 직접 접근하는 것 처럼....?

> 실행결과



![static출력결과](https://github.com/king-dong-gun/Java_basic/assets/160683545/e98b4b8d-1eaf-4224-b73e-0c965bcf0ab0)




![static01](https://github.com/king-dong-gun/Java_basic/assets/160683545/ea801306-b2e0-46a2-aeee-c39d5494e44a)



- `static`이 붙은 맴버변수는 메소드 영역에서 관리한다.
  - `static`이 붙은 맴버 변수 `count`는 인스턴스 영역에 생성되지 않고, 메소드 영역에서 변수를 관리한다.
- `Data03("A") 인스턴스를 생성하면 생성자가 호출된다.
- 생성자에는 `count++` 코드가 있다. `count`는 `static`이 붙은 정적 변수이다.
  - 정적 변수는 인스턴스 영역이 아니라 메소드 영역에서 관리한다. 따라서 메소드 영역에 있는 `count`의 값이 하나 증가한다.


![static02](https://github.com/king-dong-gun/Java_basic/assets/160683545/19a0fa48-bc34-4265-8af6-a5d8cf01d39d)



- `Data03("B")` 인스턴스를 생성하면 생성자가 호출된다.
- `count++` 코드에서 `count`는 `static`이 붙은 정적 변수이다.
  - 메소드 영역에 있는 `count` 변수의 값이 하나 증가된다.


![static03](https://github.com/king-dong-gun/Java_basic/assets/160683545/6c721666-cf25-4afb-bdd3-7f2dd6a9108c)



- 코드가 모두 실행되면 최종적으로 메소드 영역에 있는 `count` 변수의 값은 3이 된다.
- **`static` 변수를 사용하면 공용 변수를 사용해서 편리하게 문제를 해결할 수 있다.**

> `static` 변수는 클래스인 붕어빵 틀이 특별히 관리하는 변수!! 붕어빵 틀은 1개이므로 
> 클래스 변수도 하나만 존재한다. 반면에 인스턴스인 붕어빵은 인스턴스의 수 만큼 변수가 존재한다. 


##### 용어 정리
> 맴버변수(필드)의 종류

- **인스턴스 변수**: `static`이 붙지 않은 맴버 변수.
  - `static`이 붙지 않은 맴버변수는 인스턴스를 생성해야 사용할 수 있고, 인스턴스에 소속되어 있다.
  - 인스턴스 변수는 인스턴스를 만들 때 마다 새로 만들어진다.

- **클래스 변수**
  - 클래스 변수, 정적 변수, static 변수 등 으로 부른다. **용어 모두 사용하니 주의!!**
  - 클래스 변수는 자바 프로그램을 시작할 때 딱 1개만 만들어진다.
  - `static`이 붙은 맴버 변수는 인스턴스와 무관하게 클래스에 바로 접근해서 사용할 수 있고, 클래스 자체에 소속되어 있다.

##### 정적 변수 접근 법
> DataCountMain03 - 추가
```java
        // 추가
// 인스턴스를 통한 접근
Data03 data04 = new Data03("D");
        System.out.

println(data04.count);

// 클래스를 통한 접근
        System.out.

println(Data03.count);
```
> 출력결과
![static접근법](https://github.com/king-dong-gun/Java_basic/assets/160683545/f5d05041-1944-4e5b-a12e-270b1f6338e4)


- 둘의 차이는 없다 >> 결과적으로 정적변수에 둘다 접근

> 인스턴스를 통한 접근 `data4.count`
- 정적변수의 경우 인스턴스를 통한 접근을 추천하지 않는다.
  - 코드를 읽을 때 마치 인스턴스 변수에 접근하는 것 처럼 오해할 수 있기 때문!!!

> 클래스를 통한 접근 `Data3.count`
- 정적변수는 클래스에서 공용으로 관리하기 때문에 클래스를 통해서 접근하는 것이 더 명확하다.
  - 정적변수에 접근할 때는 클래스를 통해서 접근하자!!

##### static 메소드

```java
package static1.sec05;

public class DecoUtil02 {
    public static String deco(String str) {
        String result = "*" + str + "*";
        return result;
    }
}

```

```java
package static1.sec05;

public class DecoMain02 {
    public static void main(String[] args) {
        String str = "hello java";
        String deco = DecoUtil02.deco(str);

        System.out.println("before >> " + str);
        System.out.println("after >> " + deco);
    }
}

```
> 출력결과
> 
![스태틱메소드호출](https://github.com/king-dong-gun/Java_basic/assets/160683545/f58d16c3-1dae-40e4-b750-1e436c3cc595)


- 메소드 앞에 `static`이 붙어 있어 정적 메소드를 생성했다.
- `static`이 붙은 정적 메소드는 객체 생성 없이 **클래스명 + .(dot) + 메소드명**으로 바로 호출이 가능하다.
    - `static`이 붙지않은 메소드는 인스턴스를 생성해야 호출할 수 있다.

> 하지만 정적 메소드를 언제나 사용할 수 있는 것은 아니다.

##### static 메소드 사용법
- `static`메소드는 `static`만 사용할 수 있다.
  - 클래스 내부의 기능을 사용할 때, 정적 메소드는 `static`이 붙은 **정적 메소드나 정적변수만 사용할 수 있다.**
  - 클래스 내부의 기능을 사용할 때, 정적 메소드는 인스턴스 변수나, 인스턴스 메소드를 사용할 수 없다.
- 반대로 모든 곳에서 `static`을 호출할 수 있다.
  - 정적 메소드는 공용 기능이라, 접근 제어자만 맞춰준다면 클래스를 통해서 호출이 가능하다.

```java
package static1.sec06;

public class DecoData {
    private int instanceValue;
    private static int staticValue;

    public static void staticCall() {
//        instanceValue++;    // 인스턴스 변수 접근, complie error
//        instanceMethod();    // 인스턴스 메소드 접근, complie error

        staticValue++;  // 정적 변수 접근
        staticMethod(); // 정적 메소드 접근
    }

    public void intanceCall() {
        instanceValue++;    // 인스턴스 변수 접근
        instanceMethod();   // 인스턴스 메소드 접근

        staticValue++;      // static 변수 접근
        staticMethod();     // static 메소드 접근
    }

    private void instanceMethod() {
        System.out.println("instanceValue >> " + instanceValue);
    }

    private static void staticMethod() {
        System.out.println("staticValue >> " + staticValue);
    }

}

```
```java
package static1.sec06;

public class DecoDataMain {
    public static void main(String[] args) {
        System.out.println("1. 정적호출");
        DecoData.staticCall();

        System.out.println("2. 인스턴스 호출1");
        DecoData decoData1 = new DecoData();
        decoData1.intanceCall();

        System.out.println("3. 인스턴스 호출2");
        DecoData decoData2 = new DecoData();
        decoData2.intanceCall();
    }
}

```
> 출력결과



![스태틱메소드호출2](https://github.com/king-dong-gun/Java_basic/assets/160683545/d3946cd2-be51-4afd-98b1-3ebb2f299ff0)




- 접근 제어자를 활용해 필드를 포함한 외부에서 직접 필요하지 않은 기능을 막아 놓았다.
  - `instanceValue` -> 인스턴스 변수
  - `staticValue` -> 정적변수(클래스 변수)
  - `instanceMethod()` -> 인스턴스 메소드
  - `staticMethod()` -> 정적 메소드(클래스 메소드)

> `static`메소드는 `static`만 사용할 수 있다. `static`이 없는 인스턴스 변수나 인스턴스 메소드에 접근하면 **컴파일 오류**가 발생

> 인스턴스 메소드는 모든 곳에서 공용인 `static` 호출이 가능하다. 따라서 정적변수, 정적 메소드에 접근할 수 있다.

##### 정적 메소드 활용
- 정적 메소드는 객체 생성이 필요없이 메소드의 호출만으로 필요한 기능을 수행할 때 주로 사용한다.

#### 문제풀이
##### 구매한 자동차 수

[CarMain]()
[Car]()

![문제풀이1](https://github.com/king-dong-gun/Java_basic/assets/160683545/5ba9fbc7-2da7-4e67-a849-c72a72acb76c)



##### 수학 유틸리티 클래스
> MathArrayUtils 객체를 생성하지 않고 작성
[MathArrayUtilsMain]()
[MathArrayUtils]()

![문제풀이2](https://github.com/king-dong-gun/Java_basic/assets/160683545/b4efa7a8-0291-4ae1-9a57-b3ac8d6b25e6)



#### 정리

- 지역 변수는 스택영역, 객체(인스턴스)는 힙 영역에 관리된다.

