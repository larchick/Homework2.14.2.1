package com.example.homework14.service;

public class IntegerListImpl implements IntegerList {

    private Integer[] stringList = new Integer[0];
    private Integer[] buffer_1 = new Integer[0];




    @Override
    public Integer add(Integer item) {
        if (item != null) {
            buffer_1 = stringList;
            stringList = new Integer[stringList.length + 1];

            for (int i = 0; i < buffer_1.length; i++) {
                stringList[i] = buffer_1[i];
            }
            stringList[stringList.length - 1] = item;
        }
        return stringList[stringList.length - 1];
    }

    public Integer add(int index, Integer item) {
        if (index > stringList.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            buffer_1 = stringList;
            stringList = new Integer[stringList.length + 1];
            stringList[index] = item;
            for (int i = 0; i < stringList.length - 1; i++) {
                if (i < index) {
                    stringList[i] = buffer_1[i];
                } else {
                    stringList[i + 1] = buffer_1[i];
                }
            }
        }

        return stringList[index];
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index >= stringList.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            stringList[index] = item;
            return stringList[index];
        }
    }

    @Override
    public Integer remove(Integer item) {
        int divider = 0;
        buffer_1 = stringList;

        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)) {
                divider = i;
                stringList = new Integer[stringList.length - 1];
                break;
            }
        }

        if (stringList.length == buffer_1.length) {
            throw new RuntimeException("Такой элемент отсутствует");
        }

        for (int j = 0; j < stringList.length; j++) {
            if (j < divider) {
                stringList[j] = buffer_1[j];
            } else {
                stringList[j] = buffer_1[j + 1];
            }
        }
        return item;
    }

    @Override
    public Integer remove(int index) {
        return null;
    }


    @Override
    public Integer removeByIndex(int index) {
        if (index >= stringList.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            buffer_1 = stringList;
            stringList = new Integer[stringList.length - 1];

            for (int j = 0; j < stringList.length; j++) {
                if (j < index) {
                    stringList[j] = buffer_1[j];
                } else {
                    stringList[j] = buffer_1[j + 1];
                }
            }
        }
        return buffer_1[index];
    }

    @Override
    public boolean contains(Integer item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = stringList.length - 1; i > 0; i--) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index >= stringList.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return stringList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new RuntimeException("передан null");
        }
        if (stringList.length != otherList.size()) {
            return false;
        }
        for (int i = 0; i < stringList.length; i++) {
            if (!stringList[i].equals(otherList.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int size() {
        return stringList.length;
    }

    @Override
    public boolean isEmpty() {
        if (stringList.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        stringList = new Integer[0];
    }

    @Override
    public Integer[] toArray() {
        Integer[] result = stringList;
        return result;
    }

    private void swap(IntegerList array, Integer big, Integer little) {
        Integer tmp = array.get(big);
        array.set(big, array.get(little));
        array.set(little, tmp);
    }

    @Override
    public void bubbleSort(IntegerList unsortedArray) {
        for (int i = 0; i < unsortedArray.size() - 1; i++) {
            for (int j = 0; j < unsortedArray.size() - 1 - i; j++) {
                if (unsortedArray.get(j + 1) < unsortedArray.get(j)) {
                    swap(unsortedArray, j, j + 1);
                }
            }

        }
    }

    public void sortSelection(IntegerList unsortedArray) {
        for (int i = 0; i < unsortedArray.size() - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < unsortedArray.size(); j++) {
                if (unsortedArray.get(j) < unsortedArray.get(minElementIndex)) {
                    minElementIndex = j;
                }
            }
            swap(unsortedArray, i, minElementIndex);
        }
    }

    public void sortInsertion(IntegerList unsortedArray) {
        for (int i = 1; i < unsortedArray.size(); i++) {
            int temp = unsortedArray.get(i);
            int j = i;
            while (j > 0 && unsortedArray.get(j - 1) >= temp) {
                unsortedArray.set(j, unsortedArray.get(j - 1));
                j--;
            }
            unsortedArray.set(j, temp);
        }
    }


    public boolean contains(IntegerList sortedArray, Integer element) {
        int min = 0;
        int max = sortedArray.size();
        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == sortedArray.get(mid)) {
                return true;
            }
            if (element < sortedArray.get(mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}