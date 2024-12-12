package com.coderscampus;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	public Object[] items;
	private int size;
	
	public CustomArrayList() {
		this.items = new Object[10];
		this.size = 0;
	}

	@Override
	public boolean add(T item) {
		if (size == items.length) {
			items = Arrays.copyOf(items, items.length * 2);
		}
		items[size++] = item;
		return true;
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds: " + index);
		} 
		
		return (T) items[index];
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if (index <0 || index > size) {
			throw new IndexOutOfBoundsException("Indes out of bounds: " + index);
		}
		
		// Store item to be removed
		@SuppressWarnings({ "unused", "unchecked" })
		T removedItem = (T) items[index];
		
		// Shift elements to the left to fill the gap
		for (int i = index; i < size - 1; i++) {
			items[i] = items[i + 1];
		}
		
		// Set the last element to null to avoid memory leaks
		items[size - 1] = null;
		
		// Decrement the size
		size--;
		
		// Return the removed item
		return removedItem;
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of bounds: " + index);
		}
		
		if (size == items.length) {
			items = Arrays.copyOf(items, items.length * 2);
		}
		
		for (int i = size; i > index; i--) {
			items[i] = items[i - 1];
		}
		
		items[index] = item;
		size++;
		return true;
	}

}




