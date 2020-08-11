import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumsOfParts {
    //    https://www.codewars.com/kata/5ce399e0047a45001c853c2b/train/java
    public static void main(String[] args) {
        int[] ls = new int[20];
        List<Integer> sums = new ArrayList<>();

        for (int i = 0; i < ls.length; i++) {
            sums.add(calcSum(ls));
            ls[i] = 0;
        }
    return Arrays.asList(sums);
    }
    public static int calcSum(int[] list){
        int sum = 0;
        for (int num : list) {
            sum+= num;
        }
        return sum;
    }
}
