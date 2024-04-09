package com.problems.TakeYouForward.Stack;

import com.problems.TakeYouForward.Utils.PrintArray;

public class NextGreaterElement {

    public static void main(String[] args) {

        NextGreaterElement n = new NextGreaterElement();

        //next greater element to the right
//        int[] input = {1,3,2,4};    //expected output: {3, 4, 4, -1}
        int[] input1 = {6, 4, 12, 5, 2, 10};
        int[] output = n.nextGreaterToRight(input1);

        System.out.println("Next greater element to right");
        PrintArray.print(output);

        int[] input2 = {9, 4, 15, 6, 2, 10};    //expected output: {-1, 9, -1, 15, 6, 15}
        n.NextGreaterToLeft(input2);

    }

    public int[] nextGreaterToRight(int[] input) {

        int n = input.length;
        int[] output = new int[n];

        output[n-1] = -1;
        int max_so_far = input[n-1];    //4

        for (int i = n-2;i >= 0;i--) {
            max_so_far = Math.max(input[i], max_so_far);

            if(input[i+1] < max_so_far && input[i+1] > input[i]) {
                output[i] = input[i+1];
            } else if (input[i] >= max_so_far) {
                output[i] = -1;
            } else {
                output[i] = max_so_far;
            }
        }
        return output;
    }

    public void NextGreaterToLeft(int[] input) {

        int n = input.length;
        int[] output = new int[n];

        output[0] = -1;

        int max_so_far = input[0];

        for (int i = 1; i < n; i++) {

        }
    }
}
