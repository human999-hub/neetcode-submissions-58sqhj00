class Solution {
    public int[] topKFrequent(int[] nums, int k) {

       HashMap<Integer, Integer> count = new HashMap<>();

       List<Integer>[] freq = new List[nums.length + 1];

       for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

       for(int i=0;i<nums.length;i++){

        count.put(nums[i], 
            count.getOrDefault(nums[i], 0) + 1);

       } 

       for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int c = entry.getValue();
            freq[c].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = freq.length - 1; i >= 0 && index < k; i--) {
            for (int num : freq[i]) {
                result[index] = num;
                index++;
                if (index == k) {
                    return result;
                }
            }
        }

        return result;




        

    }
}
