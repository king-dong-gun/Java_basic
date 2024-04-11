## 생성자

### 목차
1. 생성자가 필요한 이유
2. this
3. 생성자 - 도입
4. 기본 생성자
5. 생성자
    - 오버로딩
    - this()
6. 문제풀이
7. 정리

#### 생성자가 필요한 이유
> **생성자**는 객체가 생성될 때 자동으로 호출되는 특수 목적의 맴버함수(메소드)로 객체의 초기화를 위해 사용된다.

```java
 package construct;

public class MemberInit {
    String name;
    int age;
    int grade;
}

```

```java
 package construct;

public class MethodInitMain2 {
    public static void main(String[] args) {
        MemberInit member1 = new MemberInit();
        initMember(member1, "user1", 15, 90);
        MemberInit member2 = new MemberInit();
        initMember(member2, "user2", 16, 80);
        MemberInit[] members = {member1, member2};
        for (MemberInit s : members) {
            System.out.println("이름:" + s.name + " 나이:" + s.age + " 성적:" + s.grade);

        }
    }

    static void initMember(MemberInit member, String name, int age, int grade) {
        member.name = name;
        member.age = age;
        member.grade = grade;
    }
}

```
- `initMember()` 메소드를 사용해 반복을 제거.

#### this
> `initMember()` 추가
```java
 package construct;

public class MemberInit {
    String name;
    int age;
    int grade;

    //추가
    void initMember(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
```

```java
    package construct;

public class MethodInitMain3 {
    public static void main(String[] args) {
        MemberInit member1 = new MemberInit();
        member1.initMember("user1", 15, 90);
        MemberInit member2 = new MemberInit();
        member2.initMember("user2", 16, 80);
        MemberInit[] members = {member1, member2};
        for (MemberInit s : members) {
            System.out.println("이름:" + s.name + " 나이:" + s.age + " 성적:" + s.grade);
        }
    }
}
```
- `initMember()`는 `Member`에 초기값 설정 기능을 제공하는 메소드이다. 다음과 같이 메소드를 호출하면 객체의 맴버 변수에 인자로 넘어온 값을 채운다.

> this
