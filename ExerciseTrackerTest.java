package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import model.ExerciseTracker;
import model.LinkedList;
import model.QueueEmptyException;

class ExerciseTrackerTest {

	@Test
	void testGetExercisesList() {
		// tests printing out all the current exercises
		ExerciseTracker trackerTest = new ExerciseTracker();
		String expected = "[Biking, Running, Strength Training, Swimming, Walking]";
		String actual = Arrays.toString(trackerTest.getExercisesList());
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetExercises() {
		// tests printing out all the current exercises
		ExerciseTracker trackerTest = new ExerciseTracker();
		String expected = "{\n" + "Exercise: Running Calories Per Minute: 10,\n"
				+ "Exercise: Biking Calories Per Minute: 7,\n" + "Exercise: Swimming Calories Per Minute: 8,\n"
				+ "Exercise: Walking Calories Per Minute: 4,\n" + "Exercise: Strength Training Calories Per Minute: 7\n"
				+ "}";
		String actual = trackerTest.getExercises();
		assertEquals(expected, actual);
	}

	@Test
	void testLogAndCalcExercise() {
		// test running
		ExerciseTracker trackerTest = new ExerciseTracker();
		// Log an exercise and verify calories burned
		String actual = trackerTest.logAndCalcExercise("Running", 30);
		assertEquals("Exercise: Running Minutes: 30 Calories Burned: 300", actual);

		// test biking
		String actual2 = trackerTest.logAndCalcExercise("biking", 45);
		assertEquals("Exercise: biking Minutes: 45 Calories Burned: 315", actual2);

		// test swimming
		String actual3 = trackerTest.logAndCalcExercise("SWIMMING", 23);
		assertEquals("Exercise: SWIMMING Minutes: 23 Calories Burned: 184", actual3);

		// test walking
		String actual4 = trackerTest.logAndCalcExercise("Walking", 67);
		assertEquals("Exercise: Walking Minutes: 67 Calories Burned: 268", actual4);

		// test strength training
		String actual5 = trackerTest.logAndCalcExercise("Strength training", 15);
		assertEquals("Exercise: Strength training Minutes: 15 Calories Burned: 105", actual5);
	}

	@Test
	void testDeleteExercises() throws QueueEmptyException {
		ExerciseTracker trackerTest = new ExerciseTracker();
		trackerTest.logAndCalcExercise("swimming", 46);
		trackerTest.logAndCalcExercise("walking", 24);
		trackerTest.logAndCalcExercise("running", 10);
		trackerTest.deleteExercise();
		String actual = trackerTest.printAllExercises();
		// expected result after swimming is removed
		String expected = "Exercise: walking, Minutes: 24, Calories Burned: 96\nExercise: running, Minutes: 10, Calories Burned: 100\n";
		assertEquals(expected,actual);
		
		// remove walking
		trackerTest.deleteExercise();
		actual = trackerTest.printAllExercises();
		expected = "Exercise: running, Minutes: 10, Calories Burned: 100\n";
		assertEquals(expected,actual);
		
		// remove running
		trackerTest.deleteExercise();
		actual = trackerTest.printAllExercises();
		expected = "";
		assertEquals(expected,actual);
		
		// throws exception if try to delete from no exercises logged
		assertThrows(QueueEmptyException.class, () -> trackerTest.deleteExercise());
		
	}

	@Test
	void testPrintAllExercises() {
		ExerciseTracker trackerTest = new ExerciseTracker();
		trackerTest.logAndCalcExercise("swimming", 46);
		String actual = trackerTest.printAllExercises();
		String expected = "Exercise: swimming, Minutes: 46, Calories Burned: 368\n";
		assertEquals(expected,actual);
		
		trackerTest.logAndCalcExercise("walking", 15);
		actual = trackerTest.printAllExercises();
		expected = "Exercise: swimming, Minutes: 46, Calories Burned: 368\nExercise: walking, Minutes: 15, Calories Burned: 60\n";
		assertEquals(expected,actual);
		
		// remove all and test print empty
		trackerTest.deleteExercise();
		trackerTest.deleteExercise();
		actual = trackerTest.printAllExercises();
		expected = "";
		assertEquals(expected,actual);
	}

	@Test
	void testGetCaloriesPerMin() {
		ExerciseTracker trackerTest = new ExerciseTracker();
		int actual;
		int expected;
		
		// test not provided exercise
		actual = trackerTest.getCaloriesPerMin("yoga");
		expected = 0;
		assertEquals(expected,actual);
		
		// test running
		actual = trackerTest.getCaloriesPerMin("Running");
		expected = 10;
		assertEquals(expected,actual);
		
		// test biking
		actual = trackerTest.getCaloriesPerMin("BIKING");
		expected = 7;
		assertEquals(expected,actual);
		
		// test swimming
		actual = trackerTest.getCaloriesPerMin("SwiMMING");
		expected = 8;
		assertEquals(expected,actual);
		
		// test walking
		actual = trackerTest.getCaloriesPerMin("walking");
		expected = 4;
		assertEquals(expected,actual);
		
		// test strength training
		actual = trackerTest.getCaloriesPerMin("STRENGTH training");
		expected = 7;
		assertEquals(expected,actual);
		
	}

}
