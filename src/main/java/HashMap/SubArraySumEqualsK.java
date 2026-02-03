package HashMap;

import java.util.HashMap;

public class SubArraySumEqualsK {
    public static void main(String args[]){
        int[] nums = {3,4,7,2,-3,1,4,2};
        int k =7;
        int continuousSubarrays = findSubArraySumEqualsK(nums,k);
        System.out.println(continuousSubarrays);
    }
    public static int findSubArraySumEqualsK(int[] nums , int k){
        HashMap<Long,Integer> prefixFreq = new HashMap<>();
        prefixFreq.put(0L,1);

        long currentSum = 0;
        int count = 0;

        for(int num : nums){
            currentSum += num;

            long needed = currentSum - k;
            if(prefixFreq.containsKey(needed)){
                count += prefixFreq.get(needed);
            }
            prefixFreq.put(currentSum,prefixFreq.getOrDefault(currentSum, 0)+1);
        }
        return count;
    }
}
