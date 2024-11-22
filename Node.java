
/** The node class to keep track of links of the list
 * @author Hannah Evans
 * @version 1.0
 * @since 1.0
*/

public class Node {

	public String exerciseName;
	private int minutes;
	public Node next;

	public Node(String exerciseName, int minutes) {
		this.exerciseName = exerciseName;
		this.minutes = minutes;
		this.next = null;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		// set minutes
		this.minutes = minutes;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

public String getData() {
	// returns string of the data stored
	return "Exercise: "+exerciseName + " Calories Per Minute: "+minutes;
}

	


}
