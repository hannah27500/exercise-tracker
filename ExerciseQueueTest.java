/** Tests for queue of logged exercises
 * @author Hannah Evans
 * @version 1.0
 * @since 1.0
*/
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.ExerciseQueue;
import model.Node;
import model.QueueEmptyException;

class ExerciseQueueTest {



	@Test
	void testIsEmptyTrue() {
		ExerciseQueue myQueue = new ExerciseQueue();
		boolean actual;
		actual = myQueue.isEmpty();
		// tests if queue empty when created
		assertTrue(actual);
	}

	@Test
	void testIsEmptyFalse() {
		ExerciseQueue myQueue = new ExerciseQueue();
		Node item = new Node("walking", 35);
		boolean actual;
		// adds node item and tests to see if NOT empty
		myQueue.enqueue(item);
		actual = myQueue.isEmpty();
		assertFalse(actual);
	}

	@Test
	void testEnqueue() {
		ExerciseQueue myQueue = new ExerciseQueue();
		Node item = new Node("running", 15);
		Node actual;
		Node expected = item;
		// tests adding a node item
		myQueue.enqueue(item);
		actual = myQueue.peek();
		assertEquals(expected, actual);
	}

	@Test
	void testEnqueueDequeue() throws QueueEmptyException {
		ExerciseQueue myQueue = new ExerciseQueue();
		Node item1 = new Node("strength training", 52);
		Node item2 = new Node("Swimming", 28);
		Node actual, expected;
		expected = item2;
		// adds 2 items and removes one
		myQueue.enqueue(item1);
		myQueue.enqueue(item2);
		myQueue.dequeue();

		actual = myQueue.peek();
		// item 2 should be on top because item 1 removed 1st
		assertEquals(expected, actual);
	}

	@Test
	void testDequeue() throws QueueEmptyException {
		ExerciseQueue myQueue = new ExerciseQueue();
		Node item1 = new Node("strength training", 52);
		Node item2 = new Node("BIKING", 28);
		Node item3 = new Node("Running", 8);

		Node actual, expected;
		expected = item2;
		// adds and deletes item to test
		myQueue.enqueue(item1);
		myQueue.dequeue();
		myQueue.enqueue(item2);
		myQueue.enqueue(item3);
		actual = myQueue.dequeue();
		assertEquals(expected, actual);
	}

	@Test
	void testDequeueEmptyQueue() {
		ExerciseQueue myQueue = new ExerciseQueue();
		assertThrows(QueueEmptyException.class, () -> myQueue.dequeue());
	}

	@Test
	void testSizeZero() {
		ExerciseQueue myQueue = new ExerciseQueue();
		int actual, expected;
		expected = 0;
		// tests if size 0 when create
		actual = myQueue.size();
		assertEquals(expected, actual);
	}

	@Test
	void testSizeNonZero() throws QueueEmptyException {
		ExerciseQueue myQueue = new ExerciseQueue();
		Node item1 = new Node("swimming", 41);
		Node item2 = new Node("walking", 80);
		Node item3 = new Node("running", 25);

		int actual, expected;
		expected = 2;
		// adds 3 and delete one for size of 2
		myQueue.enqueue(item1);
		myQueue.enqueue(item2);
		myQueue.enqueue(item3);
		myQueue.dequeue();
		actual = myQueue.size();
		assertEquals(expected, actual);
	}

	@Test
	void testPeek() throws QueueEmptyException {
		ExerciseQueue myQueue = new ExerciseQueue();
		Node item1 = new Node("STRENGTH TRAINING", 64);
		Node actual, expected;
		// item 1 is added so should be 1st
		myQueue.enqueue(item1);
		expected = item1;
		actual = myQueue.peek();
		assertEquals(expected, actual);
	}

	@Test
	void testPeekEmptyQueue() {
		ExerciseQueue myQueue = new ExerciseQueue();
		// when peek and empty throws error
		assertThrows(QueueEmptyException.class, () -> myQueue.peek());
	}

	@Test
	void testPrintQueueEmptyQueue() {
		ExerciseQueue myQueue = new ExerciseQueue();
		// when print empty throws error
		assertThrows(QueueEmptyException.class, () -> myQueue.printQueue());
	}

	@Test
	void testPrintQueue() throws QueueEmptyException {
		ExerciseQueue myQueue = new ExerciseQueue();
		Node item1 = new Node("biking", 17);
		Node item2 = new Node("walking", 34);
		String actual, expected;
		expected = "Exercise: biking Calories Per Minute: 17\nExercise: walking Calories Per Minute: 34\n";
		// tests printing result
		myQueue.enqueue(item1);
		myQueue.enqueue(item2);
		actual = myQueue.printQueue();
		assertEquals(expected, actual);
	}

}
