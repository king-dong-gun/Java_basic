## final 변수
### 목차
1. final 변수와 상수1
2. final 변수와 상수2
3. final 변수와 참조
4. 문제풀이


#### 1. final 변수와 상수1
- `final` 키워드는 이름 그대로 **끝** 이라는 뜻이다.
- 변수에 `final` 키워드가 붙으면 더는 값을 변경할 수 없다.
##### final 지역변수
```java
package final1;

public class FinalLocalMain {
    public static void main(String[] args) {
        // final 지역변수
        final int data1;
        data1 = 10;     // final은 최초 한번만 할당 가능
        // data1 = 20;     // 컴파일 오류

        // final 지역변수2
        final int data2;
        data2 = 10;
        // data2 = 20;     // 컴파일 오류

        method(10);  // 메소드 호출할때 인수로 넘기는 값 고정
    }

    static void method(final int parameter) {
        // parameter = 20;  // 컴파일 오류
    }
}

```
> `final`을 지역변수에 선언시 바로 초기화 한 경우 이미 값이 할당되었기 때문에 값을 할당할 수 없다.

> 매개변수에 `final`이 붙으면 메소드 내부에서 매개변수의 값을 변경할 수 없다.
- 메소드 호출 시점에 사용된 값이 끝까지 사용된다!!

##### final 필드(맴버 변수)

```java
package final1.sec01;

public class ConstructInit {


    // final 필드 - 생성자 초기화
    final int value;

    public ConstructInit(int value) {
        this.value = value;
    }
}

```
- `final`을 필드에 사용할 경우 해당 필드는 생성자를 통해서 한번만 초기화 될 수 있다.


```java
package final1.sec01;

public class FieldInit {

    // final 필드 - 필드 초기화
    static final int CONST_VALUE = 10;  // 바뀌지 않는 공용 변수
    final int value = 10;   // 초기값이 있는 경우에 생성자 생성 안됨
}

```
- `final` 필드를 필드에서 초기화하면 이미 값이 설정되었기 때문에 생성자를 통해서 초기화 할 수 없다.
- FieldInit 클래스 처럼 `final` 필드를 필드에서 초기화 하면 모든 인스턴스가 같은 값을 가진다.



![finalStatic](https://github.com/king-dong-gun/Java_basic/assets/160683545/224438cb-0696-442e-bc38-cb707d9c441c)



##### final static
- 위 그림 처럼 `FieldInit.MY_VALUE`는 `static` 역역에 존재한다. `final` 키워드를 사용해서 초기화 값이 변하지 않는다.
- `static` 영역은 단 하나만 존재하는 영역이기 때문에 `MY_VALUE` 변수는 JVM에서 하나만 존재하므로 메모리 비효율 문제를 해결할 수 있다.

> 이런 이유로 필드에 `final` + `필드 초기화`를 사용하는 경우 `static`을 붙혀 사용하는게 효율적이다.



#### 2. final 변수와 상수2
##### 상수
**자바 상수 특징**
- `static final` 키워드를 사용한다.
- 대문자를 사용하고 구분은 _(언더스코어)를 사용한다. -> 관례
  - 일반적인 변수와 상수를 구분하기 위해서
- 필드를 직접 접근해서 사용한다.
  - 상수는 고정된 값 자체를 사용하는게 목적이기 때문이다.

**실생활 상수 클래스 예**
```java
package final1.sec02;

public class Constant {
    // 수학 상수
    public static final double PI = 3.14;
    
    // 시간 상수
    public static final int HOURS_IN_DAY = 24;
    public static final int MINUTES_IN_HOUR = 60;
    public static final int SECOND_IN_MINUTE = 60;
    
    // 애플리케이션 설정 상수
    public static final int MAX_USERS = 1000;
}

```

```java
package final1.sec02;

public class ConstantMain01 {
  public static void main(String[] args) {
    System.out.println("프로그램 최대 참여자 수 >> " + 1000); // 수정포인트
    int currentUserCount = 999;
    process(currentUserCount++);
    process(currentUserCount++);
    process(currentUserCount++);
  }

  private static void process(int currentUserCount) {
    System.out.println("현재 참여자 수 >> " + currentUserCount);
    if (currentUserCount > 1000) {                          // 수정포인트
      System.out.println("대기자로 등록합니다");
    } else {
      System.out.println("게임에 참여합니다.");
    }
  }
}

```
- 이 코드에서는 최대 참여자수를 1000명에서 2000명에서 변경하려면 2곳의 변경 포인트가 발생한다.
- 애플리케이션의 100곳에서 이 숫자를 사용했다면 100곳 모두 변경을 해야한다.

> 다음과 같이 수정
```java
package final1.sec02;

public class ConstantMain02 {
    public static void main(String[] args) {
        System.out.println("프로그램 최대 참여자 수 >> " + Constant.MAX_USERS);
        int currentUserCount = 999;
        process(currentUserCount++);
        process(currentUserCount++);
        process(currentUserCount++);
    }

    private static void process(int currentUserCount) {
        System.out.println("현재 참여자 수 >> " + currentUserCount);
        if (currentUserCount > Constant.MAX_USERS) {
            System.out.println("대기자로 등록합니다");
        } else {
            System.out.println("게임에 참여합니다.");
        }
    }
}

```
- 앞서 만들었던 `Constant.Max_USERS`상수를 사용하면 `Constant.Max_USERS`의 상수값만 변경하면 된다!!


#### 3. final 변수와 참조
```java
package final1.sec03;

public class Data {
  public int value;
}

```

```java
package final1.sec03;

public class FinalRefMain {
    public static void main(String[] args) {
        final Data data = new Data();

        // data = new Data();  // 이미 참조했기 때문에 할당 불가능

        // 참조 대상의 값은 변경 가능
        data.value = 10;
        System.out.println(data.value);
        data.value = 20;
        System.out.println(data.value);
    }
}

```
- 참조형 변수 `data`에 `final`이 붙어 참조값을 할당했으므로 더는 참조값을 변경할 수 없다.

```java
data.value = 10;
data.value = 20;
```
- 위처럼 참조 대상의 객체값은 변경할 수 있다.
  - 참조형 변수에 들어있는 참조값만 변경하지 못한다.
  - `Data.value`는 `final`이 아니라 인스턴스이기 때문에 값을 변경할 수 있다.


![final인스턴스](https://github.com/king-dong-gun/Java_basic/assets/160683545/490d0101-e602-48b5-9083-039c538381c9)



#### 4. 문제풀이
##### id 유지 프로그램
- 고객의 id를 변경하면 큰 문제가 발생한다. final로 선언하고 생성자로 값을 할당하세요

```java
package final1.ex;

public class Member {
    private final String id;    // final 키워드 사용
    private String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void changeData(String name) {
        // this.id = id;       // final이기 때문에 컴파일 오류
        this.name = name;
    }

    public void print() {
        System.out.println("id >> " + id + ", name >> " + name);
    }
}

```


```java
package final1.ex;

public class MemberMain {
    public static void main(String[] args) {
        Member member = new Member("myId", "kim");
        member.print();
        member.changeData("lee");
        member.print();
    }
}

```
![final출력결과](https://github.com/king-dong-gun/Java_basic/assets/160683545/045e13bb-aab7-461d-8a20-02c1fd1f30d0)


**id를 `final`로 선언하였기 때문에 아이디는 변경이 되지않고, 이름만 변경된 것 확인!!**





