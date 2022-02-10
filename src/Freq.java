import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Freq implements Command {
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Raboule le chemin de fichier fréro : ");
        System.out.print("?> ");

        String path = scanner.next();
        Path path_Path = Paths.get(path);
        String fichier;
        try {
            fichier = Files.readString(path_Path);
        } catch (Exception e) {
            System.out.println("Unreadable file: " + e.getClass().getName() + " " + e.getMessage());
            return false;
        }

        String[] words = fichier.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");

        Arrays.stream(words).filter((elem) -> !elem.isBlank())
                .collect(Collectors.groupingBy((elem) -> elem)).entrySet().stream()
                .sorted(Comparator.comparingInt((tocompare) -> -tocompare.getValue().size())).limit(3)
                .forEach((str) -> System.out.print(str.getKey() + " "));

        System.out.println();

        return false;
    }
}
