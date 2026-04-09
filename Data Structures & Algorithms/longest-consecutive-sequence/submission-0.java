class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> dup = new HashSet<>();

        for(int num : nums){
            dup.add(num);
        }

        int longest=0;

        for(int num : dup){

            if(!dup.contains(num-1)){
                int length =1;

                while(dup.contains(num+length)){
                    length++;
                }
                longest = Math.max(longest, length);

            }


        }

        return longest;

        

    
        
    }
}
