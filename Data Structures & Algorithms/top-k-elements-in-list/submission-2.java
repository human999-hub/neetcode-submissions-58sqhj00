class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        for (int c : count.values()) {
            maxFreq = Math.max(maxFreq, c);
        }

        List<Integer>[] freq = new List[maxFreq + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int c = entry.getValue();
            freq[c].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = freq.length - 1; i >= 0; i--) {
            for (int num : freq[i]) {
                result[index++] = num;
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
