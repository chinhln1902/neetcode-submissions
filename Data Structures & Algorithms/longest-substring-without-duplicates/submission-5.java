class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        if (s.length() == 1) {
            return 1;
        }
        
        int left = 0;
        int result = 0;
        for (int right = 0; right < s.length(); right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            result = Math.max(result, set.size());
        }
        return result;
    }
}
