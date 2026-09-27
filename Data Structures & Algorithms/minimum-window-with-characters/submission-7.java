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
        int need = tCount.size();//number of unique required characters 
        int have = 0;//number of current unique required characters
        for (int right = 0; right < s.length(); right++) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            //If the frequency of the added character exist in the window and its frequency in window and tCount are the same, then increase have
            if (tCount.containsKey(s.charAt(right)) && window.get(s.charAt(right)).equals(tCount.get(s.charAt(right)))) {
                have++;
            }

            //shrink window while it is valid
            while(have == need) {
                //Record current bestLeft and bestLength of the valid minimum window substring
                if (right - left + 1 < bestLength) {
                    bestLeft = left;
                    bestLength = right - left + 1;
                }

                //Shrink the window
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                //If the removed character still exist in tCount and if the frequency of removed character in window and t string are not the same, then decrease "have"
                if (tCount.containsKey(s.charAt(left)) && window.get(s.charAt(left)) < tCount.get(s.charAt(left))) {
                    have--;
                }
                //If the frequency of the removed character is 0, remove it from the window
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
