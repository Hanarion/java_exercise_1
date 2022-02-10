import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Launcher {
    static List<String> arrayList = new ArrayList<>(Arrays.asList("fibo", "quit"));

    public static String askCommand(Scanner scanner) {
        System.out.print("> ");
        String entree = scanner.next();
        if (entree.equals("fibo")) {
            System.out.println("Raboule le nombre pour fibo fréro : ");
            System.out.print("> ");

            int n = scanner.nextInt();
            scanner.nextLine();

            int a = 0, b = 1, c = 0;
            for (int i = 2; i < n; ++i) {
                c = a + b;
                a = b;
                b = c;
            }

            System.out.println(c + a);


            return entree;
        } else if (!entree.equals("quit")) {
            System.out.println("Unknown command");
            return entree;
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the not so great Java program, today we are going to do ABSOLUTELY NOTHING !");
        System.out.println("Please enter a beautiful command, the list of command is :");
        arrayList.forEach(elem -> {
            System.out.println(" - " + elem);
        });
        Scanner toto = new Scanner(System.in);
        while (askCommand(toto) != null) ;
        toto.close();
    }
}
