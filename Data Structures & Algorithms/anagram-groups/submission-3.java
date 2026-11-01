class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String curr = strs[i];

            int[] hashTable = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                hashTable[strs[i].charAt(j) - 'a']++;
            }
            String key = Arrays.toString(hashTable);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(curr);
        }

        for (Map.Entry<String, List<String>> itr : map.entrySet()) {
            ans.add(itr.getValue());
        }
        return ans;
    }
}
