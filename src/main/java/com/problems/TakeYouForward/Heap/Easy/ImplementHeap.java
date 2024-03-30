package com.problems.TakeYouForward.Heap.Easy;

import java.util.Arrays;

public class ImplementHeap {

    public static void main(String[] args) {
        ImplementHeap m = new ImplementHeap();
        m.add(2);
        m.add(3);
        System.out.println(m.poll());
    }

    int capacity = 10;
    int size = 0;
    int[] items = new int[capacity];

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) > 0;
    }
    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) > 0;
    }
    public boolean hasParent(int index) {
        return getParentIndex(index) <= 0;
    }

    public int getLeftChildIndex(int index) {
        return 2*index+1;
    }
    public int getRightChildIndex(int index) {
        return 2*index+2;
    }
    public int getParentIndex(int index) {
        return (index-1)/2;
    }

    public int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }
    public int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }
    public int parent(int index) {
        return items[getParentIndex(index)];
    }

    public void ensureCapacity() {
        if(size >= capacity) {
            //create a new array twice the size
            items = Arrays.copyOf(items, capacity*2);
            capacity *= 2;
        }
    }

    private void swap(int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size-1;
        while (hasParent(index) && items[index] < parent(index)) {
            int parentIndex =  getParentIndex(index);
            swap(index, parentIndex);
            index = getParentIndex(index);
        }

    }

    public int poll() {
        if(size < 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;

    }

    public void heapifyDown() {
        int index = 0;

        while(hasLeftChild(index) && items[index] > leftChild(index)) {
            int smallestIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && smallestIndex < getRightChildIndex(index)) {
                smallestIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallestIndex]) {
                break;
            } else {
                swap(smallestIndex, index);
            }
            index = smallestIndex;
        }
    }



}
