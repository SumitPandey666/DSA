package DynamicProgramming;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
        System.out.println(robCircularHouse(nums));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static int robCircularHouse(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Case 1: Exclude last house
        int case1 = robLinear(nums, 0, n - 2);
        // Case 2: Exclude first house
        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    // Linear House Robber helper with O(1) space
    private static int robLinear(int[] nums, int start, int end) {
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}