package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

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
        String item = "hi";
        SinglyLinkedList<String> singLinkList = new SinglyLinkedList<>();
        singLinkList.add("asdf");
        singLinkList.add("fdsa");
        singLinkList.add(item);
        singLinkList.add("oaiusdgf");
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
        SinglyLinkedList<Long> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(89L);
        singLinkList.add(45L);
        singLinkList.add(98L);
        singLinkList.add(987L);

        // When
        Long item = singLinkList.get(5);
    }

    @Test
    public void copyTest1() {
        // Given
        SinglyLinkedList<Integer> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(89);
        singLinkList.add(45);
        singLinkList.add(98);
        singLinkList.add(987);

        // When
        SinglyLinkedList<Integer> copy = singLinkList.copy();

        // Then

        for (int i = 0; i < singLinkList.size(); i++) {
            Assert.assertEquals(singLinkList.get(i), copy.get(i));
        }
    }

    @Test
    public void copyTest2() {
        // Given
        SinglyLinkedList<Date> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(new Date(10000098475L));
        singLinkList.add(new Date(2459873459L));
        singLinkList.add(new Date(92304875L));
        singLinkList.add(new Date(9823475L));

        // When
        SinglyLinkedList<Date> copy = singLinkList.copy();

        // Then
        for (int i = 0; i < singLinkList.size(); i++) {
            Assert.assertEquals(singLinkList.get(i), copy.get(i));
        }
    }

    @Test
    public void copyTest3() {
        // Given
        SinglyLinkedList<Date> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(new Date(10000098475L));
        singLinkList.add(new Date(2459873459L));
        singLinkList.add(new Date(92304875L));
        singLinkList.add(new Date(9823475L));

        // When
        SinglyLinkedList<Date> copy = singLinkList.copy();
        copy.get(0).setTime(287364928436L);

        // Then
        Assert.assertNotEquals(singLinkList.get(0), copy.get(0));
    }

    @Test
    public void copyTest4() {
        // Given
        SinglyLinkedList<Date> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(new Date(10000098475L));
        singLinkList.add(new Date(2459873459L));
        singLinkList.add(new Date(92304875L));
        singLinkList.add(new Date(9823475L));

        // When
        SinglyLinkedList<Date> copy = singLinkList.copy();
        copy.get(0).setTime(287364928436L);

        // Then
        for (int i = 1; i < singLinkList.size(); i++) {
            Assert.assertEquals(singLinkList.get(i), copy.get(i));
        }
    }

    @Test
    public void copyTest5() {
        // Given
        SinglyLinkedList<Date> singLinkList = new SinglyLinkedList<>();

        // When
        SinglyLinkedList<Date> copy = singLinkList.copy();

        // Then
        Assert.assertEquals(0, (int) copy.size());
    }

    @Test
    public void sortTest1() {
        // Given
        SinglyLinkedList<Long> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(43L);
        singLinkList.add(45L);
        singLinkList.add(98L);
        singLinkList.add(987L);
        Long[] expected = {43L, 45L, 98L, 987L};

        // When
        singLinkList.sort();
        Long[] actual = new Long[singLinkList.size()];
//        for (int i = 0; i < actual.length; i++) {
//            actual[i] = singLinkList.get(i);
//        }
        actual[0] = singLinkList.get(0);
        actual[1] = singLinkList.get(1);
        actual[2] = singLinkList.get(2);
        actual[3] = singLinkList.get(3);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTest2() {
        // Given
        SinglyLinkedList<Integer> singLinkList = new SinglyLinkedList<>();
        singLinkList.add(8734);
        singLinkList.add(874);
        singLinkList.add(3874834);
        singLinkList.add(4);
        Integer[] expected = {4, 874, 8734, 3874834};

        // When
        singLinkList.sort();
        Integer[] actual = new Integer[singLinkList.size()];
        for (int i = 0; i < actual.length; i++) {
            actual[i] = singLinkList.get(i);
        }

        Assert.assertArrayEquals(expected, actual);
    }
}
