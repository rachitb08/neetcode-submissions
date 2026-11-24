class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int min = 1;
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int ans = max;
        while (min <= max) {
            int speed = min + (max - min) / 2;
            long hours = 0;
            for (int pile : piles) {
                hours += (long) Math.ceil((double) pile/speed);
            }
            if (hours <= h) {
                ans = speed;
                max = speed - 1;
            } else {
                min = speed + 1;
            }
        }
        return ans;
    }
}