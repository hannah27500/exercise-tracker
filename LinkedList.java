package model;
/** This class has methods to represent a linked list
 * @author Hannah Evans
 * @version 1.0
 * @since 1.0
*/

public class LinkedList {
	private int size;
	private Node head;

	public LinkedList() {
		this.size = 0;
		this.head = null;

	}


	public boolean isEmpty() {
		// returns true if size is 0
		return (size == 0);
	}

	public Node get(int position) {
		Node current = head;
		// goes through the list until i is equal to the position and returns that value
		for (int i = 0; i < position; i++) {
			current = current.getNext(); // Move to the next node
		}
		return current;

	}

	public int size() {
		// returns size of the list
		return size;
	}

	public void insertLast(String exerciseName,int minutes) {
		Node newNode = new Node(exerciseName,minutes);

		if (isEmpty()) { // if the list is empty then the new item is placed is the new head
			head = newNode;
		} else {
			// if not 1st item goes until the next node is null and then sets the null to
			// the new item
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}

			current.setNext(newNode);
		}
		// size increases to adjust
		size++;
	}

	public String print() {
		Node current = head;
		String toPrint = "{\n";
		// goes through the list of items
		for (int i = 0; i < size; i++) {
			if ((i + 1) == size) {
				// if is the last item in the list will not put a comma after it
				toPrint += current.getData();
			} else {
				// adds items to the string and a comma after
				toPrint += current.getData();
				toPrint += ",";
				current = current.getNext(); // Move to the next node
			}
			toPrint +="\n"; 
		}
		toPrint += "}";
		return toPrint;
	}

	public void removeAt(int position) throws ListEmptyException {
		// if size is not 0 will remove if it is then throws exception
		if (size != 0) {
			// if remove from position 0 the head is now the next item since current head is
			// removed
			if (position == 0) {
				head = head.getNext();
			} else {
				Node current = head;
				Node previous = null;
				// goes through to get to the position to remove
				for (int i = 0; i < position; i++) {
					previous = current;
					current = current.getNext();
				}

				previous.setNext(current.getNext());
			}
			// reduces size of list and if that makes it 0 head is set to null
			size--;
			if (size == 0) {
				head = null;
			}
		} else {
			throw new ListEmptyException("List is empty.");
		}
	}
	
	public void selectionSortAlgorithm() {
	    Node current = head;

	    // goes through each item in the list
	    while (current != null) {
	        Node first = current;  
	        Node next = current.getNext();

	        
	        while (next != null) {
	            // checks if next comes before the current first alphabetically and if does then next becomes the new first
	            if (next.getExerciseName().compareToIgnoreCase(first.getExerciseName()) < 0) {
	                first = next;  // Found a new minNode
	            }
	            next = next.getNext();
	        }

	        // swaps them if current is not already first
	        if (first != current) {
	            String tempExercise = current.getExerciseName();
	            int tempMinutes = current.getMinutes();
	            // sets currents exercise name and minutes to the first ones
	            current.setExerciseName(first.getExerciseName());
	            current.setMinutes(first.getMinutes());
	            // sets the first ones to the temporarily stored ones
	            first.setExerciseName(tempExercise);
	            first.setMinutes(tempMinutes);
	        }

	        // go to the next one
	        current = current.getNext();
	    }
	}
	

}
