//Time complexity: O(n)
//Space complexity: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        HashSet<Integer> uniqueNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            uniqueNums.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            if (!uniqueNums.contains(nums[i] - 1)) { //Only start counting when the number has no predecessor, with that we can skip numbers in the sequence of the checked number. With this if, we can reduce the time complexity from O(n^2) to O(n) since we don't loop n time in each iteration
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
