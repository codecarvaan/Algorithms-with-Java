/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;

/**
 *
 * @author hashstudioz
 *
 */
class Node {

    private int data = 0;
    private Node next = null;

    public int getData() {
        return this.data;
    }

    public Node(int data) {
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return this.next;
    }

    public void setNextNode(Node nextNode) {
        this.next = nextNode;
    }

}

class LinkedList {

    private Node StartNode = null;
    private Node CurrentNode = null;

    public void add(int data) {
        if (StartNode == null) {
            StartNode = new Node(data);
            CurrentNode = StartNode;
            return;
        } else {
            Node node = new Node(data);
            CurrentNode.setNextNode(node);
            CurrentNode = node;
        }
    }

    public String toString() {
        String str = "";
        Node node = StartNode;
        while (node != null) {
            str = str + " " + node.getData();
            node = node.getNextNode();
        }
        return str;
    }


    public LinkedList addition(LinkedList l1) {
        LinkedList result = new LinkedList();
        Node node1 = this.StartNode;
        Node node2 = l1.StartNode;
        Node carr = new Node(0);
        while (node1 != null || node2 != null || carr.getData() != 0) {
            int data;
            data = (node1 != null ? node1.getData() : 0) + (node2 != null ? node2.getData() : 0) + carr.getData();
            System.out.println("data->" + data);
            result.add(data % 10);
            carr.setData(data / 10);
            node1 = node1 != null ? node1.getNextNode() : null;
            node2 = node2 != null ? node2.getNextNode() : null;
        }
        return result;
    }

    public int size() {
        int count = 0;
        Node node = this.StartNode;
        while (node != null) {
            node = node.getNextNode();
            count++;
        }
        return count;
    }

    public void rightShift(int k) {
        k = k % size();
        if (k == 0) {
            return;
        }
        int count = 0;
        Node lastNode = StartNode;
        Node breakLink = null;
        while (lastNode.getNextNode() != null) {
            ++count;
            if (size() - k == count) {
                breakLink = lastNode;
            }
            lastNode = lastNode.getNextNode();
        }
        lastNode.setNextNode(StartNode);
        Node newStartNode = breakLink.getNextNode();
        breakLink.setNextNode(null);
        StartNode = newStartNode;
    }
}

public class RightShift {

    public static void main(String args[]) {
        LinkedList l1 = new LinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.rightShift(10);
        System.out.println(l1.toString());
    }
}

