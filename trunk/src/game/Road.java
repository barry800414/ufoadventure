package game;

import java.awt.Rectangle;
import java.awt.Point;

public class Road extends GameObject{
    
    private Event event;
    private Land land;
    private String name;
    private boolean[] state;
    private int button_index;
    
    public Road(int index,String name ,Land land,Point map_coor,Rectangle pic_coor,String[] filename){
    	super(map_coor,pic_coor,filename);
    	this.button_index = index;
    	this.name = name;
    	this.land = land;
    	System.out.println(" " + name);
    	//this.event = event ;
    	this.land = land ;
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
    
    public int get_Button_Index(){
    	return button_index;
    }
    
    public void road_trigger(Computer com,GameInfo ginfo,GraphicsEngine gengine,Player p,int rest_steps) {
    	//(RoadEvent)event.apply(ginfo,gengine,p,rest_steps);	
    }
    
    
    
}
