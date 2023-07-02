package com.example.homework14.service;

import com.example.homework14.exception.InvalidIndexException;
import com.example.homework14.exception.NullItemException;
import com.example.homework14.exception.StorageIsFullException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private Integer[] storage;
    private int size;

    public IntegerListImpl() {
        storage = new Integer[10];
    }

    public IntegerListImpl(int intSize) {
        storage = new Integer[intSize];
    }

    private Integer[] grow() {
        Integer[] tmp = storage;
        storage = new Integer[storage.length + (storage.length / 2)];
        for (int i = 0; i < tmp.length; i++) {
            storage[i] = tmp[i];
        }
        return storage;
    }

    @Override
    public Integer add(Integer item) {
        //validateSize();
        validateItem(item);
        if (size == storage.length) {
            grow();
        }
        storage[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        //validateSize();
        validateItem(item);
        validateIndex(index);

        if (size == storage.length) {
            grow();
        }

        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;

        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);

        int index = indexOf(item);

        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = storage[index];

        if (index != size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);

        }
        size--;
        return item;
    }

    @Override
    public Integer removeByIndex(int index) {
        return null;
    }

    @Override
    public boolean contains(Integer item) {

        Integer[] storageCopy = toArray();
        sort(storageCopy);

        return binarySearch(storageCopy, item);

    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == storage.length) {
            throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    public Integer[] sort(Integer[] arr) {
        return sortRecursive(arr, arr.length);
    }
    private Integer[] sortRecursive(Integer[] arr, int n) {
        if (n <= 1) {
            return arr;
        }
        sortRecursive(arr, n - 1);
        int lastElement = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > lastElement) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = lastElement;
        return arr;
    }

    public boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

}