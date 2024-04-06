package construct.sec04;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    MemberConstruct(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        System.out.println("생성자 호출! name >> " + this.name + ", age >> " + this.age + ", grade >> " + this.grade);
    }
}
