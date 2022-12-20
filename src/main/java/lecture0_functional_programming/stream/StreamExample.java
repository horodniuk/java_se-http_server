package lecture0_functional_programming.stream;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<String> strings = List.of("88", "11", "22", "33", "44", "55", "66", "44");
        strings.stream()
                .map( string -> string + string)
                .map(Integer::valueOf)
                .filter(i -> i % 2 == 0)
              //  .sorted()
              //  .skip(1)
              //  .limit(3)
                .mapToInt(Integer::intValue)
        //  .summaryStatistics();
          .forEach(System.out::println);

        List<String> collect = Stream.of("88", "11", "22", "33", "44", "55", "66", "44")
                .peek(System.out::println).toList();

        IntStream.range(0, 3)
                .forEach(System.out::println);

        IntStream.iterate(0, operand -> operand + 3)
                .skip(10)
                .limit(3)
                .forEach(System.out::println);

      /*  for (String string:strings) {
            String value = string + string;
            Integer intValue = Integer.valueOf(value);
            if (intValue % 2 == 0){
                System.out.println(intValue);
            }
        }*/
    }
}
