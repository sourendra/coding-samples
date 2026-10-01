import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class CharacterOccurrencesWithOrder {
    public static void main(String[] args) {
        System.out.println("Try clicking the Run button.");
        String s = "AAABDDDCEEE"; // -> A3B1D3C1E3
        String result = s.chars().mapToObj(ch-> (char) ch)
                .collect(Collectors.groupingBy(ch-> ch, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .map(entry-> String.valueOf(entry.getKey()) + entry.getValue())
                .collect(Collectors.joining());
        System.out.println(result);
    }
}
