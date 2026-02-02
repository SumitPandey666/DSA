package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    public static void main(String args[]){
        int[] arr = {1,3,4,2,-1};
        int target = 3;
        List<int[]> result = findAllTwoSum(arr, target);

        if (result.isEmpty()) {
            System.out.println("No pairs found");
        } else {
            for (int[] pair : result) {
                System.out.println("Indices are: " + pair[0] + ", " + pair[1]);
            }
        }
    }
    public static List<int[]> findAllTwoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                pairs.add(new int[]{map.get(complement), i});
            }
            map.put(arr[i], i);
        }
        return pairs;
    }
}

/*TC = O(n)
SC = O(n)
- Trade-off: Faster lookup at the cost of extra memory*/

