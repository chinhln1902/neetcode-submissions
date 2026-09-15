class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> frequencies = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            frequencies.add(new ArrayList<>());
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }

        countMap.forEach((key,value) -> {
            frequencies.get(value).add(key);
        });

        int[] result = new int[k];
        int index = 0;
        for (int i = frequencies.size() - 1; i > 0; i--) {
            for (int j = 0; j < frequencies.get(i).size(); j++) {
                if (index == k) {
                    return result;
                }
                result[index] = frequencies.get(i).get(j);
                index++;
            }
        }

        return result;
    }
}
