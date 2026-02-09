package DynamicProgramming;

import java.util.HashMap;

public class ClimbingStairs {
    public static void main(String args[]){
        int n = 6;
        System.out.println(climbStairsSimpleRecursion(n));
        System.out.println(climbStairsUsingHashMapLookup(n));
        System.out.println(climbStairsIterative(n));
    }
    public static int climbStairsSimpleRecursion(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairsSimpleRecursion(n - 1) + climbStairsSimpleRecursion(n - 2);
    }
    public static int climbStairsUsingHashMapLookup(int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        return climbStairsMemo(n, map);
    }
    public static int climbStairsMemo(int n, HashMap<Integer, Integer> map){
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int result = climbStairsMemo(n - 1, map) + climbStairsMemo(n - 2, map);
        map.put(n, result);

        return result;

    }

    public static int climbStairsIterative(int n){
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int prev1 = 1;
        int prev2 = 2;

        int current = 0;
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return current;
    }


}
