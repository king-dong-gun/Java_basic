## 클래스와 데이터

1. 클래스가 필요한 이유
2. 클래스 도입
3. 객체 사용
4. 클래스, 객체, 인스턴스 정리
5. 예제 풀이

- 시작
- 리펙토링

### 1. 클래스가 필요한 이유

- Java에서는 클래스와 객체로 이루어져 있다.

```java
 package class1;

public class ClassStart1 {
    public static void main(String[] args) {
        String student1Name = "학생1";
        int student1Age = 15;
        int student1Grade = 90;
        String student2Name = "학생2";
        int student2Age = 16;
        int student2Grade = 80;
        System.out.println("이름:" + student1Name + " 나이:" + student1Age + " 성 적:" + student1Grade);
        System.out.println("이름:" + student2Name + " 나이:" + student2Age + " 성 적:" + student2Grade);
    }
}
```

> 코드를 보면 학생 2명을 다루어야 하기 때문에 다른 변수를 사용했다.
> 학생 수가 늘어날 때 마다 변수를 추가 선언하고 출력하는 코드도 추가 해야한다.

### 2. 클래스 도입

- 이 전 코드에서 클래스를 도입해서 간결하게 만들자.

#### Stundent 클래스

```java
 package class1;

public class Student {      // class 키워드를 통해 Student 정의
    String name;            // 필드 (맴버변수)
    int age;                // 필드 (맴버변수)
    int grade;              // 필드 (맴버변수)
}
```

- **클래스에 정의한 변수들을 맴버변수, 필드**라고 한다
    - **맴버변수**: 특정 클래스에 소속된 맴버
    - **필드**: 데이터 항목을 가르키는 전통적인 DB 또는 엑셀에서 각각의 항목을 필드라고 한다.
    - Java에서는 맴버변수 = 필드로 같은 뜻이다. 클래스에 소속된 변수들을 뜻한다.

#### ClassStart3

```java
package class1;

public class ClassStart3 {
    public static void main(String[] args) {
        Student student1;
        student1 = new Student();
        student1.name = "학생1";
        student1.age = 15;
        student1.grade = 90;
        Student student2 = new Student();
        student2.name = "학생2";
        student2.age = 16;
        student2.grade = 80;
        System.out.println("이름:" + student1.name + " 나이:" + student1.age + " 성 적:" + student1.grade);
        System.out.println("이름:" + student2.name + " 나이:" + student2.age + " 성 적:" + student2.grade);
    }
}
```

- 클래스와 **사용자 정의** 타입
    - 클래스를 사용하면 int, String과 같은 타입을 직접 만들 수 있다.
    - 사용자가 직접 정의하는 사용자 정의 타입을 만드려면 **클래스**가 필요하다.
    - 클래스를 사용해서 실제 메모리에 만들어진 실체를 **객체** 또는 **인스턴스**라고 한다.

#### 코드 분석

##### 1. 변수 선언

