package game;

public abstract class Event {
    
	protected GameInfo ginfo;
	protected GraphicsEngine gengine;
	protected Computer com ; 
	
    public Event(GameInfo ginfo , GraphicsEngine gengine , Computer com){
    	this.ginfo = ginfo;
    	this.gengine = gengine;
    	this.com = com;
    }
	
	public abstract void apply(GameObject origin,GameObject target);
    
	protected void Event_Wait(){
		//synchronized (ginfo){	
	    	try {
	    		ginfo.wait();
	    	} catch (InterruptedException e) {
	    		e.printStackTrace();
	    	}
	    //}
	}
	
	protected void Event_Sleep(int mini_sec){
		try {
			Thread.sleep(mini_sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
