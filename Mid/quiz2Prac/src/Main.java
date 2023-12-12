import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Gen<Integer> values1 = new Gen<Integer>(new Integer[] {10, 20, 30});
        double avg1 = values1.avg();

        Gen<Float> values2 = new Gen<Float>(new Float[] {10.00f, 15.00f, 25.00f});
        double avg2 = values2.avg();

        System.out.println(values1.isSame(values2));
        System.out.println();

        interface isEven{
            boolean isEven(int x);
        }
        isEven e = a->a%2==0;

        System.out.println(e.isEven(10));

        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape", "avocado");

        fruits.stream()
                .filter(fruit -> fruit.startsWith("a"))
                .forEach(System.out::println);
        List<String> ls = new ArrayList<String>();
        ls.add("ab");
        ls.add("bc");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .toList();

        System.out.println(squares); // Output: [1, 4, 9, 16, 25]

    }
}