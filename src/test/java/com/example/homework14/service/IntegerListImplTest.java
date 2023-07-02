package com.example.homework14.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    IntegerList integerList = new IntegerListImpl();

    public static Stream<Arguments> itemsForTestAdd() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(11, 11),
                Arguments.of(111, 111)
        );
    }

    public static Stream<Arguments> itemsForTestAddByIndex() {
        return Stream.of(
                Arguments.of(0, 1, 1),
                Arguments.of(1, 11, 11),
                Arguments.of(2, 111, 111)
        );
    }

    @ParameterizedTest
    @MethodSource("itemsForTestAdd")
    public void shouldReturnAddedString(Integer putIn, Integer expected) {
        //given

        //when
        Integer actual = integerList.add(putIn);

        //then
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @MethodSource("itemsForTestAddByIndex")
    public void shouldAddItemInListOnIndexPosition(int index, Integer item, Integer expected) {

        //given вот здесь я не совсем понял как сделать так, чтобы у меня мой лист не был пустым, через сеттер?, но это тоже метод.
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        Integer actual = integerList.add(index, item);
        assertEquals(expected, actual);

    }

    @Test
    public void shouldThrowExceptionWhenAddByIndexMoreThanSize() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            integerList.add(1, 13);
        });
    }

    @ParameterizedTest
    @MethodSource("itemsForTestAddByIndex")
    public void shouldSetElementByIndex(int index, Integer item, Integer expected) {
        //given
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        //when
        Integer actual = integerList.add(index, item);

        //then

        assertEquals(expected, actual);

    }

    @Test
    public void shouldThrowExceptionWhenSetByIndexMoreThanSize() {
        //given
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        //when
        //then

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            integerList.set(3, 45);
        });
    }

    @Test
    public void shouldRemoveByItem() {
        //given
        integerList.add(123);
        integerList.add(321);
        integerList.add(231);
        //when
        Integer actual = integerList.remove( 321);
        Integer expected = 321;
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionRemoveIfElementNotFound() {
        //given
        integerList.add(123);
        integerList.add(321);
        integerList.add(231);
        //when
        //then
        Assertions.assertThrows(RuntimeException.class, () -> {
            integerList.remove(555);
        });
    }

    @Test
    public void shouldRemoveElementByIndex() {
        //given
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        //when
        Integer actual = integerList.removeByIndex(2);
        Integer expected = 3;
        //then

        assertEquals(expected, actual);

    }

    @Test
    public void shouldThrowExceptionIfIndexMoreThanSize() {
        //given
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        //when
        //then
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            integerList.removeByIndex(256);
        });
    }

    @Test
    public void shouldCheckContainTrue() {
        //given
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        //when
        boolean actual = integerList.contains(2);
        boolean expected = true;

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckContainFalse() {
        //given
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        //when
        boolean actual = integerList.contains(5);
        boolean expected = false;

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnIndexOfItemIfContains() {
        //given
        integerList.add(1);
        integerList.add(3);
        integerList.add(2);
        integerList.add(3);

        //when
        int actual = integerList.indexOf(3);
        int expected = 1;

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnIndexOfItemIfDoesNotContain() {
        //given
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        //when
        int actual = integerList.indexOf(13);
        int expected = -1;

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnLastIndexOfItemIfContains() {
        //given
        integerList.add(1);
        integerList.add(3);
        integerList.add(2);
        integerList.add(3);

        //when
        int actual = integerList.lastIndexOf(3);
        int expected = 3;

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnLastIndexOfItemIfDoesNotContain() {
        //given
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        //when
        int actual = integerList.lastIndexOf(13);
        int expected = -1;

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnElementByIndex() {
        //given
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        //when
        Integer actual = integerList.get(1);
        Integer expected = 2;

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfIndexForGetterMoreThanSize() {
        //given
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        //when
        //then
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            integerList.get(128);
        });
    }

    @Test
    public void shouldEqualsIfTrue() {
        //given
        integerList.add(1);
        IntegerList integerList1 = new IntegerListImpl();
        integerList1.add(1);

        //when
        boolean actual = integerList.equals(integerList1);
        boolean expected = true;

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void shouldEqualsIfFalse() {
        //given
        integerList.add(1);
        IntegerList integerList1 = new IntegerListImpl();
        integerList1.add(2);

        //when
        Boolean actual = integerList.equals(integerList1);
        Boolean expected = false;

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void shouldEqualsIfNull() {
        //given
        integerList.add(2);
        IntegerList integerList1 = null;

        //when
        //then
        Assertions.assertThrows(RuntimeException.class, () -> {
            integerList.equals(integerList1);
        });

    }

    @Test
    public void shouldReturnSize() {
        //given
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        //when
        int actual = integerList.size();
        int expected = 3;

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void shouldReturnTrueIsEmpty() {
        //given
        //stringList.add("");

        //when
        boolean actual = integerList.isEmpty();
        boolean expected = true;

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void shouldReturnFalseIsEmpty() {
        //given
        integerList.add(0);

        //when
        boolean actual = integerList.isEmpty();
        boolean expected = false;

        //then
        assertEquals(expected, actual);

    }

}