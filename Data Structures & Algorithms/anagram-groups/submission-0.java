class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        if (strs.length == 0) {
            return new ArrayList<>();
        }

        for (int i = 0; i < strs.length; i++) {
            int[] frequencies = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                frequencies[strs[i].charAt(j) - 'a']++;
            }

            String strFrequencies = Arrays.toString(frequencies);
            if (hashMap.containsKey(strFrequencies)) {
                List<String> currentList = hashMap.get(strFrequencies);
                currentList.add(strs[i]);
                hashMap.put(strFrequencies, currentList);
            } else {
                hashMap.putIfAbsent(strFrequencies, new ArrayList<>());
                hashMap.get(strFrequencies).add(strs[i]);
            }
        }
        return new ArrayList<>(hashMap.values());
    }
}
