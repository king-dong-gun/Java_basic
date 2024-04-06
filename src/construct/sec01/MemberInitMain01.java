package construct.sec01;

public class MemberInitMain01 {
    public MemberInitMain01() {
    }

    public static void main(String[] args) {
        MemberInit member01 = new MemberInit();
        member01.name = "김동건";
        member01.age = 26;
        member01.grade = 60;
        MemberInit member02 = new MemberInit();
        member02.name = "최재영";
        member02.age = 27;
        member02.grade = 100;
        MemberInit[] members = new MemberInit[]{member01, member02};
        MemberInit[] var4 = members;
        int var5 = members.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            MemberInit member = var4[var6];
            System.out.println("이름 >> " + member.name + ", 나이 >> " + member.age + ", 점수 >> " + member.grade);
        }

    }
}
