package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.ListEmptyException;
import model.LinkedList;
import model.Node;
import model.QueueEmptyException;

class LinkedListTest {
	
	
	@Test 
	void testSelectionSortAlgorithm() {
		LinkedList newList = new LinkedList();
		newList.insertLast("pilates",6);
		newList.insertLast("swimming",5);
		newList.insertLast("dancing",5);
		newList.insertLast("running",9);
		
		String expected = "{\n" + "Exercise: dancing Calories Per Minute: 5,\n" +
				"Exercise: pilates Calories Per Minute: 6,\n" + 
				"Exercise: running Calories Per Minute: 9,\n"+
				"Exercise: swimming Calories Per Minute: 5\n"+"}";
		newList.selectionSortAlgorithm();
		assertEquals(expected, newList.print());
	}

	@Test
	void testIsEmpty() {
		// Tests list with no items that is empty
		LinkedList emptyList = new LinkedList();
		assertEquals(true, emptyList.isEmpty());

		// Tests list with 1 item that is not empty
		LinkedList newList2 = new LinkedList();
		
		newList2.insertLast("yoga",5);
		assertEquals(false, newList2.isEmpty());
	}
	
	
	@Test
	void testLastInsert() {
		LinkedList newList = new LinkedList();
		// inserts this as last in the list
		newList.insertLast("walking",4);
		assertEquals(false, newList.isEmpty());
		assertEquals("{\n" + "Exercise: walking Calories Per Minute: 4\n"+ "}", newList.print());
		// inserts marker last in the list
		newList.insertLast("running",12);
		assertEquals("{\n" + "Exercise: walking Calories Per Minute: 4,\n" +
		"Exercise: running Calories Per Minute: 12\n" + "}", newList.print());
	}
	
	
	@Test
	void testRemoveAt() throws ListEmptyException {
		// Removes first item
		LinkedList newList = new LinkedList();
		newList.insertLast("pilates",6);
		newList.insertLast("dancing",5);
		newList.insertLast("running",9);
		newList.removeAt(0);
		assertEquals("{\n" + "Exercise: dancing Calories Per Minute: 5,\n" +
				"Exercise: running Calories Per Minute: 9\n" + "}", newList.print());

		// Removes first item and makes it empty
		LinkedList newList2 = new LinkedList();
		newList2.insertLast("walking",4);
		newList2.removeAt(0);
		assertEquals("{\n}", newList2.print());

		// Removes 2nd item in list at index 1
		LinkedList newList3 = new LinkedList();
		newList3.insertLast("walking",4);
		newList3.insertLast("dancing",6);
		newList3.insertLast("strength training",8);
		newList3.removeAt(1);
		assertEquals("{\n" + "Exercise: walking Calories Per Minute: 4,\n" +
				"Exercise: strength training Calories Per Minute: 8\n" + "}", newList3.print());


		// tries to remove from empty list
		LinkedList emptyList = new LinkedList();
		assertThrows(ListEmptyException.class, () -> emptyList.removeAt(0));

	}
	
	@Test
	void testPrintEmpty() {
		// prints an empty list
		LinkedList newList = new LinkedList();
		assertEquals("{\n}", newList.print());
	}
	
	@Test
	void testPrint() {
		LinkedList newList = new LinkedList();
		newList.insertLast("running",10);
		newList.insertLast("dancing",6);
		newList.insertLast("walking",5);
		newList.insertLast("yoga",3);
		// prints list with 4 items
		assertEquals("{\n" + "Exercise: running Calories Per Minute: 10,\n" +
				"Exercise: dancing Calories Per Minute: 6,\n" +
				"Exercise: walking Calories Per Minute: 5,\n" +
				"Exercise: yoga Calories Per Minute: 3\n" +"}", newList.print());
	}
	
	@Test
	void testSize() {
		LinkedList newList = new LinkedList();
		// tests that size starts as 0
		assertEquals(0, newList.size());
		newList.insertLast("swimming",5);
		newList.insertLast("running",10);
		// 2 items are added and checks that size is now 2
		assertEquals(2, newList.size());
		newList.insertLast("walking",6);
		assertEquals(3, newList.size());
	}
	
	@Test
	void testGet() {
		LinkedList newList = new LinkedList();
		assertEquals(0, newList.size());
		newList.insertLast("running",10);
		newList.insertLast("dancing",6);
		assertEquals(2, newList.size());
		newList.insertLast("swimming",5);
		assertEquals(3, newList.size());
		// tests the get method for the first and 3rd items
		assertEquals("running", newList.get(0).exerciseName);
		assertEquals("swimming", newList.get(2).exerciseName);
	}


}
