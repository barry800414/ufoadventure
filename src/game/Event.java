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
    
}
