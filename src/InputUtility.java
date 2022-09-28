import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;
public class InputUtility {
    static Scanner scanner = new Scanner(System.in);

    public static String askString(String title) {
        System.out.println(title);
        return scanner.next();
    }
    public static Integer askInt(String title) {
        System.out.println(title);
        return scanner.nextInt();
    }

    public static Double askDouble(String title) {
        System.out.println(title);
        return scanner.nextDouble();
    }
}
