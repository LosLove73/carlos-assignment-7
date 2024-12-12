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
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (index > 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds: " + index);
		}
		return (T) items[index];
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

}
