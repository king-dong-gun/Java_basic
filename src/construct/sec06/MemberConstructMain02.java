package construct.sec06;

public class MemberConstructMain02 {
    public MemberConstructMain02() {
    }

    public static void main(String[] args) {
        MemberConstruct member01 = new MemberConstruct("최재영", 27, 100);
        MemberConstruct member02 = new MemberConstruct("김동건", 26);
        MemberConstruct[] members = new MemberConstruct[]{member01, member02};
        MemberConstruct[] var4 = members;
        int var5 = members.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            MemberConstruct member = var4[var6];
            System.out.println("이름 >> " + member.name + ", 나이 >> " + member.age + ", 점수 >> " + member.grade);
        }

    }
}
