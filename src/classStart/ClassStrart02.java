package classStart;

public class ClassStrart02 {
    public ClassStrart02() {
    }

    public static void main(String[] args) {
        String[] studentsNames = new String[]{"학생1", "학생2"};
        int[] studentAges = new int[]{15, 16};
        int[] studentGrades = new int[]{80, 90};

        for(int i = 0; i < studentsNames.length; ++i) {
            System.out.println("이름: " + studentsNames[i] + ", 나이: " + studentAges[i] + ", 성적: " + studentGrades[i]);
        }

    }
}
