class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))) {
                int count = sMap.get(s.charAt(i));
                sMap.put(s.charAt(i), count + 1);
            }
            sMap.putIfAbsent(s.charAt(i), 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (tMap.containsKey(t.charAt(i))) {
                int count = tMap.get(t.charAt(i));
                tMap.put(t.charAt(i), count + 1);
            }
            tMap.putIfAbsent(t.charAt(i), 1);
        }

        for (Map.Entry<Character, Integer> entry: sMap.entrySet()) {
            char letter = entry.getKey();
            int letterCount = entry.getValue();

            if (tMap.get(letter) == null || letterCount != tMap.get(letter)) {
                return false;
            }
        }
        return true;
    }
}
