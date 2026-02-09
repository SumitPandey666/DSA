package DynamicProgramming;

public class MinCostClimbingStairs {
    public static void main(String args[]){
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];
        if (n == 2) return Math.min(cost[0], cost[1]);

        int first = cost[0];
        int second = cost[1];

        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }

        return Math.min(first, second);
    }
}