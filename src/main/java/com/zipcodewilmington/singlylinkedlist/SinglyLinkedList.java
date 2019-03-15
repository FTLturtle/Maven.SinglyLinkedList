package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {
    private int size = 0;

    private Node<T> head;
    private Node<T> tail;

    public SinglyLinkedList() {
    }

    public void add(T item) {
        if (head == null) {
            head = new Node<>(item, null);
            tail = head;
        } else {
            tail.next = new Node<>(item, null);
            tail = tail.next;
        }
        size++;
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> nodeToRemove = head;
            Node<T> last = null;
            for (int i = 0; i < index; i++) {
                last = nodeToRemove;
                nodeToRemove = nodeToRemove.next;
            }
            last.next = nodeToRemove.next;
        }
    }

    public Boolean contains(T item) {
        return find(item) != -1;
    }

    public Integer find(T item) {
        int index = 0;
        if (item == null) {
            for (Node<T> node = head; node != null; node = node.next) {
                if (node.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<T> node = head; node != null; node = node.next) {
                if (item.equals(node.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public Integer size() {
        return size;
    }

    public T get(Integer index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node<T> result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.item;
    }

    public SinglyLinkedList<T> copy() {
        return null;
    }

    public void sort() {

    }

    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}