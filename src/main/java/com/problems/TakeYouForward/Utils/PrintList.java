package com.problems.TakeYouForward.Utils;

public class PrintList {

    public static void printList(Node head) {
        while (head.next!=null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print(head.data);
        System.out.println();
    }
}
