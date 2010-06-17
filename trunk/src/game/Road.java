package game;

import java.awt.Rectangle;
import java.awt.Point;

public class Road extends GameObject{
    
    private Event event;
    private Land land;
    private String name;
    
    public Road(String name ,Point map_coor,Rectangle pic_coor){
    	super(null,map_coor,pic_coor);
    	this.name = name;
    	System.out.println(" " + name);
    	//this.event = event ;
    	//this.land = land ;
    }
    
    public String getName(){
    	return name;    
    }
    
    public Land getLand(){
    	return land;
    }
    
    public Event getEvent(){
    	return event;
    }
    
    /*
    public void road_trigger(GameInfo ginfo,GraphicsEngine gengine,Player p,int rest_steps) {
    	(RoadEvent)event.apply(ginfo,gengine,p,rest_steps);	
    }
    */
    
    
}
