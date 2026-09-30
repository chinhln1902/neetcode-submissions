class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int result = 0;

        maxLeft[0] = 0;
        maxRight[height.length - 1] = 0;
        for (int left = 1; left < height.length; left++) {
            maxLeft[left] = Math.max(maxLeft[left - 1], height[left - 1]);
        }
        for (int right = height.length - 2; right > 0; right--) {
            maxRight[right] = Math.max(maxRight[right + 1], height[right + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            int waterAtIndexI = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (waterAtIndexI < 0) {
                waterAtIndexI = 0;
            }
            result = result + waterAtIndexI;
        }

        return result;
    }
}
