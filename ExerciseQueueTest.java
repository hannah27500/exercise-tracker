package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.ExerciseQueue;
import model.Node;
import model.QueueEmptyException;

class ExerciseQueueTest {

	@Test
	void testCreateQueue() {
		// ARRANGE
		ExerciseQueue myQueue = new ExerciseQueue();
		boolean actual;
		// ACT
		actual = myQueue.isEmpty();
		// ASSERT
		assertTrue(actual);
	}

	@Test
	void testIsEmptyTrue() {
		// ARRANGE
		ExerciseQueue myQueue = new ExerciseQueue();
		boolean actual;
		// ACT
		actual = myQueue.isEmpty();
		// ASSERT
		assertTrue(actual);
	}

	@Test
	void testIsEmptyFalse() {
		// ARRANGE
		ExerciseQueue myQueue = new ExerciseQueue();
		Node item = new Node("walking",35);
		boolean actual;
		// ACT
		myQueue.enqueue(item);
		actual = myQueue.isEmpty();
		// ASSERT
		assertFalse(actual);
	}


	@Test
	void testEnqueue() {
		// ARRANGE
		ExerciseQueue myQueue = new ExerciseQueue();
		Node item = new Node("running",15);
		Node actual;
		Node expected =item;
		// ACT
		myQueue.enqueue(item);
		actual = myQueue.peek();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testEnqueueDequeue() throws QueueEmptyException {
		// ARRANGE
		ExerciseQueue myQueue = new ExerciseQueue();
		Node item1 = new Node("strength training",52);
		Node item2 = new Node("Swimming", 28);
		Node actual, expected;
		expected = item2;
		// ACT
		myQueue.enqueue(item1);
		myQueue.enqueue(item2);
		myQueue.dequeue();
			
		actual = myQueue.peek();
		// ASSERT
		assertEquals(expected, actual);
	}	


	@Test
	void testDequeue() throws QueueEmptyException {
		// ARRANGE
		ExerciseQueue myQueue = new ExerciseQueue();
		Node item1 = new Node("strength training",52);
		Node item2 = new Node("BIKING", 28);
		Node item3 = new Node("Running", 8);
		
		Node actual, expected;
		expected = item2;
		
		myQueue.enqueue(item1);
		myQueue.dequeue();
		myQueue.enqueue(item2);
		myQueue.enqueue(item3);
		
		// ACT
		actual = myQueue.dequeue();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testDequeueEmptyQueue() {
		// ARRANGE
		ExerciseQueue myQueue = new ExerciseQueue();
		// ACT
		// ASSERT
		assertThrows(QueueEmptyException.class, () -> myQueue.dequeue());
	}
	
	@Test
	void testSizeZero() {
		// ARRANGE
		ExerciseQueue myQueue = new ExerciseQueue();
		int actual, expected;
		expected = 0;
		// ACT
		actual = myQueue.size();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testSizeNonZero() throws  QueueEmptyException {
		// ARRANGE
		ExerciseQueue myQueue = new ExerciseQueue();
		Node item1 = new Node("swimming",41);
		Node item2 = new Node("walking", 80);
		Node item3 = new Node("running", 25);
		
		int actual, expected;
		expected = 2;
		// ACT
		myQueue.enqueue(item1);
		myQueue.enqueue(item2);
		myQueue.enqueue(item3);
		myQueue.dequeue();
		actual = myQueue.size();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testPeek() throws QueueEmptyException {
		// ARRANGE
		ExerciseQueue myQueue = new ExerciseQueue();
		Node item1 = new Node("STRENGTH TRAINING",64);
		
		Node actual, expected;
		// ACT
		myQueue.enqueue(item1);
		expected = item1;
		actual = myQueue.peek();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testPeekEmptyQueue() {
		// ARRANGE
		ExerciseQueue myQueue = new ExerciseQueue();
		// ACT
		// ASSERT
		assertThrows(QueueEmptyException.class, () -> myQueue.peek());
	}
	
	@Test
	void testPrintQueueEmptyQueue() {
		// ARRANGE
		ExerciseQueue myQueue = new ExerciseQueue();
		// ACT
		// ASSERT
		assertThrows(QueueEmptyException.class, () -> myQueue.printQueue());
	}
	
	@Test
	void testPrintQueue() throws QueueEmptyException {
		// ARRANGE
		ExerciseQueue myQueue = new ExerciseQueue();
		Node item1 = new Node("biking",17);
		Node item2 = new Node("walking", 34);
		String actual, expected;
		expected = "Exercise: biking Calories Per Minute: 17\nExercise: walking Calories Per Minute: 34\n";
		// ACT
		myQueue.enqueue(item1);
		myQueue.enqueue(item2);
		actual = myQueue.printQueue();
		// ASSERT
		assertEquals(expected, actual);
	}



}
