package construct.sec02;

public class MemberInitMain03 {
    public MemberInitMain03() {
    }

    public static void main(String[] args) {
        MemberInit member01 = new MemberInit();
        member01.memberInit("김동건", 26, 60);
        MemberInit member02 = new MemberInit();
        member02.memberInit("최재영", 27, 100);
        MemberInit[] memberInit = new MemberInit[]{member01, member02};
        MemberInit[] var4 = memberInit;
        int var5 = memberInit.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            MemberInit init = var4[var6];
            System.out.println("이름 >> " + init.name + ", 나이 >> " + init.age + ", 점수 >> " + init.grade);
        }
    }
}
