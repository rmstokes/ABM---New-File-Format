
/*
 * 
 * Keypress events consist of only a timestamp
 * 
 * 
 */

public class KeyPress extends UserEvent {
	
	//instance variables
	
	//constructor
	public KeyPress(){
		super();
	}
	
	public KeyPress(double timestamp){
		setTimeStamp(timestamp);
	}

}
