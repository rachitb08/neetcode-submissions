class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int min = Integer.MAX_VALUE;
        int required = t.length();
        int n = s.length();
        int start = 0;

        int[] ch = new int[128];
        for (char c : t.toCharArray()) {
            ch[c]++;
        }

        for (int right = 0;right < n;right++) {
            char rightChar = s.charAt(right);
            if (ch[rightChar] > 0) {
                required--;
            }
            ch[rightChar]--;

            while (required == 0) {

                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                ch[leftChar]++;
                if (ch[leftChar] > 0) {
                    required++;
                }
                left++;
            }
            
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}