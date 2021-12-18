
public class ResourceInteger {
	private int key;
	private int value;
	private boolean isLocked;


	public ResourceInteger(int key, int value) {
		
		this.key = key;
		this.value = value;
		this.isLocked = false;
	}
      public ResourceInteger() {
		
		//this.key = key;
		//this.value = value;
		this.isLocked = false;
	}


	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}


	/**
	 * @param key the key to set
	 */
	public void setKey(int key) {
		this.key = key;
	}


	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	
	
	/**
	 * @return the isLocked
	 */
	public boolean isLocked() {
		return isLocked;
	}


	/**
	 * @param isLocked the isLocked to set
	 */
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}


	@Override
    public String toString() {
        return "\nInteger Info: \nKey: " + getKey() + "\nValue: " + getValue() + "\nisLocked: " + isLocked() + "\n";
    }

	
	
}
