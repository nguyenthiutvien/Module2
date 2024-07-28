package ss3_static.exercise1;

public class StudentManagement {
    public static void main(String[] args) {
        Student student1 = new Student(1,"VienNguyen", 10);
        Student student2 = new Student(2,"Ut Vien", 10);
        Student student3 = new Student(3,"Ut Nguyen", 10);
        System.out.println("The number of student is: " + Student.getCount());
    }
}
