## 접근 제어자 종류

### 자바 접근 제어자는 4가지를 제공
1. `private` : 외부 호출을 막음
2. `public` : 모든 외부 호출 허용
3. `default` : 같은 패키지 내에서 호출 허용
4. `protected` 같은 패키지 내 호출 허용, 패키지가 달라도 상속관계의 호출은 허용

### 접근제어자 사용위치 
1. 접근 제어자는 필드, 메소드, 생성자에 사용
2. 추가로 클래스 레벨에도 일부 접근 제어자 사용 가능
 
```java
public class Speaker {  // 클래스 레벨
    
    private int volume;     // 필드
    
    public Speaker(int volume) {} // 생성자
    
    public void volumeUp(){}    // 메소드
    public void volumeDown(){}
    public void showVolume(){}
}
```

### 같은 패키지일 경우 접근 제어자
```java
package access.a;

public class AccessData {
    public int publicField;
    int defualtField;
    private int privateField;

    public void publicMethod() {
        System.out.println("publicMethod 호출 >> " + publicField);
    }
    void defualtMethod() {
        System.out.println("defualtMethod 호출  >> " + defualtField);
    }
    private void privateMethod() {
        System.out.println("privateMethod 호출 >> " + privateField);
    }

    public void innerAccess() {
        System.out.println("내부 호출");
        publicField = 100;
        defualtField = 200;
        publicField = 300;
        publicMethod();
        defualtMethod();
        privateMethod();
    }
}
```
```java
package access.a;

public class AccessInnerMain {
    public static void main(String[] args) {
        AccessData accessData = new AccessData();

        // public 호출
        accessData.publicField = 1;
        accessData.publicMethod();

        // 같은 패키지 default 호출 가능
        accessData.defualtField = 2;
        accessData.defualtMethod();

        // private 호출 불가
        // accessData.privateField = 3;
        // accessData.privateMethod();

        accessData.innerAccess();
    }
}
```
> 실행결과

![이너메인출력결과](https://github.com/king-dong-gun/Java_basic/assets/160683545/96ebf49b-a61d-4b4c-ba28-6edc6ec76a7d)



> 결론
> 1. `private` 다른 패키지 접근 불가
> 2. `innerAccess()`메소드 내부 패키지 접근 가능!

### 패키지가 다를 경우의 접근 제어자
```java
package access.b;

import access.a.AccessData;

public class AccessOuterMain {
    public static void main(String[] args) {
        AccessData accessData = new AccessData();

        // public 호출
        accessData.publicField = 1;
        accessData.publicMethod();

        // 다른 패키지 default 호출 불가
        // accessData.defualtField = 2;
        // accessData.defualtMethod();

        // private 호출 불가
        // accessData.privateField = 3;
        // accessData.privateMethod();

        accessData.innerAccess();
    }
}
```
> 실행결과
![아우터메인출력결과](https://github.com/king-dong-gun/Java_basic/assets/160683545/388db5a0-3b14-4792-bc03-4c5e9b0bf7da)




> 결론
> 1. `private`, `default` 다른 패키지 접근 불가
> 2. `innerAccess()`메소드 외부 패키지 접근 가능!

**참고** 
- 생성자도 접근제어자 관점에서 메소드와 같다


## 접근제어자 사용 - 클래스 레벨

### 클래스 레벨의 접근제어자 규칙
- `public`, `default`만 사용가능
- `public`클래스는 반드시 파일명과 이름이 동일해야함
    - 하나의 자바 파일에 `public`클래스는 하나만 생성가능
    - 하나의 자바 파일에 `default`클래스는 무한정 생성가능
    - 
### 같은 패키지의 클래스 생성
```java
package access.sec03;

public class PublicClass {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        DefaultClass1 defaultClass1 = new DefaultClass1();
        DefaultClass2 defaultClass2 = new DefaultClass2();

    }
}
class DefaultClass1 {

}
class DefaultClass2 {

}
```
> 같은 패키지 접근 가능

### 다른 패키지의 클래스 생성
```java
package access.b;

import access.sec03.PublicClass;

public class PublicClassOuterMain {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        
        // 다른 패키지 접근 불가
        // DefaultClass1 defaultClass1 = new DefaultClass1();
        // DefaultClass2 defaultClass2 = new DefaultClass2();
    }
}
```
> 다른 패키지의 클래스 접근 불가


### 캡슐화

#### 캡슐화 정의
- 데이터와 해당 데이터를 처리하는 메소드를 하나로 묶어 외부에서의 접근을 제한하는 것
- 데이터의 직접적인 변경을 방지하거나 제한 가능
- 속상과 기능을 하나로 묶고 외부로 필요한 **기능만 노출**, 나머지는 내부로 숨기는 것
> **캡슐화에서 가장 필수로 숨겨야 하는 것은 속성(데이터)이다!!!!!**
  - 객체의 데이터는 객체가 제공하는 기능인 메소드를 통해 접근한다

#### 입출금 관리 프로그램
[BankAccount](https://github.com/king-dong-gun/Java_basic/blob/master/src/access/encapsulation/BankAccount.java)
[BankAccountMain](https://github.com/king-dong-gun/Java_basic/blob/master/src/access/encapsulation/BankAccountMain.java)
**private**
- `balance` 데이터 필드는 외부 직접 노출 X, `BankAccount`가 제공하는 메소드를 통해서만 접근
- `isAmountValid` 입력 금액을 검증하는 기능은 내부에서만 필요한 기능!! >> `private` 사용

**public**
- `deposit` 입금
- `withdraw` 출금
- `getBalance` 잔고
> 만약 `isAmountValid`가 `public`이라면?
- 잔고를 임의로 무한정 늘리고 출금하는 불상사가 발생한다.....

 