![클래스 변수 선언](https://github.com/king-dong-gun/Java_basic/assets/160683545/e510057d-667f-4b69-ad7f-1c554c0b5a31)


- Student 타입을 받을 수 있는 변수를 선언
- int는 정수, String은 문자를 담듯 Student 타입의 객체(인스턴스)를 받을 수 있다.

##### 2. 객체 생성

![클래스 객체 생성](https://github.com/king-dong-gun/Java_basic/assets/160683545/2fdfc20a-f3a2-4778-bcf9-3393ca5f65ac)



- 클래스를 기반으로 객체(인스턴스)를 생성해야 한다.
- `new Student()`는 `Student`클래스 정보를 기반으로 새로운 객체를 생성한다는 의미다.
    - 실제로 메모리에 `Student` 객체(인스턴스)를 생성한다.
- `Student`클래스는 `String name`, `int age`, `int grade` 맴버 변수를 가진다.

##### 3. 참조값 보관

![클래스 참조값 보관](https://github.com/king-dong-gun/Java_basic/assets/160683545/1ae827c5-b9c0-4511-bd3d-a0a4745ae3f3)



- 객체(인스턴스)를 생성하면 객체에 접근할 수 있는 참조값(주소)(ex -> x001)을 반환한다.
    - x001이 참조값이다 (예시)
- new 키워드로 객체가 생성되면, 참조값을 반환한다.
    - 앞서 선언한 변수 `Student student1`에 생성된 객체의 참조값(x001)을 보관한다.
- 이제 `Studnet student1` 변수는 메모리에 실제 `Student` 객체(인스턴스)의 참조값을 가지고 있다.
    - `student1` 변수는 방금 만든 객체의 참조값을 가지고 있으므로 `studnet1`의 변수를 통해 객체를 접근할 수 있다.

##### 참조값을 변수에 보관해야 하는 이유

> 생성된 `new Student()`에는 아무 이름이 없어 생성한 객체에 접근할 수 있는 방법이 필요하다.
> 그래서 객체를 생성할 때 반환되는 참조값을 어딘가에 보관해야 한다.

```java
Student student1 = new Student(); //1. Student 객체 생성
Student student1 = x001; //2. new Student()의 결과로 x001 참조값 반환
student1 = x001; //3. 최종 결과
```
- 이후에 `student2`까지 생성하면 `Student` 객체(인스턴스)가 메모리에 2개가 생성된다.
- 각각 참조값이 다르므로 구분할 수 있다


![클래스 참조값](https://github.com/king-dong-gun/Java_basic/assets/160683545/496756f8-5269-4a45-bcc1-db7349ff4e92)



### 3. 객체 사용
- 클래스를 통해 생성한 객체를 사용하려면 메모리에 존재하는 객체에 접근해야 한다.
- 객체에 접근하려면 .(점, dot)을 사용한다.

```java
//객체 값 대입 
student1.name = "학생1"; 
student1.age = 15; 
student1.grade = 90;

//객체 값 사용
        System.out.println("이름:" + student1.name + " 나이:" + student1.age + " 성적:" +
        student1.grade);

```




![객체 참조 그림](https://github.com/king-dong-gun/Java_basic/assets/160683545/1351f3c8-ea5a-477e-9a4f-5022074d5b2a)




#### 객체에 값 대입하기
- 객체가 가지고 있는 맴버 변수 `name`, `age`, `grade`에 값을 대입하려면 접근부터 한다.
- .(점, dot) 키워드는 `student1` 변수에 들어있는 참조값(x001)을 읽어 객체에 접근한다

```java
student1.name = "학생1"     //1. student1 객체의 name 멤버 변수에 값 대입
x001.name = "학생1"         //2.변수에 있는 참조값을 통해 실제 객체에 접근, 해당 객체의 name 멤버 변수에 값대입
```
##### `student1.name = "학생1` 코드 실행 전



![클래스 객체 값대입 전](https://github.com/king-dong-gun/Java_basic/assets/160683545/57b82aba-9929-4061-afea-e5deeaa6b33b)



##### `student1.name = "학생1` 코드 실행 후


![클래스 객체값 대입후](https://github.com/king-dong-gun/Java_basic/assets/160683545/239ba798-e019-4f58-82c0-de1b9a06e6ab)





- `student1`변수가 가지고 있는 참조값을 통해 실제 객체에 접근해 x001 객체가 있는 곳의 맴버변수에 "학생1" 데이터가 저장된다.

### 4. 클래스, 객체, 인스턴스 정리
#### 클래스
1. 객체를 생성하기 위한 '틀', '설계도'의 의미이다.
2. 객체가  가져야할 속성(변수), 기능(메소드)를 정의한다.

#### 객체
1. 클래스에서 정의한 속성과 기능을 가진 실체이다.
2. 같은 클래스에 만들어도 각 객체는 서로 다른 속성을 가진다.

#### 인스턴스
1. 특정 클래스로부터 생성된 객체를 의미한다
   - 객체와 인스턴스는 자주 혼용되니 주의!!
2. 주로 객체가 어떤 클래스에 속해 있는지 강조할 때 사용한다
   - `student1`의 객체는 `Student`클래스의 인스턴스다!!!

### 5. 예제 풀이

#### 영화 리뷰 관리1
[MovieReviw](https://github.com/king-dong-gun/Java_basic/blob/master/src/classStart/ex/exam01/MovieReview.java)
[MovieReviwMain01](https://github.com/king-dong-gun/Java_basic/blob/master/src/classStart/ex/exam01/MovieReviewMain.java)


#### 상품 주문 시스템 개발
[ProdictOrder](https://github.com/king-dong-gun/Java_basic/blob/master/src/classStart/ex/exam02/ProductOrder.java)
[ProdictOrderMain](https://github.com/king-dong-gun/Java_basic/blob/master/src/classStart/ex/exam02/ProductOrderMain.java)



