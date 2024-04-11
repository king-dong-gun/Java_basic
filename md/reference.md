## 기본형과 참조형

### 목차

1. 기본형, 참조형
2. 변수와 초기화
3. Null
4. 문제풀이
5. 정리

#### 1. 기본형, 참조형

> **자바에서 참조형을 제대로 이해하는 것이 정말 중요하다.**

- 변수의 데이터 타입을 기본형과 참조형으로 분류할 수 있다.
    - 기본형: `int`, `long`, `double`, `boolean`처럼 변수에 사용할 값을 직접 넣을 수 있는 데이터 타입
    - 참조형: `Student student`, `int[] students`와 같이 데이터에 접근하기 위한 참조(주소)를 저장하는 데이터 타입
  > *참조형은 객체 또는 배열에 사용된다*.

- 값
    - 기본형은 숫자 10, 20 같은 실제 사용하는 값을 변수에 담을 수 있어 해당 값을 바로 사용할 수 있다.
    - 참조형은 실제 사용하는 값을 변수에 담는 것이 아닌 객체의 위치를 저장한다.
        - 객체는 .(dot)을 통해 메모리에 생성된 객체를 찾아가야 사용할 수 있다.
        - 배열은 []를 통해 메모리에 생성된 배열을 찾아가야 사용할 수 있다.

- 계산
    - 기본형은 들어있는 값을 그대로 계산에 사용할 수 있다.
    - 참조값은 계산을 할 수 없다.
  > *.(dot)을 통해 객체의 기본형 맴버변수에 접근한 경우에는 연산 할 수 있다.

> ** TIP >> 기본형은 소문자로 시작하고, 클래스는 대문자로 시작한다.(클래스는 모두 참조형)**

##### 변수 대입

```java
public class VarChange1 {
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
//a 변경
        a = 20;
        System.out.println("변경 a = 20");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
//b 변경
        b = 30;
        System.out.println("변경 b = 30");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
```

> 실행결과

