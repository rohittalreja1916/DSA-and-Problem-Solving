import java.util.*;

public class Finding3DigitEvenNumbers {
    public static void main(String[] args) {
        int[] digits = { 2, 1, 3, 0 };
        int[] ans = findEvenNumbers(digits);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();

        for(int i =0; i< digits.length; i++){
            if(digits[i] == 0) continue;
            for(int j=0; j< digits.length; j++){
                if(i==j) continue;
                for(int k=0; k< digits.length; k++){
                    if(i==k || j==k || digits[k] %2 !=0) continue;

                    int num = digits[i]*100 + digits[j]*10 + digits[k];
                    result.add(num);
                }
            }
        }

        return result.stream().sorted().mapToInt(i -> i).toArray();
    }
}
