class Pair {
    int num;
    int freq;

    Pair(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }

    public int getNum() {
        return num;
    }

    public int getFreq() {
        return freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] result = new int[k];
        for (int i =0;i<n;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.freq - b.freq);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));

            if (pq.size() > k) {
                pq.poll();
            }
        }
        int j=0;
        while (!pq.isEmpty()) {
            result[j++] = pq.poll().num;
        }

        return result;
    }
}