import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;


public class Predict implements Command {
    @Override
    public String name() {
        return "predict";
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

        String[] words = fichier.replaceAll("[^a-zA-Z \n]", "").toLowerCase().split("\\s+");

        Map<String, Map<String, Integer>> res = new LinkedHashMap<>();
        for (int i = 0; i < (words.length - 1); i++) {
            String str = words[i],
                    next = words[i + 1];
            Map<String, Integer> m2 = res.get(str);
            if (m2 != null) {
                Integer j = m2.get(next);
                if (j == null)
                    m2.put(next, 1);
                else
                    m2.replace(next, j + 1);
            } else {
                m2 = new LinkedHashMap<>();
                res.put(str, m2);
                m2.put(next, 1);
            }
        }

        System.out.println(res);

        System.out.println("Raboule le mot fréro : ");
        System.out.print("?> ");

        String mot = scanner.next();
        int limit = 20;
        System.out.print(mot + ' ');
        while (res.containsKey(mot) && limit > 0) {
            AtomicReference<Map.Entry> newmot = new AtomicReference<>(null);

            String test;
            if (newmot.get() == null)
                test = mot;
            else
                test = newmot.get().getKey().toString();
            res.get(test).entrySet().forEach(entry -> {
                if (newmot.get() == null) {
                    newmot.set(entry);
                } else {
                    if (entry.getValue() > (int) newmot.get().getValue()) {
                        newmot.set(entry);
                    }
                }
            });
            System.out.print(newmot.get().getKey().toString() + ' ');
            mot = newmot.get().getKey().toString();
            limit--;
        }
        System.out.println();

        if (limit == 20) {
            System.out.println("The word doesn't exists, learn how to write");
        }


        return false;
    }
}
