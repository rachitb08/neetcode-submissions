class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i=0;i<n;i++) {
            sum += nums[i];
        }
        
        if ((sum % 2) == 0) {
            int target = sum/2;
            int[][] dp = new int[target+1][n+1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return canPartition(nums,target,n-1, dp);
        }
        return false;
    }

    public boolean canPartition(int[] nums, int target, int index, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return false;
        }

        if (dp[target][index] != -1) {
            return dp[target][index] == 1;
        }

        // not pick
        boolean notPick = canPartition(nums,target,index-1, dp);
        if (target >= nums[index]) {
            boolean pick = canPartition(nums,target - nums[index],index-1, dp);
            dp[target][index] = (pick || notPick) ? 1 : 0;
        } else {
            dp[target][index] = notPick ? 1 : 0;
        }
        return dp[target][index] == 1;
    }
}