package com.problems.TakeYouForward.LinkedList;

import com.problems.TakeYouForward.Utils.Node;
import com.problems.TakeYouForward.Utils.PrintList;

public class DetectAndRemoveLoop {

    public static void main(String[] args) {
        Node node = new Node(50);
        node.next = new Node(20);
        node.next.next = new Node(15);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(10);


        node.next.next.next.next.next = node.next.next;
        
        detectLoop(node);

        PrintList.printList(node);
    }

    private static void detectLoop(Node node) {

        Node slow = node;
        Node fast = node;

        while(slow != null && fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                System.out.println(slow.next.data);
                removeLoop(slow, fast, node);
                break;
            }
        }


    }

    private static void removeLoop(Node slow, Node fast, Node node) {

        slow = node;
        if (slow != fast) {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        }
        else {
            while(fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        }
    }
}
