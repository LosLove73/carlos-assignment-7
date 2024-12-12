package com.coderscampus;

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

}
