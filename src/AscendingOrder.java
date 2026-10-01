import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Cognizant 2nd Round
public class AscendingOrder {

    /// Student(4,"D"),Student(2,"B"),Student(1,"A"),Student(3,"C")
    /// Student(1,"A"), Student(2,"B"), Student(3,"C"), Student(4,"D")
    public static void main(String[] args){
        List<Student> listStudent = new ArrayList<>();
        listStudent.add(new Student(3, "C"));
        listStudent.add(new Student(2, "B"));
        listStudent.add(new Student(1, "A"));
        listStudent.add(new Student(4, "D"));

        List<Student> sortedList = listStudent.stream().sorted(Comparator.comparing(student -> student.id)).toList();
        System.out.println("Sorted list is " + sortedList);
        AscendingOrder ascendingOrd = new AscendingOrder();
        ascendingOrd.occurrences("ABBDDEEEECAF");
    }

    record Student (int id, String name){

    }

    /// ABBDDEEEECAF
    /// A-> 2, B-> 2, D-> 2, E-> 4, C-> 1, F-> 1
    private void occurrences(String arbitraryChars) {
        arbitraryChars.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
