package ss2_constructor.exercise3;

public class StudentManagement {
    public static void main(String[] args) {
        Student student = new Student(1, "Nguyen Thi Ut Vien", 9);

        System.out.println("Before");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Score: " +student.getScore());

        student.setName("Vien Nguyen Thi Ut");
        student.setScore(10);

        System.out.println("After");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Score: " +student.getScore());
    }
}
