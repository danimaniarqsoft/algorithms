package com.github.danimaniarqsoft.list;

import com.github.danimaniarqsoft.utils.Node;

import lombok.Data;

@Data
public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;

    public LinkedList(T value) {

        Node<T> node = new Node<>(value, null);

        this.head = node;
        this.tail = head;
        this.length = 1;

    }

    public LinkedList<T> append(T value) {
        Node<T> node = new Node<>(value, null);
        this.tail.setNext(node);
        this.tail = node;
        this.length++;
        return this;
    }

    public LinkedList<T> prepend(T value) {

        Node<T> node = new Node<>(value, this.head);
        this.head = node;
        this.length++;
        return this;
    }

    public LinkedList<T> insert(int index, T value) {

        if (index == 0) {
            this.prepend(value);
            return this;
        }

        Node<T> current = nodeAt(index - 1);
        Node<T> node = new Node<>(value, current.getNext());
        current.setNext(node);
        this.length++;
        return this;
    }

    public LinkedList<T> remove(int index) {

        if (index == 0) {
            this.head = this.head.getNext();
            this.length--;
            return this;
        }

        Node<T> preNode = nodeAt(index - 1);

        if (preNode == null || preNode.getNext() == null) {
            return this;
        }

        Node<T> nodeToRemove = preNode.getNext();
        Node<T> postNode = nodeToRemove.getNext();
        preNode.setNext(postNode);

        if (postNode == null) {// if is tail
            this.tail = preNode;
        }
        this.length--;

        return this;
    }

    private Node<T> nodeAt(int index) {

        Node<T> current = this.head;
        int count = 0;

        while (current != null) {
            if (index == count) {
                return current;
            }
            current = current.getNext();
            count++;
        }
        return null;
    }

    public LinkedList<T> reverse() {

        Node<T> prev = null;
        Node<T> current = this.head;
        Node<T> post = current.getNext();
        this.tail = this.head;

        while (current != null) {
            current.setNext(prev);
            prev = current;
            current = post;
            if(current !=null){
                post = current.getNext();
            }
        }
        this.head = prev;

        return this;
    }

    public void print() {
        Node<T> current = this.head;

        while (current != null) {
            System.out.printf(current.getValue() + ",");
            current = current.getNext();
        }

        System.out.println();
        System.out.println("head: " + this.head.getValue());
        System.out.println("tail: " + this.tail.getValue());
        System.out.println("length: " + this.length);
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(2);
        list
                .append(3)
                .append(6)
                .append(9)
                .append(12)
                .prepend(-1)
                .prepend(-3)
                .insert(2, 100)
                .insert(0, -100)
                .insert(0, -99);
        list.print();
        list.reverse();
        list.print();
    }

}
