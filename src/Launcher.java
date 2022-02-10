import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Launcher {
    static List<Command> commandList = new ArrayList<>(Arrays.asList(new Fibo(), new Quit()));

    public static List<String> freq(Scanner scanner) {
        List<String> res = new ArrayList<>();

        return res;
    }


    public static boolean askCommand(Scanner scanner) {
        System.out.print("> ");
        String entree = scanner.next();
        AtomicBoolean res = new AtomicBoolean(false);
        AtomicBoolean found = new AtomicBoolean(false);
        commandList.forEach(command -> {
            if (command.name().equals(entree)) {
                res.set(command.run(scanner));
                found.set(true);
            }
        });
        if (!found.get())
            System.out.println("Unknown command");
        return res.get();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the not so great Java program, today we are going to do ABSOLUTELY NOTHING !");
        System.out.println("Please enter a beautiful command, the list of command is :");
        commandList.forEach(elem -> System.out.println(" - " + elem.name()));
        Scanner toto = new Scanner(System.in);
        while (!askCommand(toto)) ;
        toto.close();
    }
}
