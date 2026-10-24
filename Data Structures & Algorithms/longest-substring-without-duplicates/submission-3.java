class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0;
        int temp = 0;
        while (right < n) {
            char ch = s.charAt(right);
            while (map.containsKey(ch)) {
                map.remove(s.charAt(left));
                left++;
            }

            map.put(ch, 1);

            res = Math.max(res, right - left + 1);

            right++;
        }

        return res;
    }
}
