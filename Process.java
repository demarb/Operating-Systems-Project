import java.time.LocalTime;
import java.util.Random;

public class Process {

	private int PID;
	private int task; //O for Add, 1 for Copy, 2 for Display
	private int priority; 
	private int[] data;
	private LocalTime startTime;
	private LocalTime endTime;
	private int attempts;
	private Process next;
	
	//Constructors
	public Process() {
		PID = new Random().nextInt(10000);
		task = new Random().nextInt(3);
		priority = task + 1;
		data = null;
		startTime = LocalTime.now();
		endTime = null;
		attempts = 0;
		next = null;
	}
	
	//Getters and setters
	
	/**
	 * @return the pID
	 */
	public int getPID() {
		return PID;
	}


	/**
	 * @param pID the pID to set
	 */
	public void setPID(int pID) {
		PID = pID;
	}


	/**
	 * @return the task
	 */
	public int getTask() {
		return task;
	}


	/**
	 * @param task the task to set
	 */
	public void setTask(int task) {
		this.task = task;
	}

	

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}


	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}


	/**
	 * @return the data
	 */
	public int[] getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(int[] data) {
		this.data = data;
	}


	/**
	 * @return the startTime
	 */
	public LocalTime getStartTime() {
		return startTime;
	}


	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}


	/**
	 * @return the endTime
	 */
	public LocalTime getEndTime() {
		return endTime;
	}


	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}


	/**
	 * @return the attempts
	 */
	public int getAttempts() {
		return attempts;
	}


	/**
	 * @param attempts the attempts to set
	 */
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}


	/**
	 * @return the next
	 */
	public Process getNext() {
		return next;
	}


	/**
	 * @param next the next to set
	 */
	public void setNext(Process next) {
		this.next = next;
	}


	@Override
    public String toString() {
        return "\nProcess Info: \nPID: " + getPID() + "\nTask: " + getTask() +"\nPriority: " + getPriority() + "\nData: " + getData() + "\nStartTime: " + getStartTime() + "\tEndTime: " + getEndTime() + "\nAttempts: " + getAttempts();
    }

	
	
	
}
