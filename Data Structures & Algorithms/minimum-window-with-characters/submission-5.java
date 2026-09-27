class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> tCount = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int bestLeft = 0;
        int bestLength = Integer.MAX_VALUE;
        int need = tCount.size();
        int have = 0;
        for (int right = 0; right < s.length(); right++) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);

            if (tCount.containsKey(s.charAt(right)) && window.get(s.charAt(right)).equals(tCount.get(s.charAt(right)))) {
                have++;
            }

            //shrink window while it is valid
            while(have == need) {
                if (right - left + 1 < bestLength) {
                    bestLeft = left;
                    bestLength = right - left + 1;
                }

                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                if (tCount.containsKey(s.charAt(left)) && window.get(s.charAt(left)) < tCount.get(s.charAt(left))) {
                    have--;
                }
                
                if (window.get(s.charAt(left)) == 0) {
                    window.remove(s.charAt(left));
                }
                left++;
            }
        }
        if (s.length() < t.length() || bestLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(bestLeft, bestLeft + bestLength);
    }
}
