import com.sun.org.apache.bcel.internal.generic.SWITCH;

public class Main {

    /*
    Problems
    1. registration -doenst register first time
    2.update - doesnt find the name
     */

    public static void main(String[] args) {
        Db.initialize();
        while (true) {
            int menu = InputUtility.askInt("Choose the option you would like to perform operation on: \n" +
                    "1. Teachers \n" +
                    "2. Students \n" +
                    "3. Exit");

            ServiceManager service = null;
            switch (menu) {
                case 1:
                    service = new TeacherService();
                    service.process();
                    break;
                case 2:
                    service = new StudentServiceImpl();
                    service.process();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
        }
    }
}
