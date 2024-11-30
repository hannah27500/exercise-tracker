/** This class keeps track of the linked list of exercises and queue of performed exercises and also calculates calories per minute and displays the queue to show exercises perfromed
 * @author Hannah Evans
 * @version 1.0
 * @since 1.0
*/
package model;


import java.util.Arrays;

public class ExerciseTracker {
	
//	private Queue performedExercise;
	public LinkedList exercises;
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
	
	public String[] getExercisesList() { 
		exercises.selectionSortAlgorithm();
		String[] exerciseNames = new String[exercises.size()];
        for (int i = 0; i < exercises.size(); i++) {
            exerciseNames[i] = exercises.get(i).exerciseName;
        }
        return exerciseNames;
    }
	
	public String getExercises() {
		return exercises.print();
	}

	public String logAndCalcExercise(String exerciseName,int minutesExercised) {
		// creates new node item with exercise name and minutes passed in
		Node newExercise = new Node(exerciseName,minutesExercised);
		// adds node to the queue
		performedExercises.enqueue(newExercise);
		// get calories per minutes from linked list using exercise name
		int calories = getCaloriesPerMin(exerciseName);
		// multiply calories times minutes for total calories burned
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

		        // Re add the exercise to maintain original state
		        performedExercises.enqueue(current); // Restore the exercise back into the queue
		    }

		    return result.toString();
		}
	
	public int getCaloriesPerMin(String exerciseName) {
        Node current = exercises.get(0); // Accessing head of the linked list
        while (current != null) {	
		// finds exercise name that matches and returns those calories per minute
            if (current.getExerciseName().equalsIgnoreCase(exerciseName)) {
                return current.getMinutes();
                
            }
            current = current.getNext();
        }
        return 0; // Return 0 if the exercise is not found
    }
	

	

}
