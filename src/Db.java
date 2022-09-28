import java.io.Serializable;

public class Db {
    public static Student[] students;

    public static void save() {
        FileUtility.writeObjectToFile(Db.students, "students.obj");
    }

    public static void initialize() {
        try {
            students = (Student[]) FileUtility.readObjectFromFile("students.obj");
        } catch (Exception e) {
            students = new Student[0];
        }
    }
}
