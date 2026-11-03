class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap = null;
    PriorityQueue<Integer> rightMinHeap = null;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || leftMaxHeap.peek() > num) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        if (leftMaxHeap.size() - rightMinHeap.size() > 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if (rightMinHeap.size() > leftMaxHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if (leftMaxHeap.size() > rightMinHeap.size()) {
            return leftMaxHeap.peek();
        } else {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        }
    }
}
