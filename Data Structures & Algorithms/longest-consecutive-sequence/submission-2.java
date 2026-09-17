class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        HashSet<Integer> uniqueNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            uniqueNums.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            if (!uniqueNums.contains(nums[i] - 1)) { //Only start counting when the number has no predecessor, with that we can skip numbers in the sequence of the checked number
                while(uniqueNums.contains(nums[i])) {
                    count++;
                    nums[i]++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
