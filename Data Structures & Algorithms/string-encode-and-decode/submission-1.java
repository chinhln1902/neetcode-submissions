class Solution {

    public String encode(List<String> strs) {
        //Example encoded string: "5#Chinh2#Le", format: length + delimiter + actual string;
        StringBuilder encodedStr = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String word = strs.get(i);
            encodedStr.append(String.valueOf(word.length())).append("#").append(word);
        }
        return encodedStr.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int hashIndex = str.indexOf("#", i); //Get the first # starting from index i
            int length = Integer.parseInt(str.substring(i, hashIndex));

            String word = str.substring(hashIndex + 1, hashIndex + 1 + length);
            
            result.add(word);
            i = hashIndex + 1 + length;
        }
        return result;
    }
}
