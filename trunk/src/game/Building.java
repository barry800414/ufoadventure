package game;

public class Building extends Land{
    
    //最高層數
    protected int MAX_FLOOR ;
    //過路費
    protected int[] tolls ;
    
    public Building(String name,String explanation,Player owner,
    		        int price,Event event,int max_floor,int[] tolls){
    	super(name,explanation,owner,price,event);
    	this.MAX_FLOOR = max_floor;
    	this.tolls = new int[MAX_FLOOR];
    	for(int i=0;i<MAX_FLOOR;i++){
    		this.tolls[i] = tolls[i];
    	}
    }
    
    public void land_trigger(GameInfo ginfo,GraphicsEngine gengine,Player p){
    	((BuildingEvent)event).apply(ginfo,gengine,p);
    }
    
}
