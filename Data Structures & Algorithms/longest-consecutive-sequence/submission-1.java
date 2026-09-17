class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        HashSet<Integer> uniqueNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            uniqueNums.add(nums[i]);
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!uniqueNums.contains(nums[i] - 1)) {
                while(uniqueNums.contains(nums[i])) {
                    count++;
                    nums[i]++;
                }
                result = Math.max(result, count);
                count = 0;
            }
        }
        return result;
    }
}
