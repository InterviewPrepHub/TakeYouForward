package com.problems.TakeYouForward.LinkedList;

import com.problems.TakeYouForward.Utils.Node;
import com.problems.TakeYouForward.Utils.PrintList;

public class LinkedListImpl {

    static Node head;
    static Node tail;

    public static void main(String[] args) {

        LinkedListImpl l = new LinkedListImpl();
        l.add(10);
        l.add(9);
        l.add(13);
        l.add(1);
        l.add(3);
        l.add(25);

        PrintList.printList(head);

        l.findKthNodeFromEnd(3);

        l.removeKthNodeFromEnd(3);
        PrintList.printList(head);

        l.middleNodeOfLinkedList();
        PrintList.printList(head);

        l.reverseLinkedList();
        PrintList.printList(head);

        l.reverseLinkedListInKGroups(3);


    }

    private void reverseLinkedListInKGroups(int k) {
        head = reverseLinkedList(head, k);
        PrintList.printList(head);
    }

    private Node reverseLinkedList(Node node, int k) {
        Node p1 = null, p2 = null, p3 = node;
        int count = 0;

        while (count<k && p3!=null) {
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
            p2.next = p1;
            count++;
        }

        if(p3!=null) {
            node.next = reverseLinkedList(p3, k);
        }
        return p2;
    }

    private void reverseLinkedList() {

        Node p1 = null, p2 = null, p3 = head;

        while(p3!=null) {
            p1=p2;
            p2=p3;
            p3=p3.next;
            p2.next=p1;
        }
        head=p2;
    }

    private void middleNodeOfLinkedList() {

        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("middle element : "+slow.data);
    }

    private void removeKthNodeFromEnd(int k) {

        Node slow = head;
        Node fast = head;

        for (int i = 0; fast!=null && i < k; i++) {
            fast = fast.next;
        }

        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
    }

    private void findKthNodeFromEnd(int k) {

        Node slow = head;
        Node fast = head;
        for (int i = 0; fast!=null && i < k; i++) {
            fast = fast.next;
        }

        while(fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println("kth node from end : "+slow.next.data);

    }

    public void add(int data) {
        Node node = new Node(data);
        if(tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }


}
