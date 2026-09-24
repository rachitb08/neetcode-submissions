class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(maxSum(nums, 1, n-1, new HashMap<>()), maxSum(nums, 0, n-2, new HashMap<>()));
    }

    public int maxSum(int[] nums, int start, int index, Map<Integer, Integer> memo) {
        if (index == start) {
            return nums[start];
        }
        if (index == (start-1)) {
            return 0;
        }

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        int pick = nums[index] + maxSum(nums, start, index-2, memo);
        int notPick = maxSum(nums, start, index-1, memo);

        int max = Math.max(pick, notPick);

        memo.put(index, max);

        return max;
    }
}