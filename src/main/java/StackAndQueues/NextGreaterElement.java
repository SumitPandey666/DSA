package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {
    public static void main(String[] args){
        int[] nums = {2, 1, 2, 4, 3};
        System.out.println(Arrays.toString(createNextGreaterElementArray(nums)));
    }
    public static int[] createNextGreaterElementArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return res;
    }
}
