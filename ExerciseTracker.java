

public class ExerciseTracker {
	

	private LinkedList exercises;
	private ExerciseQueue performedExercises;

	public ExerciseTracker() {
		performedExercises = new ExerciseQueue();
		// creates Linked List and adds default exercises
		this.exercises = new LinkedList();
		exercises.insertLast("Running", 10);
		exercises.insertLast("Biking", 7);
		exercises.insertLast("Swimming", 8);
		exercises.insertLast("Walking", 4);
		exercises.insertLast("Strength Training", 7);	
	}
	
	
	public String getExercises() {
		return exercises.print();
	}


	public void setExercises(LinkedList exercises) {
		this.exercises = exercises;
	}

	public String logAndCalcExercise(String exerciseName,int minutesExercised) {
		Node newExercise = new Node(exerciseName,minutesExercised);
		performedExercises.enqueue(newExercise);
		int calories = getCaloriesPerMin(exerciseName);
		int totalCalories = calories * minutesExercised;
		return "Exercise: "+ exerciseName + " Minutes: "+minutesExercised + " Calories Burned: "+totalCalories;
	}
	
	public void deleteExercise() {
		performedExercises.dequeue();
	}
	 public String printAllExercises() {
		 StringBuilder result = new StringBuilder();
		    if (performedExercises.isEmpty()) {
		        return "";
		    }

		    // Store current size to restore queue after processing
		    int size = performedExercises.size();

		    for (int i = 0; i < size; i++) {
		        Node current = performedExercises.dequeue(); // Get and remove the head of the queue

		        // Calculate calories for the current exercise
		        int calories = getCaloriesPerMin(current.getExerciseName());
		        int totalCalories = calories * current.getMinutes();

		        // Append to the result
		        result.append("Exercise: ").append(current.getExerciseName())
		              .append(", Minutes: ").append(current.getMinutes())
		              .append(", Calories Burned: ").append(totalCalories)
		              .append("\n");

		        // Re-enqueue the exercise to maintain original state
		        performedExercises.enqueue(current); // Restore the exercise back into the queue
		    }

		    return result.toString();
		}
	
	private int getCaloriesPerMin(String exerciseName) {
        Node current = exercises.get(0); // Accessing head of the linked list
        while (current != null) {	
            if (current.getExerciseName().equalsIgnoreCase(exerciseName)) {
                return current.getMinutes(); // Assuming minutes represent calories per minute
                
            }
            current = current.getNext();
        }
        return 0; // Return 0 if the exercise is not found
    }
}
