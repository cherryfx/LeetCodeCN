package com.leetcode.problems.algorithm;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
//        l2.next.next.next = new ListNode(9);
//        l2.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        AddTwoNumbers atn = new AddTwoNumbers();

        ListNode listNode = atn.addTwoNumbers(l1, l2);

        System.out.println(listNode.val);


    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int overflow = 0;

        ListNode head = null, currentNode = null;

        while (l1 != null || l2 != null) {
            int v1 = 0, v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int s = v1 + v2 + overflow;
            if (s > 9) {
                s = s - 10;
                overflow = 1;
            } else {
                overflow = 0;
            }
            if (head == null) {
                head = new ListNode(s);
                currentNode = head;
            } else {
                currentNode.next = new ListNode(s);
                currentNode = currentNode.next;
            }


        }


        if (overflow == 1) {
            currentNode.next = new ListNode(1);
        }


        return head;

    }
}