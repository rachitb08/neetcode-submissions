class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (Integer ele : set) {
            int curr = 0;
            // Sirf us number se counting start karo jiska previous number set mein nahi hai.
            if (!set.contains(ele - 1)) {
                int j = ele;
                while (set.contains(j)) {
                    j++;
                    curr++;
                }
                max = Math.max(curr, max);
            }
        }
        return max;
    }
}