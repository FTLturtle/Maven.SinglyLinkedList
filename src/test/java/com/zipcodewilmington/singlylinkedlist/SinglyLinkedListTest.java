package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    @Test
    public void addTest() {
        // Given
        Integer item = 8;
        SinglyLinkedList<Integer> singLinkList = new SinglyLinkedList<>();

        // When
        singLinkList.add(item);

        // Then
        Assert.assertTrue(singLinkList.contains(item));
    }

    @Test
    public void removeTest1() {
        // Given
        Integer item = 8;
        SinglyLinkedList<Integer> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(item);
        singLinkList.add(89);
        singLinkList.add(45);

        // When
        singLinkList.remove(0);

        // Then
        Assert.assertFalse(singLinkList.contains(item));
    }

    @Test
    public void removeTest2() {
        // Given
        Integer item = 8;
        SinglyLinkedList<Integer> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(89);
        singLinkList.add(45);
        singLinkList.add(item);


        // When
        singLinkList.remove(2);

        // Then
        Assert.assertFalse(singLinkList.contains(item));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeTest3() {
        // Given
        SinglyLinkedList<Integer> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(89);
        singLinkList.add(45);
        singLinkList.add(45);

        // When
        singLinkList.remove(3);
    }

    @Test
    public void findTest2() {
        // Given
        Integer item = 8;
        SinglyLinkedList<Integer> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(89);
        singLinkList.add(45);
        singLinkList.add(item);
        singLinkList.add(987);
        Integer expectedIndex = 2;

        // When
        Integer actualIndex = singLinkList.find(item);

        // Then
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void findTest3() {
        // Given
        Integer item = 8;
        SinglyLinkedList<Integer> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(89);
        singLinkList.add(45);
        singLinkList.add(item);
        singLinkList.add(987);
        Integer expectedIndex = -1;

        // When
        Integer actualIndex = singLinkList.find(5);

        // Then
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void findTest4() {
        // Given
        Integer item = null;
        SinglyLinkedList<Integer> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(89);
        singLinkList.add(45);
        singLinkList.add(9834);
        singLinkList.add(item);
        Integer expectedIndex = 3;

        // When
        Integer actualIndex = singLinkList.find(item);

        // Then
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void sizeTest() {
        // Given
        SinglyLinkedList<Integer> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(89);
        singLinkList.add(45);
        singLinkList.add(8);
        singLinkList.add(987);
        Integer expectedSize = 4;

        // When
        Integer actualSize = singLinkList.size();

        // Then
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getTest1() {
        // Given
        Integer expectedItem = 8;
        SinglyLinkedList<Integer> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(89);
        singLinkList.add(45);
        singLinkList.add(expectedItem);
        singLinkList.add(987);
        Integer index = 2;

        // When
        Integer actualItem = singLinkList.get(index);

        // Then
        Assert.assertEquals(expectedItem, actualItem);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getTest2() {
        // Given
        SinglyLinkedList<Integer> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(89);
        singLinkList.add(45);
        singLinkList.add(98);
        singLinkList.add(987);

        // When
        Integer item = singLinkList.get(5);
    }

    @Test
    public void copy() {
    }

    @Test
    public void sort() {
    }
}
