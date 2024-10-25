

public class ExerciseTracker {
	
//	private Queue performedExercise;
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
	public String printLoggedExercises() {
		return performedExercises.printQueue();
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
	
	public static void main(String[] args) {
		ExerciseTracker tracker = new ExerciseTracker();
		tracker.logAndCalcExercise("Running", 8);
		System.out.println(tracker.printLoggedExercises());
		tracker.logAndCalcExercise("Walking", 20);
		System.out.println(tracker.printLoggedExercises());
		tracker.deleteExercise();
		System.out.println(tracker.printLoggedExercises());
		System.out.println(tracker.getExercises());
	}
	
	

}
