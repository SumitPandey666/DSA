package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemprature {
    public static void main(String[] args){
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(findDaysTillWarm(temperatures)));
    }
    public static int[] findDaysTillWarm(int[] temps) {
        int len = temps.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temps[stack.peek()] <= temps[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}
