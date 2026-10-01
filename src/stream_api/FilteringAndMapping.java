package stream_api;

import java.util.Arrays;

public class FilteringAndMapping {

    public static void main(String[] args) {

    }

    // Keep strings longer than 4 characters
    // Filter a list by length.
    // input-> words = ["java", "streams", "api"]
    // output-> ["streams"]
    private static void filterListByLength(String[] stringList) {
        Arrays.stream(stringList).filter(s -> s.length() > 4)
                .forEach(System.out::println);
    }


}
