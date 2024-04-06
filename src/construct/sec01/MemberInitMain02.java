package construct.sec01;

public class MemberInitMain02 {
    public MemberInitMain02() {
    }

    public static void main(String[] args) {
        MemberInit member01 = new MemberInit();
        initMember(member01, "김동건", 26, 60);
        MemberInit member02 = new MemberInit();
        initMember(member02, "최재영", 27, 100);
        MemberInit[] members = new MemberInit[]{member01, member02};
        MemberInit[] var4 = members;
        int var5 = members.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            MemberInit member = var4[var6];
            System.out.println("이름 >> " + member.name + ", 나이 >> " + member.age + ", 점수 >> " + member.grade);
        }

    }

    static void initMember(MemberInit member, String name, int age, int grade) {
        member.name = name;
        member.age = age;
        member.grade = grade;
    }
}
