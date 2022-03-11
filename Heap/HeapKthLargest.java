package com.leetjavaheap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapKthLargest {

    public static int kthLarEleMinHeap(int[] arr, int k) {
        if(arr.length < k) {
            return -1;
        }

        //Initialize MinHeap of PriorityQueue

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++) {
            if(arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        return minHeap.peek();
    }

    public static int kthLarEleMaxHeap(int[] arr, int k) {
        if(arr.length < k) {
            return -1;
        }

        //Initialize MaxHeap of PriorityQueue

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
        }

        for(int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {

        int[] arr = {4, 7, 21, 31, 20, 28, 2, 35};
        int k = 3;

        System.out.println(HeapKthLargest.kthLarEleMinHeap(arr, k));
        System.out.println(HeapKthLargest.kthLarEleMaxHeap(arr, k));


    }

}