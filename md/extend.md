## 상속
### 목차
1. 상속 시작
2. 상속 관계
3. 상속과 메모리 구조
4. 상속과 오버라이딩
5. super - 부모참조
6. super - 생성자


#### 1. 상속 시작

```java
package extend.sec01;

public class ElectricCar {
    public void move() {
        System.out.println("차를 이동합니다.");
    }

    public void charge() {
        System.out.println("차를 충전합니다.");
    }
}

```

```java
package extend.sec01;

public class GasCar {
    public void move() {
        System.out.println("차를 이동합니다.");
    }
    public void fillUp() {
        System.out.println("기름을 주유합니다.");
    }
}

```

```java
package extend.sec01;

public class CarMain {
    public static void main(String[] args) {

        ElectricCar electricCar = new ElectricCar();
        electricCar.move();
        electricCar.charge();

        GasCar gasCar = new GasCar();
        gasCar.move();
        gasCar.fillUp();
    }
}

```
![상속시작출력](https://github.com/king-dong-gun/Java_basic/assets/160683545/fca9c7cf-ac7c-4f30-b14b-644faa919c39)


![상속시작](https://github.com/king-dong-gun/Java_basic/assets/160683545/c77b5b4e-8c5e-43a7-bb7d-b5d185270c0f)


- `ElectricCar`클래스와 `GasCar`클래스를 생성하고 `CarMain`클래스를 만들었다.
- 전기차(ElectricCar)와 가솔린차(GasCar)는 자동차(Car)의 좀 더 구체적인 개념이고, 반대로 자동차는 전기차와 가솔린차를 포함하는 추상적인 개념이다.
> 이런경우 **상속 관계**를 사용하는 것이 효과적이다.


#### 2. 상속 관계
> 상속은 객체 지향 프로그래밍의 핵심 요소 중 하나로, 기존 클래스의 필드와 메소드를 새로운 클래스에서 재사용하게 해준다.
- **extend 대상은 하나만 선택할 수 있다.**

##### 용어정리
- 부모 클래스(슈퍼클래스): 상속을 통해 자신의 필드와 메소드를 다른 클래스에 제공하는 클래스
- 자식 클래스(서브클래스): 부모 클래스로부터 필드와 메소드를 상속받는 클래스

```java
package extend.sec02;

public class Car {
    public void move() {
        System.out.println("차를 이동합니다.");
    }
}

```

```java
package extend.sec02;

public class ElectricCar extends Car {      // ElectricCar -> Car
    public void charge() {
        System.out.println("전기를 충전합니다.");
    }
}

```

```java
package extend.sec02;

public class GasCar extends Car {           // GasCar -> Car
    public void fillUp() {
        System.out.println("기름을 주유합니다.");
    }
}

```

```java
package extend.sec02;

import extend.sec03.ElectricCar;
import extend.sec03.GasCar;

public class CarMain {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.move();
        electricCar.charge();

        GasCar gasCar = new GasCar();
        gasCar.move();
        gasCar.fillUp();
    }
}

```

![상속시작출력](https://github.com/king-dong-gun/Java_basic/assets/160683545/fca9c7cf-ac7c-4f30-b14b-644faa919c39)

> 실행결과는 동일하다.


![상속구조도](https://github.com/king-dong-gun/Java_basic/assets/160683545/e8bfc466-dea5-43b5-887a-cbbfb94419fe)


- 전기차와 가솔린차가 Car를 상속 받은 덕분에 `electricCar.move()`, `gasCar.move()`를 사용할 수 있다.
- 상속은 부모의 기능을 자식이 물려받는 구조이기 때문에, 부모클래스가 자식 클래스에 접근할 수 없다.

##### 단일 상속
- 자바는 다중상속을 지원하지 않는다. `extend` 대상은 하나만 선택할 수 있다.


#### 3. 상속과 메모리 구조

```java
ElectricCar electricCar = new ElectricCar();
```

![상속메모리구조1](https://github.com/king-dong-gun/Java_basic/assets/160683545/4c589e4c-f828-472c-b453-cf7482834735)


- `new ElectricCar()`를 호출하면 `ElectricCar`뿐만 아니라 상속관계에 있는 `Car`까지 포함해서 인스턴스를 생성한다.
- 참조값은 x001 하나지만 실제로는 `Car`, `ElectricCar` 두가지 클래스 정보가 공존한다.

> electricCar.charge() 호출


![상속메모리구조2](https://github.com/king-dong-gun/Java_basic/assets/160683545/2de0946c-b18d-46c1-a7b6-5457fa7cca0f)


> `electricCar.charge()`을 호출하면 참조값을 확인해서 `x001.charge()`를 호출한다. 하지만 상속관계인 경우에는
> 내부에 부모와 자식이 모두 존재한다. 이때는 **호출하는 변수의 타입(클래스)을 기준으로 선택되어 호출된다.
- 이 경우는 `electricCar` 타입이기 때문에 `electricCar`의 `charge()`를 호출한다.


> electricCar.move() 호출


![자바메모리구조3](https://github.com/king-dong-gun/Java_basic/assets/160683545/1867b575-d5d2-40f4-81c6-f4f36dfdbbc2)


> `ElectricCar`에는 `move()` 메소드가 없다. 상속관계에서 자식타입에 해당 기능이 없으면 부모타입으로 올라가서 찾는다
- 이 경우에는 부모클래스인 `Car`에 `move()`가 있기 때문에 부모에 있는 `move()` 메소드를 호출한다.

#### 4. 상속과 오버라이딩

> 부모에게서 상속 받을 기능을 자식이 재정의 하는 것을 메소드 오버라이딩이라고 한다.

```java
package extend.sec03;

public class ElectricCar extends Car {
    public void charge() {
        System.out.println("전기를 충전합니다.");
        
    }
    @Override
    public void move() {
        System.out.println("전기차를 빠르게 이동합니다.");
    }
}

```
```java
package extend.sec03;

public class CarMain {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.move();
        electricCar.charge();

        GasCar gasCar = new GasCar();
        gasCar.move();
        gasCar.fillUp();
    }
}
```
> 출력결과

![상속오버라이드](https://github.com/king-dong-gun/Java_basic/assets/160683545/5b9088ea-1fea-41b8-b5ea-cd2fb9ef9616)



- 부모의 기능을 자식이 재정의하여 `ElectricCar`의 `move()`를 호출하면 `Car`가 아니라 `ElectricCar`의 `move()`가 호출된다.

##### @Override
- @ 이가 붙은 부분을 **애노테이션**이라고 한다. 주석과 비슷한 느낌...?
- 코드의 명확성을 위해 붙여주는 것이 좋다.

![상속오버라이드구조](https://github.com/king-dong-gun/Java_basic/assets/160683545/512c151b-f82e-4876-97c9-25ccdf2b9963)


![오버라이드메모리구조](https://github.com/king-dong-gun/Java_basic/assets/160683545/95777403-1a30-436d-8888-af6bd4c3018a)


1. `electricCar.move()` 호출
2. 호출한 타입이 `ElectricCar`이므로 인스턴스 내부의 `ElectricCar`타입에서 시작
3. `ElectricCar`타입에 `move()` 메소드가 있으므로 해당 메소드 실행

##### 오버로딩과 오버라이딩
- 메소드 오버로딩
> 메소드 이름이 같고 매개변수(파라미터)가 다른 메소드를 여러개 정의하는 것을 메소드 오버로딩
> 메소드를 여러개 정의한 것이라 이해하자.

- 메소드 오버라이딩
> 하위 클래스에서 상위 클래스의 메소드를 재정의하는 과정을 메소드 오버라이딩, 상속관계에서 사용한다
> **재정의**이고도 하며 기존 기능을 다시 정의한다고 이해하자.


##### 메소드 오버라이딩 조건
- **메소드 이름**: **메소드 이름**이 같아야 한다.
- **메소드 매개변수(파라미터)**: **매개변수(파라미터) 타입, 순서, 개수**가 같아야 한다.
- **반환 타입**: **반환 타입**이 같아야 한다.
- **접근 제어자**: 오버라이딩 메소드의 접근 제어자는 **상위 클래스의 메소드보다 더 제한적이어서는 안된다**.
- **예외**: 오버라이딩 메소드는 **상위 클래스의 메소드보다 더 많은 체크 예외를 thorws로 선언할 수 없다**.
- **static, final, private**: **static, final, private** 키워드는 오버라이딩 될 수 없다.
- **생성자 오버라이딩**: **생성자는 오버라이딩 할 수 없다**.

#### 접근제어와 메모리 구조
> 부모 클래스
```java
package extend.access.parent;

public class Parent {

    public int publicValue;
    protected int protectedValue;
    int defaultValue;
    private int privateValue;

    public void publicMethod() {
        System.out.println("Parent.publicMethod");
    }

    protected void protectedMethod() {
        System.out.println("Parent.protectedMethod");
    }

    void defaultMethod() {
        System.out.println("Parent.defaultMethod");
    }

    public void printParent() {
        System.out.println("==Parent 메소드 안==");
        System.out.println("publicValue = " + publicValue);
        System.out.println("protectedValue = " + protectedValue);
        System.out.println("defaultValue = " + defaultValue);       // 부모 메소드 안에서 접근가능
        System.out.println("privateValue = " + privateValue);       // 부모 메소드 안에서 접근가능

        // 부모 메소드 안에서 모두 접근 가능
        defaultMethod();
        protectedMethod();


    }
}


```
> 자식 클래스
```java
package extend.access.child;

import extend.access.parent.Parent;

public class Child extends Parent {
    public void call() {
        publicValue = 1;
        protectedValue = 1; // 상속관계 or 같은 패키지 접근 가능
//        defaultValue = 1; // 다른 패키지 접근 불가, 컴파일 오류
//        privateValue = 1;   // 다른 패키지 접근 불가, 컴파일 오류

        publicMethod();
        protectedMethod();  // 상속관계 or 같은 패키지 접근 가능
//        defaultMethod();    // 다른 패키지 접근 불가, 컴파일 오류
//        priavteMethod();    // 다른 패키지 접근 불가, 컴파일 오류

        printParent();
    }
}

```

> 메인클래스
```java
package extend.access;

import extend.access.child.Child;

public class ExtendsAccessMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.call();
    }
}

```
> 실행결과

![상속접근제어자출력](https://github.com/king-dong-gun/Java_basic/assets/160683545/e99b34ac-3528-4944-90ed-c55f47283634)



- `publicValue`: 부모의 `public`필드에 접근한다.
- `protectedValue`: 부모의 `protected`필드에 접근한다. **상속관계**이므로 접근 가능하다.
- `defaultValue`: 부모의 `defalut`필드에 접근한다. 다른 패키지이므로 접근할 수 없다
- `privateValue`: 부모의 `private`필드에 접근한다. `private`는 모든 외부 접근을 막으므로 자식이라도 호출할 수 없다.


![접근제어와메모리구조](https://github.com/king-dong-gun/Java_basic/assets/160683545/833aae66-8f28-4b0f-b932-d326c7fa4ac6)


- 본인 타입에 없으면 부모 타입에서 기능을 찾는다. 이때 접근 제어자가 영향을 준다.


#### super - 부모참조
- 부모와 자식의 필드명이 같거나 메소드가 오버라이딩 되있으면, 자식에서 부모의 필드나 메소드를 호출할 수 없다.
- `super` 키워드를 사용하면 부모를 참조할 수 있다.


![super참조1](https://github.com/king-dong-gun/Java_basic/assets/160683545/78a699cd-ee20-4b4a-9220-e16d6664e2ab)

> 부모 클래스
```java
package extend.super1;

public class Parent {
    public String value = "parent";

    public void hello() {
        System.out.println("Parent.hello");
    }
}

```
> 자식 클래스

```java
package extend.super1;

public class Child extends Parent {
    public String value = "child";

    @Override
    public void hello() {
        System.out.println("Child.hello");
    }

    public void call() {
        System.out.println("this.value = " + this.value);  // this 생략가능
        System.out.println("super.value = " + super.value);
    }
}

```
> 메인클래스
```java
package extend.super1;

public class SuperMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.call();
        child.hello();

        Parent parent = new Parent();
        parent.hello();

    }
}

```
> 실행결과
![super출력](https://github.com/king-dong-gun/Java_basic/assets/160683545/8258dd07-25b1-469c-876c-f528aba2c15d)


- `call()` 메소드
  - `this`는 자기 자신의 참조를 뜻한다. -> 생략가능
  - `super`는 부모 클래스에 대한 참조를 뜻한다.
  - 필드 이름과 메소드 이름이 같지만 `super를 사용해서 부모 클래스에 있는 기능을 사용할 수 있다.


![super메모리](https://github.com/king-dong-gun/Java_basic/assets/160683545/16013ac5-c822-403a-87a0-d1cbf2d24e32)



#### 6. super - 생성자

> 최상위 부모 클래스
```java
package extend.super2;

public class ClassA {
  public ClassA() {
    System.out.println("ClassA 생성자");
  }
}

```
> 다음 부모 클래스
```java
package extend.super2;

public class ClassB extends ClassA {
    public ClassB(int a) {
        super();    // 기본 생성자 생략 가능
        System.out.println("ClassB 생성자 a = " + a);
    }

    public ClassB(int a, int b) {
        super();    // 기본 생성자 생략 가능
        System.out.println("ClassB 생성자 b = " + b);
    }
}

```

- ClassB는 ClassA를 상속 받아 생성자의 첫줄에 `super`를 사용해서 부모 클래스의 생성자를 호출해야 한다.
- 부모 클래스의 생성자가 기본 생성자(파라미터가 없는 생성자)인 경우에는 `super()`를 생략할 수 있다.
> 자식 클래스
```java
package extend.super2;

public class ClassC extends ClassB {
    public ClassC() {
        super(10, 20);
        System.out.println("ClassC 생성자");
    }
}

```

- ClassC는 ClassB의 두 생성자를 상속 받았다.
  - `ClassB(int a)`
  - `ClassB(int a, int b)`
- 생성자는 하나만 호출할 수 있다. 두 생성자 중 하나를 선택하면 된다.
  - `super(10, 20)`를 통해 부모 클래스의 `ClassB(int a, int b)`를 선택
- **참고로 ClassC의 부모인 ClassB에는 기본 생성자가 없다. 따라서 부모의 기본 생성자를 호출하는 `super()`를 사용하거나 생략할 수 없다.

> 메인 클래스
```java
package extend.super2;

public class Super2Main {
    public static void main(String[] args) {
        ClassC classC = new ClassC();
    }
}

```

> 실행결과
![super생성자출력](https://github.com/king-dong-gun/Java_basic/assets/160683545/da054688-db90-4180-b882-2a65d64a3cc8)

- ClassA -> ClassB -> ClassC 순서로 실행된다. 생성자의 실행 순서가 최상위 부모부터 실행되어 하나씩 내려오는 것이다.
  - **자식 생성자의 첫줄에서 부모의 생성자를 호출하기 때문이다.


![super실행순서](https://github.com/king-dong-gun/Java_basic/assets/160683545/e8ecc9b3-f083-4ede-b30f-29bc5e84b167)




##### 정리
- 상속 관계의 생성자 호출은 부모에서 자식 순서로 실행된다.
  - 부모 데이터를 먼저 초기화하고, 다음에 자식의 데이터를 초기화한다.
- 상속 관계에서 자식 클래스의 생성자 첫줄에 반드시 `super()`를 호출해야 한다.
  - 기본 생성자(super())인 경우 생략 가능하다.