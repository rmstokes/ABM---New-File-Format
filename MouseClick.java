

/*
 * Mouse clicks will have timestamp
 * Later clicks may have x,y but that is not in data stream as of right now.
 * 
 * 
 */



public class MouseClick extends UserEvent {
	
	//instance variables
	private double x;
	private double y;
	
	
	//constructor
	public MouseClick(){
		super();
	}
	
	public MouseClick(double timestamp){
		setTimeStamp(timestamp);
	}

}
