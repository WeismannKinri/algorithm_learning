package leetcode.explore.binary.search.tree;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {
    private Queue<Integer> heap;
    private int k;
    public KthLargestElementInAStream(int k, int[] nums) {
        heap = new PriorityQueue<>(k);
        this.k = k;
        for(int num : nums)
            add(num);
    }

    public int add(int val) {
        if(heap.size() < k) {
            heap.add(val);
        } else if(val > heap.peek()) {
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{8,4,5,2};
        KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(3, arr);
        kthLargest.add(3);   // returns 4
        kthLargest.add(5);   // returns 5
        kthLargest.add(10);  // returns 5
        kthLargest.add(9);   // returns 8
        kthLargest.add(4);   // returns 8
    }






//    int k;
//    PriorityQueue<Integer> queue;
//    public KthLargest(int k, int[] nums) {
//        this.k  = k;
//        queue = new PriorityQueue<>();
//        if(nums.length <= k) {
//            for(int ele:nums) queue.add(ele);
//        }else {
//            for(int i = 0;i<k;i++) queue.add(nums[i]);
//            for(int i = k;i<nums.length;i++) {
//                if(queue.peek()<nums[i]) {
//                    queue.poll();
//                    queue.add(nums[i]);
//                }
//            }
//        }
//    }
//
//    public int add(int val) {
//        if(queue.size()<k) {
//            queue.offer(val);
//        }else if(queue.peek()<val) {
//            queue.poll();
//            queue.offer(val);
//        }
//        return queue.peek();
//    }



}