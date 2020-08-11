import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SumsOfParts {
    //    https://www.codewars.com/kata/5ce399e0047a45001c853c2b/train/java
    public static int[] sumParts(int[] ls) {
        List<Integer> sums = new ArrayList<>();

        for (int i = 0; i < ls.length; i++) {
            sums.add(calcSum(ls));
            ls[i] = 0;
        }
        sums.add(0); // requested junit code wasn't great...
        return sums.stream().parallel().mapToInt(i->i).toArray();
    }
    private static int calcSum(int[] list){
        int sum = 0;
        for (int num : list) {
            sum+= num;
        }
        return sum;
    }
}
