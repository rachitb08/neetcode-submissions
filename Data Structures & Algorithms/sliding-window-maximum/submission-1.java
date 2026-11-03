class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        int j = 0;
        for (int i=0;i<n;i++) {
            // remove elements out of the window
            while (!deque.isEmpty() && deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }

            // remove smaller elements
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k-1) {
                ans[j++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}