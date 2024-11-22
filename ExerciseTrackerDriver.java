/** This is the driver that displays the gui
 * @author Hannah Evans
 * @version 1.0
 * @since 1.0
*/
import javax.swing.JFrame;

import gui.ExerciseTrackerGUI;

public class ExerciseTrackerDriver {
	public static void main(String[] args) {
		// Run the GUI and display it
		ExerciseTrackerGUI frame = new ExerciseTrackerGUI();
		frame.setTitle("Exercise Tracker");
		frame.setSize(480, 400);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
