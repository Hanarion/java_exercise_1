import java.util.Scanner;

public class Launcher {

    public static String askCommand(Scanner scanner) {
        String entree = scanner.next();
        if (!entree.equals("quit")) {
            System.out.println("Unknown command");
            return entree;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the not so great Java program, today we are going to do ABSOLUTELY NOTHING !");
        Scanner toto = new Scanner(System.in);
        while (askCommand(toto) != null) ;
        toto.close();
    }
}
