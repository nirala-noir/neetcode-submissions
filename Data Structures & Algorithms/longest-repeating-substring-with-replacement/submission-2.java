public class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int res = 0, n = s.length();

        int left = 0, maxf = 0;
        for (int right = 0; right < n; right++) {
            Character ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxf = Math.max(maxf, map.get(ch));

            while ((right - left + 1) - maxf > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}