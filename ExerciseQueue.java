
/** Creates a queue implementation of a queue for an exercise tracker
 * @author Hannah Evans
 * @version 1.0
 * @since 1.0
*/
package model;

import java.util.LinkedList;


public class ExerciseQueue {
	// linked list of the node class to hold queue data
	private LinkedList<Node> qList;

	public ExerciseQueue() {
		this.qList = new LinkedList<>();
	}



	
	public boolean isEmpty() {
		// if size 0 is empty
		return qList.size() == 0;
	}

	public int size() {
		return qList.size();
	}


	public Node peek() {
		// returns first node item
		if (!qList.isEmpty()) {
		return qList.peekFirst();
		}
		else {
			throw new QueueEmptyException("Queue is empty.");
		}
	}


	public Node dequeue()  {
		// removes item and returns it if not empty
		if (!qList.isEmpty()) {
			Node itemRemoved = qList.removeFirst();
			return itemRemoved;
		} else {
			throw new QueueEmptyException("Queue is empty");
		}
	}

	
	public void enqueue(Node item)  {
		// adds item to end of queue
		qList.addLast(item);
	}

	
	public String printQueue()  {
		// prints out structure of the queue
		if (!qList.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (Node item : qList) {
                sb.append(item.getData() +"\n");
            }
			return sb.toString();
		} else {
			throw new QueueEmptyException("Queue is empty");
		}
	}
}
