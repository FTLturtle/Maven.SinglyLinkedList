package com.zipcodewilmington.singlylinkedlist;

import java.lang.reflect.Method;

import static java.lang.Thread.sleep;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {
    private int size;

    private Node<T> head;
    private Node<T> tail;

    public SinglyLinkedList() {
        this.size = 0;
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
            if (index == size - 1) {
                tail = last;
            }
        }
        size--;
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
        SinglyLinkedList<T> listCopy;
        if (size < 1) {
            listCopy = new SinglyLinkedList<>();
        } else if (head.item instanceof Cloneable) {
            listCopy = deepCopy();
        } else {
            listCopy = shallowCopy();
        }
        return listCopy;
    }

    private SinglyLinkedList<T> deepCopy() {
        SinglyLinkedList<T> listCopy = new SinglyLinkedList<>();
        for (Node<T> node = head; node != null; node = node.next) {
            listCopy.add(node.cloneItem());
        }
        return listCopy;
    }

    private SinglyLinkedList<T> shallowCopy() {
        SinglyLinkedList<T> listCopy = new SinglyLinkedList<>();
        for (Node<T> node = head; node != null; node = node.next) {
            listCopy.add(node.item);
        }
        return listCopy;
    }

    public void sort() {
        if (size > 1 && head.item instanceof Comparable) {
            Node<T> currNode = head;
            for (int i = size - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (node1GreaterThanNode2(currNode, currNode.next)) {
                        swapNodes(currNode, currNode.next);
                    }
                        currNode = currNode.next;
                }
                currNode = head;
            }
        }
    }

    private boolean node1GreaterThanNode2(Node<T> currNode, Node<T> next) {
        boolean result = false;
            if (currNode.item instanceof Comparable) {
                result = ((Comparable<T>) currNode.item).compareTo(next.item) > 0;
            }
        return result;
    }

    private void swapNodes(Node<T> currNode, Node<T> nextNode) {
        T temp = currNode.item;
        currNode.item = nextNode.item;
        nextNode.item = temp;
    }

    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        @SuppressWarnings("unchecked")
        T cloneItem() {
            T clone;
            try {
                Method m = item.getClass().getDeclaredMethod("clone");
                clone = (T) m.invoke(item);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error trying to clone element. Doing shallow copy");
                clone = item;
            }
            return clone;
        }
    }
}