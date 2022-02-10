import java.util.Scanner;

public class Fibo implements Command {
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {

        System.out.println("Raboule le nombre pour fibo fréro : ");
        System.out.print("?> ");

        int n = scanner.nextInt();
        scanner.nextLine();

        int a = 0, b = 1, c = 0;
        for (int i = 2; i < n; ++i) {
            c = a + b;
            a = b;
            b = c;
        }

        System.out.println(c + a);

        return false;
    }
}
