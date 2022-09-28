public class StudentServiceImpl implements ServiceManager {

    @Override
    public void process() {
        int studentMenu = InputUtility.askInt("Choose the option you would like to proceed \n" +
                "1. Registration \n" +
                "2. Search \n" +
                "3. Delete \n" +
                "4. Update \n" +
                "5. Show the list \n");

        switch (studentMenu) {
            case 1:
                register();
                Db.save();
                break;
            case 2:
                search();
                break;
            case 3:
                delete();
                Db.save();
                break;
            case 4:
                update();
                Db.save();
                break;
            case 5:
                showAll();
                break;
            default:
                System.out.println("Incorrect choice");
        }

    }

    @Override
    public void register() {
        int registerCount = InputUtility.askInt("How many student would you like to register?");
        Student[] oldStudents = Db.students;
        Student[] newStudents = new Student[registerCount];

        for (int i = 0; i < Db.students.length; i++) {
            newStudents[i] = prepareStudent();
        }

        Student[] result = new Student[oldStudents.length + newStudents.length];
        for (int i = 0; i < oldStudents.length; i++) {
            result[i] = oldStudents[i];
        }

        for (int i = 0; i < newStudents.length; i++) {
            result[oldStudents.length + i] = newStudents[i];
        }
        Db.students = result;
    }

    @Override
    public void search() {
        String search = InputUtility.askString("Please, enter the student's name");
        for (int i = 0; i < Db.students.length; i++) {
            Student student = Db.students[i];

            if (StringUtility.containsIgnoreCase(student.getName(), search) ||
                    StringUtility.containsIgnoreCase(student.getSurname(), search)) {
                System.out.println(i + ". " + student);
            }
        }
    }

    @Override
    public void delete() {
        search();

        int studentNumber = InputUtility.askInt("Please, Enter your student number");

        Db.students[studentNumber] = null;
        Student[] newStudents = new Student[Db.students.length - 1];

        int j = 0;
        for (int i = 0; i < Db.students.length; i++) {
            if (Db.students[i] != null) {
                newStudents[j] = Db.students[i];
                j++;
            }
        }

        Db.students = newStudents;
    }

    @Override
    public void update() {
        search();

        int studentNumber = InputUtility.askInt("Enter student's number");

        Student student = Db.students[studentNumber];

        while (true) {
            String field = InputUtility.askString("What would you like to update?");
            if (field.equalsIgnoreCase("name")) {
                student.setName(InputUtility.askString("Enter student;s name: "));
            } else if (field.equalsIgnoreCase("surname")) {
                student.setSurname(InputUtility.askString("Enter student's surname: "));
            } else if (field.equalsIgnoreCase("age")) {
                student.setAge(InputUtility.askInt("Please, enter student's age:"));
            } else if (field.equalsIgnoreCase("scholarship")) {
                student.setScholarship(InputUtility.askDouble("Please, enter student's scholarship:"));
            } else if (field.equalsIgnoreCase("university")) {
                University university = new University();
                university.setName(InputUtility.askString("please, enter the name of the university student attends"));
                student.setUniversity(university);
                System.out.println("if you are done updating, please, enter 'done' ");
            } else if (field.equalsIgnoreCase("done")) {
                break;
            } else {
                System.out.println("Incorrect information");
            }
        }
    }

    @Override
    public void showAll() {
        for (int i = 0; i < Db.students.length; i++) {
            System.out.println(Db.students[i]);
        }
    }

    private static Student prepareStudent() {
        Student student = new Student();

        student.setName(InputUtility.askString("Enter the student's name:"));
        student.setSurname(InputUtility.askString("Enter the student's surname:"));
        student.setAge(InputUtility.askInt("Enter  the student's age:"));
        student.setScholarship(InputUtility.askDouble("Enter the student's stipend:"));

        University university = new University();
        university.setName(InputUtility.askString("Enter the name of the university which the student is attending:"));

        student.setUniversity(university);
        return student;
    }
}
