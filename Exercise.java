package model;

public class Exercise {
	private String exerciseName;
	private int caloriesBurnedPerMinute;
	
	public Exercise() {
		this.exerciseName = "";
		this.caloriesBurnedPerMinute =0;
	}
	
	public Exercise(String exerciseName, int caloriesBurnedPerMinute) {
		this.exerciseName = exerciseName;
		this.caloriesBurnedPerMinute = caloriesBurnedPerMinute;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public int getCaloriesBurnedPerMinute() {
		return caloriesBurnedPerMinute;
	}

	public void setCaloriesBurnedPerMinute(int caloriesBurnedPerMinute) {
		this.caloriesBurnedPerMinute = caloriesBurnedPerMinute;
	}
	
	
	

}
