import java.time.LocalTime;
import java.util.*;

/**
 * 
 */

/**
 * @author Demar Brown
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Variable Declarations
		Scanner readUser = new Scanner(System.in);
		int numProcesses = 0;
		int startingPos = 0;
		ArrayList<ResourceInteger> sharedIntegers = new ArrayList<>();
		
		
		//Initialize shared list of integers as random numbers not exceeding 20
		for (int i=0; i<10; i++) {
			sharedIntegers.add(new ResourceInteger(i, new Random().nextInt(20)));
//			System.out.println("\nInteger: " +sharedIntegers.get(i));
		}
		
		//Welcome screen
		System.out.println("\t\tWELCOME!!!\nThis program simulates processes being scheduled. ");
		
		//Accept #of processes and validated
		do {
			System.out.println("\nEnter number of processes to be simulated: \nMinimum: 10 Processes; Maximum: 30 Processes;");
			numProcesses = readUser.nextInt();
		} while (numProcesses<10 || numProcesses>30);
		
		do {
			System.out.println("\nEnter starting position  in the list of integers for simulation");
			startingPos = readUser.nextInt();
		} while (startingPos<0 || startingPos>9);		
		
		//Create processes based on user input and add them to list
		List JobList = new List();
		for  (int i=0; i<numProcesses; i++) {
			JobList.insert(new Process());
		}
		
		//Save joblistPIDs in array for search later
		ArrayList<Integer> JobListPIDs = new ArrayList<Integer>();

		Process temp = JobList.getHead();
		int i =0;
        while(temp != null){
//        	JobListPIDs[i] = temp.getPID();
        	JobListPIDs.add(temp.getPID());
            temp = temp.getNext();
            i++;
        }
        
        System.out.println("|----------------------------------|");
        System.out.println("|GENERATING ACCESS SEQUENCE REPORT |");
        System.out.println("|----------------------------------|\n");
        System.out.println(numProcesses+" have been successfully added to your JobList for Simulation. \n See PIDs generated below");
        System.out.println(JobListPIDs.toString()+"\n");
      
       int count=0;
		//Create ActiveProcesses Data Structure with only 5 processes based on FCFS
		Queue<Process> ActiveProcesses = new LinkedList<>();
		do {
			while (ActiveProcesses.size()<5) {
				System.out.println(" Space available in Active Processes. Adding more records based on FCFS.");
				ActiveProcesses.add(JobList.searchProcess(JobListPIDs.get(0)));
				JobListPIDs.remove(0);
				count++;
				if(count==numProcesses){
					break;
				}
			}
	
			int task;
			
			//test
			for(Process r: ActiveProcesses) {
				task=r.getTask();
				System.out.println("Process "+ r.getPID()+ " with task "+ task + " is attempting to access shared resources.\n");
				
				switch(task) {
					case 0:{
						System.out.println("Process "+ r.getPID()+ " is attempting to add.");

						int index1= new Random().nextInt(10);
						int index2= new Random().nextInt(10);
						
						if (sharedIntegers.get(index1).isLocked() || sharedIntegers.get(index2).isLocked()) {
							r.setAttempts(r.getAttempts()+1);
							if (r.getPriority()>1) {
								r.setPriority(r.getPriority()-1);
							}
							System.out.println("Process "+ r.getPID()+ " failed to complete adding.");
							
						}else {
							sharedIntegers.get(index1).setLocked(true);
							sharedIntegers.get(index2).setLocked(true);
												
							int sum= sharedIntegers.get(index1).getValue()+sharedIntegers.get(index2).getValue();
							System.out.println("Adding: "+sharedIntegers.get(index1).getValue()+" to: "+ sharedIntegers.get(index2).getValue() +" is: "+sum);
							//Create a temp integer to store second index ResourceInteger, change its value, then update the original sharedInteger
							ResourceInteger tempInt = sharedIntegers.get(index2);
							tempInt.setValue(sum);
							sharedIntegers.set(index2, tempInt);
							
							r.setEndTime(LocalTime.now());														
							sharedIntegers.get(index1).setLocked(false);
							sharedIntegers.get(index1).setLocked(false);
							System.out.println("Process "+ r.getPID()+ " successfully completed adding.");
						}
						break;
					}
					case 1:{
						System.out.println("Process "+ r.getPID()+ " is attempting to copy.");
						int copiedValue, originalValue, firstIndex, secondIndex;
						firstIndex = new Random().nextInt(10); //Index of first location
						secondIndex = new Random().nextInt(10); //Index of second location
						
						if (sharedIntegers.get(firstIndex).isLocked() || sharedIntegers.get(secondIndex).isLocked()) {
							r.setAttempts(r.getAttempts()+1);
							if (r.getPriority()>1) {
								r.setPriority(r.getPriority()-1);
							}
							System.out.println("Process "+ r.getPID()+ " failed to complete copying. System resources released.");
						}else {
							sharedIntegers.get(firstIndex).setLocked(true);
							sharedIntegers.get(secondIndex).setLocked(true);
							
							copiedValue=sharedIntegers.get(firstIndex).getValue(); //Value copied from first location
							originalValue=sharedIntegers.get(secondIndex).getValue(); //Original value at second location
							System.out.println("Replacing "+originalValue+ " at index "+ secondIndex+ " with "+copiedValue + " from index "+ firstIndex);
							//Create a temp integer to store second index ResourceInteger, change its value, then update the original sharedInteger
							ResourceInteger tempInt = sharedIntegers.get(secondIndex);
							tempInt.setValue(copiedValue);
							sharedIntegers.set(secondIndex, tempInt);
							
							r.setEndTime(LocalTime.now());	
							sharedIntegers.get(firstIndex).setLocked(false);
							sharedIntegers.get(secondIndex).setLocked(false);
							System.out.println("Process "+ r.getPID()+ " successfully copied. System resources released.");
						}
						break;
					}
					case 2:{
						System.out.println("Process "+ r.getPID()+ " is attempting to display.");
						int index = new Random().nextInt(10);
						
						if (sharedIntegers.get(index).isLocked()) {
							r.setAttempts(r.getAttempts()+1);
							if (r.getPriority()>1) {
								r.setPriority(r.getPriority()-1);
							}
							System.out.println("Process "+ r.getPID()+ " failed to complete display.");
						}else {
							sharedIntegers.get(index).setLocked(true);
							
							System.out.println("Displaying Record(" +index+ ") from Shared List:");
							System.out.println(sharedIntegers.get(index));
							
							r.setEndTime(LocalTime.now());	
							sharedIntegers.get(index).setLocked(false);
							System.out.println("Process "+ r.getPID()+ " successfully displayed. System resources released.");
						}
						break;
					}
				}//end switch
				
			}
			ActiveProcesses.clear();
		}while(count<numProcesses);
		
		System.out.println("You have no more process from JobLists to Process. JobList Empty: "+ JobListPIDs.toString());
		
		System.out.println("\n ACCESS SEQUENCE REPORT COMPLETE");
		//END Report 1 - Access Sequence Report
		
        System.out.println("|----------------------------------|");
        System.out.println("|GENERATING PROCESS DETAILS REPORT |");
        System.out.println("|----------------------------------|\n");
		

        System.out.println("|----------------------------------------|\n");
    	System.out.println("PID  |Task| StartTime          | End Time      | Attempts");
    	Process temp2 = JobList.getHead();

        while (temp2!= null) {
        	System.out.println(temp2.getPID() +" | "+ temp2.getTask()+ "  | " + temp2.getStartTime() +" | " + temp2.getEndTime()+ "  | " + temp2.getAttempts());
        	temp2 = temp2.getNext();
        }

    	
//        JobList.show();
		
		

		//Close Scanner
		readUser.close();
		
	}

}
