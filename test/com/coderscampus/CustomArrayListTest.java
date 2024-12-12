package com.coderscampus;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	@Test
	void should_add_new_item_to_custom_list() {
		// Arrange
		CustomList<String> list = new CustomArrayList<>();
		
		
		// Act
		boolean result = list.add("item1");
		
		// Assert
		assertTrue(result);
		assertEquals(1, list.getSize());
		assertEquals("item1", list.get(0));
	}
	
	@Test
	void should_add_new_item_to_custom_list_at_specified_index() {
		// Arrange
		CustomList<String> list = new CustomArrayList<>();
		list.add("item1");
		list.add("item2");
		list.add("item3");
		
		int indexToInsert = 1;
		String newItem = "newItem";
		
		// Act
		boolean result = list.add(indexToInsert, newItem);
		
		// Assert
		assertTrue(result);
		assertEquals(4, list.getSize()); // list size should increase to 4
		assertEquals("item1",list.get(0));  // ensures the first item remains unchanged
		assertEquals("newItem", list.get(1)); // check if the new item is at the right index
		assertEquals("item2", list.get(2)); // checks if items got shifted correctly
		assertEquals("item3", list.get(3)); // checks if the last item is still there
		
	}
	
	@Test
	void should_return_correct_size_of_custom_list() {
		// Arrange
		CustomList<String> list = new CustomArrayList<>();
		
		// Assert the initial sate
		assertEquals(0, list.getSize()); // size should be 0 for an empty list
		
		
		//Assert & Act
		list.add("item1");
		assertEquals(1, list.getSize()); // size should be 1 after adding "item1"
		
		list.add("item2");
		assertEquals(2, list.getSize()); // size should be 2 after adding "item2"
		
		list.add("item3");
		assertEquals(3, list.getSize()); // size should be 3 after adding "item3"
	}
	
	@Test
	void should_return_a_specific_element_when_an_index_is_passed_in() {
		// Arrange
		CustomList<String> list = new CustomArrayList<>();
		
		// Act
		list.add("item1");
		list.add("item2");
		
		// Assert
		assertEquals("item1", list.get(0));
		assertEquals("item2", list.get(1));
	}
	
	@Test
	void should_remove_item_from_specified_index_without_leaving_a_gap() {
		// Arrange
		CustomList<String> list = new CustomArrayList<>();
		list.add("item1");
		list.add("item2");
		list.add("item3");
		list.add("item4");
		
		int indexToRemove = 1;
		
		// Act
		String removedItem = list.remove(indexToRemove);
		
		// Assert
		assertEquals("item2", removedItem);
		assertEquals(3, list.getSize());
		assertEquals("item1", list.get(0));
		assertEquals("item3", list.get(1));
		assertEquals("item4", list.get(2));
		
		
	}

}
