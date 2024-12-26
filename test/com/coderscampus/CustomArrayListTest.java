package com.coderscampus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {

    @Test
    void should_add_new_item_to_custom_list() {
        CustomList<String> list = new CustomArrayList<>();
        boolean result = list.add("item1");
        assertTrue(result, "Item should be added successfully");
        assertEquals(1, list.getSize(), "List size should increase to 1");
        assertEquals("item1", list.get(0), "First item should match the added item");
    }

    @Test
    void should_add_new_item_to_custom_list_at_specified_index() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        boolean result = list.add(1, "newItem");
        assertTrue(result, "Item should be added successfully");
        assertEquals(4, list.getSize(), "List size should increase after insertion");
        assertEquals("item1", list.get(0), "First item should remain unchanged");
        assertEquals("newItem", list.get(1), "New item should be inserted at the correct index");
        assertEquals("item2", list.get(2), "Items should shift correctly");
        assertEquals("item3", list.get(3), "Remaining items should maintain their order");
    }

    @Test
    void should_throw_exception_when_adding_item_to_invalid_index() {
        CustomList<String> list = new CustomArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, "invalid"),
                "Should throw IndexOutOfBoundsException for invalid index");
    }

    @Test
    void should_return_correct_size_of_custom_list() {
        CustomList<String> list = new CustomArrayList<>();
        assertEquals(0, list.getSize(), "Size should be 0 for an empty list");
        list.add("item1");
        assertEquals(1, list.getSize(), "Size should update after adding an item");
        list.add("item2");
        assertEquals(2, list.getSize(), "Size should reflect 2 after adding additional item");
        list.add("item3");
        assertEquals(3, list.getSize(), "Size should reflect all 3 added items");
    }

    @Test
    void should_return_item_at_specified_index() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("item1");
        list.add("item2");
        assertEquals("item1", list.get(0), "Item at index 0 should match");
        assertEquals("item2", list.get(1), "Item at index 1 should match");
    }

    @Test
    void should_throw_exception_when_accessing_invalid_index() {
        CustomList<String> list = new CustomArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0),
                "Should throw IndexOutOfBoundsException for invalid index");
    }

    @Test
    void should_remove_item_from_specified_index_without_leaving_a_gap() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        String removedItem = list.remove(1);
        assertEquals("item2", removedItem, "Removed item should match the expected value");
        assertEquals(2, list.getSize(), "List size should decrease after removal");
        assertEquals("item1", list.get(0), "Items should shift correctly after removal");
        assertEquals("item3", list.get(1), "Remaining items should maintain correct order");
    }

    @Test
    void should_throw_exception_when_removing_item_from_invalid_index() {
        CustomList<String> list = new CustomArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0),
                "Should throw IndexOutOfBoundsException when removing from an invalid index");
    }

    @Test
    void should_expand_internal_array_when_capacity_is_exceeded() {
        CustomList<Integer> list = new CustomArrayList<>();
        int initialCapacity = 10;
        for (int i = 0; i < initialCapacity + 5; i++) {
            list.add(i);
        }
        assertEquals(initialCapacity + 5, list.getSize(), "List size should increase beyond initial capacity");
        for (int i = 0; i < list.getSize(); i++) {
            assertEquals(i, list.get(i), "Items should be added and accessible correctly");
        }
    }

    @Test
    void should_handle_null_values() {
        CustomList<String> list = new CustomArrayList<>();
        list.add(null);
        assertEquals(1, list.getSize(), "Size should increase even when adding null");
        assertNull(list.get(0), "Null value should be retrievable");
    }
}
