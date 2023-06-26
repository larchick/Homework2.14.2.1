package com.example.homework14;

import com.example.homework14.service.IntegerList;
import com.example.homework14.service.IntegerListImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        IntegerList integerList1 = new IntegerListImpl();
        IntegerList integerList2 = new IntegerListImpl();

        // проверка пустой
        System.out.println(integerList1.isEmpty());

        //добавление элементов
        System.out.println(integerList1.add(11111));
        System.out.println(integerList2.add(11111));

        //сравнение если равны
        System.out.println(integerList1.equals(integerList2));

        //добавим еще
        System.out.println(integerList1.add(22));
        System.out.println(integerList1.add(33));
        System.out.println(integerList1.add(44));

        //сравнение если не равны
        System.out.println(integerList1.equals(integerList2));

        //проверка не пустой
        System.out.println(integerList1.isEmpty());

        //добавление по индексу
        System.out.println(integerList1.add(1, 55));

        //замена значение по индексу
        System.out.println(integerList1.set(3, 67));

        // удаление по значению
        integerList1.remove(11111);

        // удаление по индексу
        integerList1.removeByIndex(2);


        //содержит значение
        System.out.println(integerList1.contains(55));

        //находит индекс первого вхождения по возрастанию
        System.out.println(integerList1.indexOf(22));

        //находит индекс первого вхождения в реверсе
        System.out.println(integerList1.lastIndexOf(44));

        //получаем элемент по индексу
        System.out.println(integerList1.get(2));

        //получаем размер листа
        System.out.println(integerList1.size());

        integerList1.clear();

        integerList1.add(55);

        System.out.println("____________");
        // создаем копию массива из нашего списка
        System.out.println(Arrays.toString(integerList1.toArray()));

        // Наш массив для тестов
        IntegerList listForSort = new IntegerListImpl();
        for (int i = 0; i < 10_000; i++) {
            listForSort.add((int) (Math.random() * 11_000));
        }

        IntegerList listForSortCopy1 = listForSort;
        IntegerList listForSortCopy2 = listForSort;

        System.out.println("~~~~~~~~~~~ неотсортированный массив ~~~~~~~~~~~~~~~~~ ");
        System.out.println(Arrays.toString(listForSort.toArray()));
        System.out.println();

        // Сортировка методом пузырька
        System.out.println("============== Сортировка методом пузырька ============");
        long start = System.currentTimeMillis();
        listForSort.bubbleSort(listForSort);
        System.out.println((System.currentTimeMillis() - start) + "ms");
        System.out.println(Arrays.toString(listForSort.toArray()));
        System.out.println();


        // Сортировка выбором
        System.out.println("============== Сортировка выбором ============");
        long start2 = System.currentTimeMillis();
        listForSortCopy1.sortSelection(listForSortCopy1);
        System.out.println((System.currentTimeMillis() - start2) + "ms");
        System.out.println(Arrays.toString(listForSortCopy1.toArray()));
        System.out.println();


        // Сортировка вставкой
        System.out.println("============== Сортировка вставкой ============");
        long start3 = System.currentTimeMillis();
        listForSortCopy2.sortInsertion(listForSortCopy2);
        System.out.println((System.currentTimeMillis() - start3) + "ms");
        System.out.println(Arrays.toString(listForSortCopy2.toArray()));
        System.out.println();

        // бинарный поиск
        System.out.println("============== Бинарный поиск ============");
        System.out.println(listForSort.contains(12));

    }

}
