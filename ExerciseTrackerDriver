import model.ExerciseTracker;

public class ExerciseTrackerDriver {

	public static void main(String[] args) {
		
		ExerciseTracker tracker = new ExerciseTracker();
		System.out.println(tracker.getExercises());
		
		
		String calories = tracker.logAndCalcExercise("biking",10);
		
		System.out.println(tracker.printAllExercises());
		tracker.logAndCalcExercise("walking",24);
		System.out.println(tracker.printAllExercises());
		tracker.deleteExercise();
		System.out.println(tracker.printAllExercises());

	}

}
