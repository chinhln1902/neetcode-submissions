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
        for (int right = 0; right < s.length(); right++) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);

            boolean containT = false;
            for (char key: tCount.keySet()) {
                if (window.getOrDefault(key, 0) >= tCount.get(key)) {
                    containT = true;
                } else {
                    containT = false;
                    break;
                }
            }

            //shrink window while it is valid
            while(containT) {
                if (right - left + 1 < bestLength) {
                    bestLeft = left;
                    bestLength = right - left + 1;
                }

                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                if (window.get(s.charAt(left)) == 0) {
                    window.remove(s.charAt(left));
                }

                for (char key: tCount.keySet()) {
                    if (window.getOrDefault(key, 0) >= tCount.get(key)) {
                        containT = true;
                    } else {
                        containT = false;
                        break;
                    }
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
