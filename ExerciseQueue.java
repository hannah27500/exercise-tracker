
/** Creates a queue implementation using Linked List
 * @author Hannah Evans
 * @version 1.0
 * @since 1.0
*/


import java.util.LinkedList;


public class ExerciseQueue {
	// Members
	private LinkedList<Node> qList;

	public ExerciseQueue() {
		this.qList = new LinkedList<>();
	}



	/**
	 * @return If queue is full
	 */
	public boolean isFull() {
		return false;
	}

	/**
	 * @return If queue is empty
	 */
	public boolean isEmpty() {
		return qList.size() == 0;
	}

	/**
	 * @return Returns number of elements in the queue
	 */
	public int size() {
		return qList.size();
	}

	/**
	 * @return Returns element at head of queue
	 * @throws StackEmptyException //
	 */
	public Node peek() {
		if (!qList.isEmpty()) {
		return qList.peekFirst();
		}
		else {
			// TO DO THROW EXCEPTION
			return null;
		}
	}

	/**
	 * @return Removes and returns element at head of queue
	 * @throws QueueEmptyException
	 */
	public Node dequeue()  {
		if (!qList.isEmpty()) {
			Node itemRemoved = qList.removeFirst();
			return itemRemoved;
		} else {
			// TO DO THROW EXCEPTION
			return null;
		}
	}

	/**
	 * Adds item to tail of the queue
	 * 
	 * @param item
	 */
	public void enqueue(Node item)  {
		qList.addLast(item);
	}

	/**
	 * @return Returns list of queue items from head to tail one per line (eg Item1
	 *         Item2 Item3 ...) if queue is empty returns "Queue is Empty"
	 */
	public String printQueue()  {
		
		if (!qList.isEmpty()) {
			String printString = "";
			for (Node item : qList) {
                printString+= item.getData() +"    ";
            }
			return printString;
		} else {
			// TO DO THROW EXCEPTION 
			return "";
		}
	}
	
	public static void main(String[] args) {
		Node biking = new Node("biking",35);
		Node walking = new Node("walking",24);
		Node running = new Node("running",13);
		ExerciseQueue e = new ExerciseQueue();
		e.enqueue(biking);
		System.out.println(e.printQueue());
		e.enqueue(walking);
		System.out.println(e.printQueue());
		e.dequeue();
		System.out.println(e.printQueue());
	}
}