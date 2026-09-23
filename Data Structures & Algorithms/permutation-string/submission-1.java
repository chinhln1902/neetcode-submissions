class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        HashMap<Character, Integer> s1Count = new HashMap<>();
        HashMap<Character, Integer> s2Window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int right = 0; right < s2.length(); right++) {
            s2Window.put(s2.charAt(right), s2Window.getOrDefault(s2.charAt(right), 0) + 1);
            while ((right - left + 1) > s1.length()) {
                s2Window.put(s2.charAt(left), s2Window.get(s2.charAt(left)) - 1);
                if (s2Window.get(s2.charAt(left)) == 0) {
                    s2Window.remove(s2.charAt(left));
                }
                left++;
            }
            if (s1Count.equals(s2Window)) {
                return true;
            }
        }
        return false;
    }
}
