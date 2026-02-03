package HashMap;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String args[]){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] topKFrequent = findTopKFrequentElements(nums,k);
        System.out.println(Arrays.toString(topKFrequent));
    }
    public static int[] findTopKFrequentElements(int[] nums, int k){
        HashMap<Integer, Integer>map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        List<Integer>[] bucket = new List[nums.length+1];

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] res = new int[k];
        int counter = 0;

        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {
            if (bucket[pos] != null) {
                for (int num : bucket[pos]) {
                    res[counter++] = num;
                    if (counter == k) break;
                }
            }
        }

        return res;
    }
}
