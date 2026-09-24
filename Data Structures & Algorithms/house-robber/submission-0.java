class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return maxSum(nums, n-1, new HashMap<>());
    }

    public int maxSum(int[] nums, int index, Map<Integer, Integer> memo) {
        if (index == 0) {
            return nums[0];
        }
        if (index == -1) {
            return 0;
        }

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        int pick = nums[index] + maxSum(nums, index-2, memo);
        int notPick = maxSum(nums, index-1, memo);

        int max = Math.max(pick, notPick);

        memo.put(index, max);

        return max;
    }
}