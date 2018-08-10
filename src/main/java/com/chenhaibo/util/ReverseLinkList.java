package com.chenhaibo.util;


/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 10:27 2018/8/8
 */
public class ReverseLinkList {

    /**
     * 封装node
     * @param index
     * @return
     */
    private Node packageNode(int index) {
        Node node = new Node();
        node.setIndex(index);
        return node;
    }

    /**
     * 遍历
     * @param node
     */
    private void iteratorList(Node node) {
        if (null == node) {
            System.out.println("this node is null.");
            return;
        }
        Node cur = node;
        while (cur != null) {
            System.out.println("this node index is :" + cur.getIndex());
            cur = cur.next;
        }
    }

    /**
     * 迭代反转
     * @param node
     * @return
     */
    private Node reverse(Node node) {
        Node preNode = null;
        Node now = node;
        while (null != now) {
            Node next = now.next;
            now.next = preNode;
            preNode = now;
            now = next;
        }
        return preNode;
    }

    /**
     * 递归反转
     * @param node
     * @return
     */
    private Node reverse2(Node node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            Node re = reverse2(node.next);
            node.next.next = node;
            node.next = null;
            return re;
        }
    }

    public static void main(String[] args) {
        ReverseLinkList demo = new ReverseLinkList();
        Node node1 = demo.packageNode(1);
        Node node2 = demo.packageNode(2);
        Node node3 = demo.packageNode(3);
        Node node4 = demo.packageNode(4);
        Node node5 = demo.packageNode(5);
        Node node6 = demo.packageNode(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        demo.iteratorList(node1);
        //System.out.println("\n");
        //demo.iteratorList(demo.reverse(node1));
        System.out.println("\n");
        demo.iteratorList(demo.reverse2(node1));
    }

    private class Node {
        int index;
        Node next;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
