package com.coderscampus;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {

    private Object[] items;
    private int size;

    // Default constructor
    public CustomArrayList() {
        this(10); // Default initial capacity
    }

    // Constructor with initial capacity
    public CustomArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative");
        }
        this.items = new Object[initialCapacity];
        this.size = 0;
    }

    @Override
    public boolean add(T item) {
        ensureCapacity();
        items[size++] = item;
        return true;
    }

    @Override
    public boolean add(int index, T item) {
        validateIndexForAdd(index);
        ensureCapacity();
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        validateIndex(index);
        return (T) items[index];
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        @SuppressWarnings("unchecked")
        T removedItem = (T) items[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(items, index + 1, items, index, numMoved);
        }
        items[--size] = null; // Clear to let GC do its work
        return removedItem;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void clear() {
        Arrays.fill(items, 0, size, null);
        size = 0;
    }

    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (items[i] == null && item == null) {
                return true;
            }
            if (items[i] != null && items[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public void trimToSize() {
        if (size < items.length) {
            items = Arrays.copyOf(items, size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private void ensureCapacity() {
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void validateIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
