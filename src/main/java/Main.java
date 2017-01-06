import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import enums.Operation;

public class Main {

    public static void main(String[] args) {
        Scanner sc = null;
        boolean reading = true;
        Long lines = null;
        Integer maxEdgeNo = null;
        String[] parts;
        Map<Long, Set<Long>> graph = new HashMap<>();
        try {
            sc = new Scanner(new File("dataset/c125.txt"));
            while (reading) {
                String nextLine = sc.nextLine();
                Operation operation = Operation.fromString(String.valueOf(nextLine.charAt(0)));
                Optional.ofNullable(operation).orElseThrow(() -> new InvalidPropertiesFormatException("Invalid property type"));
                switch (operation) {
                    case EDGE:
                        parts = nextLine.split(" ");
                        Long from = Long.valueOf(parts[1]);
                        Long to = Long.valueOf(parts[2]);
                        graph.get(from).add(to);
                        lines--;
                        if (lines == 0)
                            reading = false;
                        break;
                    case COMMENT:
                        break;
                    case INFO:
                        parts = nextLine.split(" ");
                        maxEdgeNo = Integer.valueOf(parts[2]);
                        lines = Long.valueOf(parts[3]);
                        for (long i = 1; i <= maxEdgeNo; i++)
                            graph.put(i, new HashSet<>());
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (InvalidPropertiesFormatException e2) {
            System.err.println("Invalid property in file");
        } finally {
            if (sc != null)
                sc.close();
        }
    }

}
