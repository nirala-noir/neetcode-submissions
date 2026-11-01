class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            // Find where the delimiter '#' is
            int j = str.indexOf('#', i);
            // Parse the length of the upcoming string
            int length = Integer.parseInt(str.substring(i, j));
            // Move pointer past the '#'
            i = j + 1;
            // Extract the original string based on parsed length
            result.add(str.substring(i, i + length));
            // Move pointer to the start of the next length prefix
            i += length;
        }

        return result;
    }
}
