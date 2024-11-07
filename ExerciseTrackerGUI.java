package gui;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.ExerciseTracker;

public class ExerciseTrackerGUI extends JFrame {
	private ExerciseTracker exerciseTracker;
	
	
	public ExerciseTrackerGUI()  {
		// create exercise tracker to store the queue and list of exercises
		exerciseTracker = new ExerciseTracker();
		
		// screen set up for GUI -- title, size (is not resizeable), close operation
		 setTitle("Exercise Tracker");
	     setSize(400, 350);
	     setResizable(true);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setLayout(new BorderLayout());
	    
	     
	     
	     // Panel for exercises dropdown
	        JPanel exercisePanel = new JPanel();
	        exercisePanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Using FlowLayout for left-alignment
	        JComboBox<String> exerciseDropdown = new JComboBox<>(exerciseTracker.getExercisesList());
	        exercisePanel.add(new JLabel("Exercise:"));
	        exercisePanel.add(exerciseDropdown);

	        // Panel for minutes input
	        JPanel minutesPanel = new JPanel();
	        minutesPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // FlowLayout for left alignment
	        JTextField minutesInput = new JTextField(10);
	        minutesPanel.add(new JLabel("Minutes:"));
	        minutesPanel.add(minutesInput);

	        // Panel for buttons (Add and Delete)
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align buttons to the left
	        JButton addButton = new JButton("Add Exercise");
	        JButton deleteButton = new JButton("Delete Exercise");
	        buttonPanel.add(addButton);
	        buttonPanel.add(deleteButton);
	        
	        // Panel for textarea to display tracked exercises
	        JPanel exerciseDisplayPanel = new JPanel();
	        exerciseDisplayPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align buttons to the left
	        JTextArea exerciseLogArea = new JTextArea(10, 30);
	        exerciseDisplayPanel.add(exerciseLogArea);
	       
	        

	        // Main panel to hold all sections (north region in BorderLayout)
	        JPanel inputPanel = new JPanel();
	        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS)); // Arrange components vertically
	        inputPanel.add(exercisePanel);
	        inputPanel.add(minutesPanel);
	        inputPanel.add(buttonPanel);
	        inputPanel.add(exerciseDisplayPanel);
	        // creates empty border around edges to look like padding
	        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

	        // Add input panel to the top of the frame
	        add(inputPanel, BorderLayout.NORTH);

	        setVisible(true);
	}
	public static void main(String[] args) {
		new ExerciseTrackerGUI();

	}

}
