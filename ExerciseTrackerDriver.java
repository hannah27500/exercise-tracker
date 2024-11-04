import model.ExerciseTracker;

public class ExerciseTrackerDriver {

	public static void main(String[] args) {
		
	ExerciseTracker tracker = new ExerciseTracker();
		System.out.println(tracker.getExercises());
		
		
		tracker.logAndCalcExercise("Running", 8);
		System.out.println("RUNNING EXERCISE");
		System.out.println(tracker.printAllExercises());

		System.out.println("RUNNING & WALKING EXERCISE");
		tracker.logAndCalcExercise("Walking", 24);

		System.out.println(tracker.printAllExercises());
		tracker.deleteExercise();

		System.out.println("DELETE RUNNING EXERCISE");
		System.out.println(tracker.printAllExercises());

	}

}
