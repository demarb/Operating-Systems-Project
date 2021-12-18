//import java.util.LinkedList;

public class List {
//	LinkedList linklist = new LinkedList();
	
	protected Process head;
    protected int size;
	
	List(){
		head = null;
		size = 0;
	}

	/**
	 * @return the head
	 */
	public Process getHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(Process head) {
		this.head = head;
	}
	
	public boolean isEmpty() {
        return this.getHead() == null;
    }

    public boolean isFull() {
        Process process = new Process();
        return process == null;
//    	boolean test = false;
//    	if (size>=5){
//    		test = true;
//    	}
//    	return test;
    }
    
    public void insert(Process process) {
        //insert process at back
        if (this.isFull()) {
            throw new RuntimeException("Cannot add process to active process.");
        }

        Process temp = this.getHead();
        process.setNext(null); 
        this.size++;
        if (temp == null) {
            head = process;
            return;
        }

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(process);
    }
    
    public Process searchProcess(int PID) {
        Process temp = getHead();

        if(isEmpty()){
            throw new RuntimeException("Cannot search an empty list of active processes");
        }

        while(temp != null){
            if(temp.getPID() == (PID)){
                System.out.println("Process with PID "+ temp.getPID() +" successfully located.");
            	return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }
    
    
    public void remove(Process key){

        if (this.isEmpty()) {
            throw new RuntimeException("Cannot remove from an empty list");
        }

        Process temp = this.getHead();
        this.size--;

        if (temp == key) {
            head = head.getNext();
            key.setNext(null);//explain why
            return;
        }

        while(temp != null){
            if(temp.getNext() == key) {
                temp.setNext(temp.getNext().getNext());
                key.setNext(null);
                return;
            }
            temp = temp.getNext();
        }
    }
    
    public int count(){ 
    	return this.size; 
    }
    
    
    //Shows all items in list
    public void show() {
        if (isEmpty()) {
            System.out.println("[Empty!]");
            return;
        }

        Process temp = this.getHead();
        while (temp!= null) {
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
    }
    
    
    @Override
    public String toString() {
        Process temp = this.getHead();
        String result = "";
        while (temp!= null) {
            result = temp.toString() + "\n";
            temp = temp.getNext();
        }
        return result;
    }
    
    
}
