class Solution {
    public String encode(List<String> strs) {
        // encoding format string length , then special character then string
        StringBuilder ans = new StringBuilder();
        for (String str : strs) {
            ans.append(str.length()).append("#").append(str);
        }
        return ans.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        int i = 0, n = str.length();
        while (i < n) {
            // get the length then delimeter then string
            int j = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            ans.add(str.substring(i, i + len));
            i += len;
        }
        return ans;
    }
}
