import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;

public class Student implements Serializable {

    public static final long serialVersionUID = 1;

    private String name;
    private String surname;
    private Integer age;
    private Double scholarship;
    private University university;

    @Override
    public String toString() {
        return "name: " + name + '\'' +
                ", surname: " + surname + '\'' +
                ", age: " + age +
                ", scholarships: " + scholarship +
                ", university: " + university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScholarship() {
        return scholarship;
    }

    public void setScholarship(Double scholarship) {
        this.scholarship = scholarship;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
