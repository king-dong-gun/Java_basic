package construct.sec04;

public class MemberConstructMain01 {
    public MemberConstructMain01() {
    }

    public static void main(String[] args) {
        MemberConstruct member01 = new MemberConstruct("김동건", 26, 60);
        MemberConstruct member02 = new MemberConstruct("최재영", 27, 100);
        MemberConstruct[] memberConstructs = new MemberConstruct[]{member01, member02};
        MemberConstruct[] var4 = memberConstructs;
        int var5 = memberConstructs.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            MemberConstruct memberCon = var4[var6];
            System.out.println("이름 >> " + memberCon.name + ", 나이 >> " + memberCon.age + ", 점수 >> " + memberCon.grade);
        }

    }
}
