import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(int[] numbers) {
        ArrayList<Integer> array = new ArrayList<>();
        boolean[] hash = new boolean[201];
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                int index = numbers[i] + numbers[j];
                hash[index] = true;
            }
        }
        
        for (int i = 0; i < hash.length; i++) {
            if (hash[i]) {
                array.add(i);
            }
        }
        return array;
    }
}