![varChange출력값](https://github.com/king-dong-gun/Java_basic/assets/160683545/e0b4429d-3b49-4caf-bb2a-e4c192b5bf37)

##### 참조형 변수대입

```java
 package ref;

import ref.method.Data;

public class VarChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        Data dataB = dataA;
        System.out.println("dataA 참조값=" + dataA);
        System.out.println("dataB 참조값=" + dataB);
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value);
//dataA 변경
        dataA.value = 20;
        System.out.println("변경 dataA.value = 20");
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value);
//dataB 변경
        dataB.value = 30;
        System.out.println("변경 dataB.value = 30");
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value);
    }
}
```

> 실행결과


![varChange02출력값](https://github.com/king-dong-gun/Java_basic/assets/160683545/ba226e73-a024-49fe-8c11-b019e165e4e5)

![data참조값복사01](https://github.com/king-dong-gun/Java_basic/assets/160683545/62677b32-6547-4e9a-9ecd-34dd9718b6f7)



> dataA 변수는 Data 클래스를 통해 만들어져 참조형이다. 이 변수는 Data형 객체의 참조값을 저장한다.



![data참조값복사2](https://github.com/king-dong-gun/Java_basic/assets/160683545/0ea43ba3-be51-42b6-91ec-d11dd63e2784)



> 변수의 대입은 변수에 들어있는 값을 복사해 대입한다. 변수 dataA에는 참조값 x001이 들어가있다 이 참조값을 복사해 dataB에 대입한다.

- 참고 dataA가 가리키는 인스턴스를 복사하는 것이 아닌 변수에 들어있는 참조값만 복사해서 전달!!!!

![data참조값복사3](https://github.com/king-dong-gun/Java_basic/assets/160683545/9a6328e2-ac7a-4a0e-9c4d-52c792ae809d)


> dataA가 가르키는 x001 인스턴스의 value값을 10에서 20으로 변경한다. dataA와 dataB는 같은 x001 인스턴스를 참조하기 때문에 둘 다 같은 값인 20을 출력한다.



![data참조값복사4](https://github.com/king-dong-gun/Java_basic/assets/160683545/440e9913-c160-4157-a92f-cf8d4b468865)



> dataB가 가리키는 x001의 인스턴스의 value값을 20에서 30으로 변경한다. dataA와 dataB는 같은 x001 인스턴스를 참조하기 때문에 둘 다 같은 값인 30을 출력한다.

##### 메소드 호출

- 메소드를 호출할 때 사용하는 매개변수(파라미터)도 결국 변수이다. 따라서 메소드를 호출할 때매개변수에 값을 전달하는 것도 앞서 설명한 것처럼 값을 복사해서 전달한다.

```java

package ref;

public class MethodChange1 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("메서드 호출 전: a = " + a);
        changePrimitive(a);
        System.out.println("메서드 호출 후: a = " + a);
    }

    static void changePrimitive(int x) {
        x = 20;
    }
}
```

> 실행결과

![메소드호출결과](https://github.com/king-dong-gun/Java_basic/assets/160683545/09787eae-b31f-4c72-b1cd-1680c226e34f)

1. 메소드 호출

![메소드호출1](https://github.com/king-dong-gun/Java_basic/assets/160683545/001c1b1c-be89-45b8-af0d-1fa2f36c8bab)

- a, x는 각각 10의 숫자를 가지고 있다.


2. 메소드 안에서 값을 변경

![메소드호출2](https://github.com/king-dong-gun/Java_basic/assets/160683545/9bce4dd3-e7ca-4c7e-bdb9-72108297446a)

- 메소드 안에서 x = 20 으로 새로운 값을 대입한다. x의 값만 20으로 변경되고, a의 값은 10으로 유지된다.


3. 메소드 종료

![메소드호출3](https://github.com/king-dong-gun/Java_basic/assets/160683545/e71a00a6-8935-4db2-bbea-6e4f326e1192)

- 메소드 종료후 값을 확인해보면 a는 10이 출력된다. 메소드가 종료되면 매개변수 x는 제거된다.

##### 참조형 메소드 호출

```java

package ref;

import ref.method.Data;

public class MethodChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        System.out.println("메서드 호출 전: dataA.value = " + dataA.value);
        changeReference(dataA);
        System.out.println("메서드 호출 후: dataA.value = " + dataA.value);
    }

    static void changeReference(Data dataX) {
        dataX.value = 20;
    }
}
```

> 실행결과

![참조형메소드호출](https://github.com/king-dong-gun/Java_basic/assets/160683545/d8f6c2dc-cbf8-4fc3-85e9-8b4392c5a458)



> Data 인스턴스를 생성하고, 참조값을 dataA 변수에 담고 value에 숫자 10을 할당한 상태

![참조형메소드호출2](https://github.com/king-dong-gun/Java_basic/assets/160683545/49b7150c-6e9d-4e1e-9c2a-36d426f24850)

1. 메소드 호출

![참조형메소드호출3](https://github.com/king-dong-gun/Java_basic/assets/160683545/61e007d1-f060-489e-b6e6-6eea3aaf4b66)

- 메소드를 호출할 때 매개변수 dataX에 dataA의 값을 전달한다.

```
Data data = dataA 
```

> 변수 dataA는 참조값 x001을 가지고 있으므로 참조값을 복사해서 전달했다. 따라서 dataA, dataB에는 같은 참조값인 x001을 가지게 된다.

2. 메소드 안에서 값을 변경

![참조형메소드호출4](https://github.com/king-dong-gun/Java_basic/assets/160683545/053494bf-fc02-40e8-9f3d-a4f00a4912ad)

- 메소드 안에서 `dataX.value = 20` 으로 새로운 값을 대입한다.
- 참조값을 통해 x001 인스턴스에 접근하고 그 안에 있는 value의 값을 20으로 변경했다.

> dataA, dataX 모두 같은 x001 인스턴스를 참조하기 때문에 dataA.value, dataX.value 둘다 20을 가지게 된다.



![참조형메소드호출5](https://github.com/king-dong-gun/Java_basic/assets/160683545/624b3784-1bcc-4ecc-b320-f5d8a5ef1b15)

- 메소드 종료 후 dataA.value 값을 확인하면 20으로 변경된 것을 확인할 수 있다.

#### 2. 변수와 초기화

##### 변수의 종류

- 맴버변수(필드): 클래스에 선언
- 지역변수: 메소드에 선언, 매개변수도 지역변수의 한 종류이다.

```java
 public class Student {
    String name;
    int age;
    int grade;
}
```

> `name`, `age`, `grade`는 맴버 변수이다.

```java
 public class ClassStart3 {
    public static void main(String[] args) {
        Student student1;
        student1 = new Student();
        Student student2 = new Student();
    }
}
```

> `student1`, student2`는 지역 변수이다.

##### 변수의 값 초기화

- 맴버 변수: 자동 초기화
- 지역 변수: 수동 초기화

##### 맴버변수의 초기화

```java
package ref;

public class InitData {
    int value1; //초기화 하지 않음 int value2 = 10; //10으로 초기화
}
```

```java
package ref;

public class InitMain {
    public static void main(String[] args) {
        InitData data = new InitData();
        System.out.println("value1 = " + data.value1);
        System.out.println("value2 = " + data.value2);
    }
}

```

> 실행결과

![맴버변수초기화출력값](https://github.com/king-dong-gun/Java_basic/assets/160683545/302166fc-b97a-4b6b-8231-8bce1e33303e)

> value1은 초기값을 지정하지 않았지만 자동으로 초기화되어 0으로 초기화된다.

> value2는 10으로 초기값을 지정했기 때문에 객체를 생성할 때 10으로 초기화된다.

#### 3. Null

##### null

- 참조형 변수에는 객체가 있는 위치를 가르키는 참조값이 들어간다. 하지만 가리키는 대상이 없다면 `null이라는 특별한 값을 넣을 수 있다.

> 앞에서 만든 Data 클래스를 이용해서 작성

```java

public class NullMain1 {
    public static void main(String[] args) {
        Data data = null;
        System.out.println("1. data = " + data);
        data = new Data();
        System.out.println("2. data = " + data);
        data = null;
        System.out.println("3. data = " + data);
    }
}
```

> 실행결과


![null01](https://github.com/king-dong-gun/Java_basic/assets/160683545/67d360e6-8cdb-467a-91a1-c0abc0795c5c)

- Data 타입을 받을 수 있는 data(참조형 변수)에 `null`값을 할당했다. 이후에 새로운 Data 객체를 생성해 그 참조값을 data 변수에 할당했다.
- 이후 data 변수가 참조할 객체가 존재한다.
- 마지막에는 data에 다시 null값을 할당해 앞서 만든 data 변수는 Data 인스턴스를 더는 참조하지 못한다.

##### NullPointException

- `NullPointException`은 이름 그대로 null을 가르킬때 발생하는 예외이다.
- 참조값이 `null`이라면 찾아갈 수 있는 객체(인스턴스)가 없기 때문에 `null`에 .(dot)을 찍었을 때 발생한다.

```java
package ref;

public class NullMain2 {
    public static void main(String[] args) {
        Data data = null;
        data.value = 10;// NullPointerException 예외 발생 System.out.println("data = " + data.value);
    }
}
```

![nullPoiintException](https://github.com/king-dong-gun/Java_basic/assets/160683545/8dbfea2f-2e16-4300-912a-6385d6b22ef7)

```java
data.value =10;
        null.value =10;    // data에는 null값이 들어가 있다.
```

> `null`은 참조할 주소가 존재하지 않다는 뜻이다. 따라서 참조할 객체 인스턴스가 존재하지 않으므로 java.lang.NullPointerException
> 이 발생하고, 프로그램이 종료된다. 예외가 발생했기 때문에 그 다음 로직은 수행되지 않는다.

##### 맴버변수와 null

> 기존의 data 클래스 사용, BigData 클래스 생성

```java
package ref;

public class BigData {
    Data data;
    int count;
}
```

```java
package ref;

public class NullMain3 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        System.out.println("bigData.count=" + bigData.count);
        System.out.println("bigData.data=" + bigData.data);
        //NullPointerException
        System.out.println("bigData.data.value=" + bigData.data.value);
    }
}
```
> 실행결과

![맴버변수nill](https://github.com/king-dong-gun/Java_basic/assets/160683545/21d815a0-c4ab-446a-8c92-ad75f3fe330b)


- `bigData.count`는 0으로 초기화 되므로 0이 출력된다.
- `bigData.data`는 참조값인 `null`이 출력된다. 이 변수는 아직 아무것도 참조하지 않는다.
- `bigData.data.value`는 date의 값이 `null`이므로 `null`에 .(dot)을 찍게되고 참조할 곳이 없으므로 `NullPointerException`가 발생한다.

> 이 문제를 해결하려면 Data 인스턴스를 만들고 BigData.data 맴버변수에 참조값을 할당하면 된다.

```java
package ref;

public class NullMain4 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        bigData.data = new Data();
        System.out.println("bigData.count=" + bigData.count);
        System.out.println("bigData.data=" + bigData.data);
        System.out.println("bigData.data.value=" + bigData.data.value);
    }
}
```
> 실행결과

![null참조값할당](https://github.com/king-dong-gun/Java_basic/assets/160683545/38f333b6-4cb8-4af6-abb0-fd0af4107595)


> 실행과정
```java
bigData.data.value;
x001.data.value;     // bigData는 x001의 참조값을 가진다.
x002.value;          // x001.data는 x002의 참조값을 가진다.
```

#### 문제풀이
##### 상품 주문 개발 시스템 - 사용자 입력
> 상품 주문 시스템을 사용자 입력을 받아 생성
- 주문수량 입력
- 가격, 수량, 상품명을 입력
- 입력이 끝나면 등록한 상품과 총 결제 금액을 출력

```java
package ref.ex;

public class ProductOrder {
    String productName;
    int price;
    int quantity;
}
```

```java
package ref.ex;

import java.util.Scanner;

public class ProductOrderMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        ProductOrder[] orders = new ProductOrder[n];
        for (int i = 0; i < orders.length; i++) {

            System.out.println((i + 1) + "번째 주문 정보를 입력하세요.");
            System.out.print("상품명: ");
            String productName = scanner.nextLine();
            System.out.print("가격: ");
            int price = scanner.nextInt();
            System.out.print("수량: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // 입력 버퍼를 비우기 위한 코드
            orders[i] =

                    createOrder(productName, price, quantity);
        }

        printOrders(orders);

        int totalAmount = getTotalAmount(orders);
        System.out.

                println("총 결제 금액: " + totalAmount);
    }

    static ProductOrder createOrder(String productName, int price, int quantity) {
        ProductOrder order1 = new ProductOrder();
        order1.productName = productName;
        order1.price = price;
        order1.quantity = quantity;
        return order1;
    }

    static void printOrders(ProductOrder[] orders) {
        for (ProductOrder order : orders) {
            System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity);
        }
    }

    static int getTotalAmount(ProductOrder[] orders) {
        int totalAmount = 0;
        for (ProductOrder order : orders) {
            totalAmount += order.price * order.quantity;
        }
        return totalAmount;
    }
}

```
> 실행결과
![문제풀이](https://github.com/king-dong-gun/Java_basic/assets/160683545/ddc8dd7a-607d-4c55-b2ec-0a2411211118)



#### 정리
##### 자바는 항상 변수의 값을 복사해서 대입한다.
- 기본형, 참조형 모두 항상 변수에 있는 값을 복사해서 대입한다.
  - 기본형이면 변수에 들어 있는 실제 사용하는 값을 복사한다.
  - 참조형이면 변수에 들어 있는 참조값을 복사해서 대입한다.

##### 기본형 참조형
- 기본형을 제외한 나머지 변수는 모두 참조형
- 기본형 변수는 값을 직접 저장하지만, 참조형 변수는 참조(주소)를 저장한다.
- 기본형은 사용하는 값을 복사해서 전달하고, 참조형은 참조값을 복사해서 전달한다.
  - 실제 인스턴스가 복사되는 것이 아닌 인스턴스를 가르키는 참조값을 복사해서 전달하는 것이다.

##### 기본형 참조형 메소드 호출
- 기본형은 메소드 호출시 메소드 내부에서 매개변수(파라미터)의 값을 변경해도 변수 값에는 영향이 없다.
- 참조형은 메소드 호출시 메소드 내부에서 매개변수(파라미터)로 전달된 객체의 맴버 변수를 변경하며느, 호출자의 객체도 변경된다.






