package classStart;

public class ClassStart05 {
    public ClassStart05() {
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "학생1";
        student1.age = 15;
        student1.grade = 90;
        Student student2 = new Student();
        student2.name = "학생2";
        student2.age = 18;
        student2.grade = 80;
        Student[] students = new Student[]{student1, student2};

        int i;
        for(i = 0; i < students.length; ++i) {
            String var10001 = students[i].name;
            System.out.println("이름: " + var10001 + ", 나이: " + students[i].age + ", 점수: " + students[i].grade);
        }

        for(i = 0; i < students.length; ++i) {
            Student student = students[i];
            System.out.println("이름: " + student.name + ", 나이: " + student.age + ", 점수: " + student.grade);
        }

        Student[] var8 = students;
        int var9 = students.length;

        for(int var6 = 0; var6 < var9; ++var6) {
            Student student = var8[var6];
            System.out.println("이름: " + student.name + ", 나이: " + student.age + ", 점수: " + student.grade);
        }

    }
}
