import helper.Edge;
import helper.PowerSet;
import parser.Parser;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser("dataset/test_dataset.txt");
        Map<Long, Set<Long>> parse = parser.parse();
//        parse.forEach((k, v) -> System.out.format("Node: %s, Edges -> %s\n", k, v));
        parse.forEach((k, v) -> {
            System.out.println("Node: " + k);
            PowerSet.powerset(v).forEach(System.out::println);
        });
    }

}
