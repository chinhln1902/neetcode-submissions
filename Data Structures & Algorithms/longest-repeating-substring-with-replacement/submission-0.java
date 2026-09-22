class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> countFreq = new HashMap<>();
        int result = 0;
        int maxFreq = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            Character current = s.charAt(right);
            countFreq.put(current, countFreq.getOrDefault(current, 0) + 1);

            maxFreq = Math.max(maxFreq, countFreq.get(s.charAt(right)));

            while((right - left + 1) -  maxFreq > k) {
                Character leftWindow = s.charAt(left);
                countFreq.put(leftWindow, countFreq.get(leftWindow) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
