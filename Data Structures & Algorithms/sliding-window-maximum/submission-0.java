class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] result = new int[nums.length - k + 1];
        
        for (int right = 0; right < nums.length; right++) {
            //Add element into heap as pair {value, index};
            heap.offer(new int[]{nums[right], right});
            
            //Check if the element is outside the window
            //heap.peek()[1]: Get the index of the top element of the heap.
            while (heap.peek()[1] <= right - k) {
                heap.poll();
            }

            //If the window has enough k elements, add top element of the heap to result
            if (right >= k - 1) {
                result[right - k + 1] = heap.peek()[0];
            }
        }
        return result;
    }
}
