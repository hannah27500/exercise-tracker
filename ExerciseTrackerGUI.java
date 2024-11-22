/** This is a GUI that is for an exercise tracker
 * @author Hannah Evans
 * @version 1.0
 * @since 1.0
*/
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.ExerciseTracker;

public class ExerciseTrackerGUI extends JFrame {
	protected ExerciseTracker exerciseTracker;
	protected JComboBox<String> exerciseDropdown;
	private JPanel minutesPanel;
	private JTextField minutesInput;
	private JPanel buttonPanel;
	private JButton addButton;
	private JButton deleteButton;
	private JButton addNewExerciseButton; 
	private JPanel exerciseDisplayPanel;
	private JPanel inputPanel;
	private JTextArea exerciseLogArea;

	// Colors Used for Color Palette
	Color lightBlue = new Color(160, 183, 211);
	Color mediumGray = new Color(169, 169, 169);
	Color navyBlue = new Color(42, 77, 105);
	Color white = new Color(240, 243, 244);
	Color slateBlue = new Color(84, 77, 105);

	public ExerciseTrackerGUI() {
		// create exercise tracker to store the queue and list of exercises
		exerciseTracker = new ExerciseTracker();


		setLayout(new BorderLayout());

		// Panel for exercises dropdown
		JPanel exercisePanel = new JPanel();
		// uses flowlayout to the left
		exercisePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		exerciseDropdown = new JComboBox<>(exerciseTracker.getExercisesList());
		exercisePanel.add(new JLabel("Exercise:"));
		exercisePanel.add(exerciseDropdown);

		// Panel for minutes input
		minutesPanel = new JPanel();
		minutesPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
		minutesInput = new JTextField(10);
		minutesPanel.add(new JLabel("Minutes:"));
		minutesPanel.add(minutesInput);

		// Panel for buttons (Add and Delete)
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(400, 65));
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		addButton = new JButton("Add Exercise");
		deleteButton = new JButton("Delete Exercise");
		addNewExerciseButton = new JButton("Add New Exercise"); 

		// Add action listener to buttons and add to panel
		AddExerciseListener addl = new AddExerciseListener();
		addButton.addActionListener(addl);
		DeleteExerciseListener deletel = new DeleteExerciseListener();
		deleteButton.addActionListener(deletel);
		AddNewExerciseListener addel = new AddNewExerciseListener();
		addNewExerciseButton.addActionListener(addel); 
		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(addNewExerciseButton);

		// Panel for textarea to display tracked exercises
		exerciseDisplayPanel = new JPanel();
		exerciseDisplayPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
		exerciseLogArea = new JTextArea(10, 35);
		exerciseLogArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(exerciseLogArea); // allow to scroll
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		exerciseDisplayPanel.add(scrollPane);

		// Main panel to hold all sections
		inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.add(exercisePanel);
		inputPanel.add(minutesPanel);
		inputPanel.add(buttonPanel);
		inputPanel.add(exerciseDisplayPanel);
		// creates empty border around edges to look like padding
		inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		// Add input panel to the top of the frame
		add(inputPanel, BorderLayout.NORTH);

		setVisible(true);

		// Change colors
		inputPanel.setBackground(navyBlue);
		addButton.setBackground(lightBlue);
		addButton.setForeground(white); 
		deleteButton.setBackground(mediumGray);
		deleteButton.setForeground(white);

		addNewExerciseButton.setBackground(lightBlue);
		addNewExerciseButton.setForeground(white);

		exerciseLogArea.setBackground(Color.white);
		exerciseLogArea.setForeground(slateBlue);

		
		exerciseDropdown.setBackground(white);
		exerciseDropdown.setForeground(slateBlue);

	}

	public class AddExerciseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				// gets input from dropdown and text of minutes
				String selectedExercise = (String) exerciseDropdown.getSelectedItem();
				int minutesExercised = Integer.parseInt(minutesInput.getText());
				// adds workout to queue
				exerciseTracker.logAndCalcExercise(selectedExercise, minutesExercised);
				// reset minutes input to blank
				minutesInput.setText("");

				// displays exercises to screen with new added
				String exercisesDisplayed = exerciseTracker.printAllExercises();
				exerciseLogArea.setText(exercisesDisplayed);
			} catch (NumberFormatException ex) {
				// if not a number added displays error
				JOptionPane.showMessageDialog(ExerciseTrackerGUI.this, "Please enter a valid number for minutes.",
						"Input Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public class DeleteExerciseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// deletes first from queue
				exerciseTracker.deleteExercise();
				// redisplays items on screen with first deleted
				String exercisesDisplayed = exerciseTracker.printAllExercises();
				exerciseLogArea.setText(exercisesDisplayed);
			} catch (Exception ex) {
				// if no exercises are left displays pop up
				JOptionPane.showMessageDialog(ExerciseTrackerGUI.this, "There are no tracked exercises to delete",
						"Input Error", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	public class AddNewExerciseListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Allow input for exercise adn calories burned
			String exerciseName = JOptionPane.showInputDialog("Enter exercise name:");
			String caloriesText = JOptionPane.showInputDialog("Enter calories burned per minute:");

			// if fill in both then can continue
			if (exerciseName != null && !exerciseName.trim().isEmpty() && caloriesText != null
					&& !caloriesText.trim().isEmpty()) {
				try {
					int calories = Integer.parseInt(caloriesText);
					// take exercise name and capitalize first letter and rest lowercase to match rest of the list
					String exerciseNameCap = exerciseName.substring(0, 1).toUpperCase() + exerciseName.substring(1).toLowerCase();
					// Add new exercise to the linked list
					exerciseTracker.exercises.insertLast(exerciseNameCap, calories);

					// Update the dropdown list
					exerciseDropdown.setModel(new DefaultComboBoxModel<>(exerciseTracker.getExercisesList()));

					JOptionPane.showMessageDialog(ExerciseTrackerGUI.this, "Exercise added successfully.");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(ExerciseTrackerGUI.this, "Please enter a valid number for calories.",
							"Input Error", JOptionPane.ERROR_MESSAGE);
				}
				// if both not filled in displays an error
			} else {
				JOptionPane.showMessageDialog(ExerciseTrackerGUI.this, "Please provide both fields.", "Input Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}


}
