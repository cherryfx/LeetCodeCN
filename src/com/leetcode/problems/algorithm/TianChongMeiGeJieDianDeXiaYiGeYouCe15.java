package com.leetcode.problems.algorithm;

public class TianChongMeiGeJieDianDeXiaYiGeYouCe15 {


    public Node connect(Node root) {
        Node current = root;
        Node start = null;
        Node nextNode = null;
        while(current != null) {
            while(current != null) {
                if(current.left != null) {
                    if(nextNode == null) {
                        nextNode = current.left;
                        start = nextNode;
                    } else {
                        nextNode.next = current.left;
                        nextNode = nextNode.next;
                    }
                }
                if(current.right != null) {
                    if(nextNode == null) {
                        nextNode = current.right;
                        start = nextNode;
                    } else {
                        nextNode.next = current.right;
                        nextNode = nextNode.next;
                    }
                }
                current = current.next;
            }
            current = start;
            start = null;
            nextNode = null;
        }
        return root;
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}