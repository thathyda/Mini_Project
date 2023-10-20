import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        * Make Scanner it's like assistant input values*/
        Scanner scanner = new Scanner(System.in);
        String option ;

        /* It's mean invoke another class for use in Main Class */
        System.out.println(Utils.Ascii);
        Utils.printMenu();
        System.out.print("Command ———>");
        option = scanner.nextLine();

        // invoke either class ("Utils class : handle option ")
        Utils utils = new Utils();
        utils.handleOption(option);

    }
}
