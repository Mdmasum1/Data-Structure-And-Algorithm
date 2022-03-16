package com.leetjavaheap;


import java.util.PriorityQueue;

//Q. Find kth Largest Value in given Stream of numbers

//time complexity: O(klogk + (N-k)logk)
//(Because kth time poll or remove is klogk and every time re-shuffling
//the complexity is (N-k)logk . so, Complexity of this unInStream
// is O(klogk + (N-k)logk).

public class KthLargestNmStream {

    //initialize minHeap of PriorityQueue
    PriorityQueue <Integer> minHeap = new PriorityQueue<>();


    //Implementation of add method
    public int add(int num, int k){
        //If size is less than kth then add num in the minHeap
        // and return the peek element of minHeap if size is
        //equal k  , otherwise, it's return -1.

        if(minHeap.size() < k) {
            minHeap.add(num);
            return minHeap.size() == k ? minHeap.peek() : -1;
        }

        //If current element or num is less than peek element of the
        // minHeap , then poll or remove the peek element and add element
        // on the minHeap

         if(num > minHeap.peek()) {
             minHeap.poll();
             minHeap.add(num);
         }
         return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestNmStream obj = new KthLargestNmStream();

        int[] arr = new int[] { 10, 7, 11, 5, 27, 8, 9, 45 };
        int k = 3;

        for(int i = 0; i < arr.length; i++) {
            System.out.println(obj.add(arr[i], k));
        }

    }

}
