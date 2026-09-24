class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;

        Set<Character> set = new HashSet<>();

        for (int end = 0;end < s.length();end++) {
            char ch = s.charAt(end);
            if (set.contains(ch)) {
                while (set.contains(ch)) {
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            set.add(ch);
            max = Math.max(max, end-start+1);
        }
        return max;
    }
}
