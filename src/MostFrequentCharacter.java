import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

// Wipro Client
public class MostFrequentCharacter {

    public static void main(String[] args) {
        String s = "success";
        findMostFrequentCharacter(s);
    }

    //Most Frequent Character
    //Input:  "success"
    //Output: s -> 3
    private static void findMostFrequentCharacter(String str) {
        str.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(character -> character, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(characterLongEntry -> System.out.println(characterLongEntry.getKey() + "->" + characterLongEntry.getValue()));

    }

    //emp_id | emp_name | email
    //-------|----------|----------------
    //1      | John     | john@gmail.com
    //2      | Mike     | mike@gmail.com
    //3      | David    | john@gmail.com
    //4      | Sara     | NULL
    //5      | Adam     | NULL

    // select emp_id, emp_name, email from employee where email in (
    // select email from employee where email is NOT NUll group by email having count(*) > 1
    // );
}
