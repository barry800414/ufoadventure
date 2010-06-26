package game;

import java.awt.Point;
import java.awt.Rectangle;

public class Lab extends Land{
    
    public static int MAX_FLOOR = 2;
    //層數
    private int floor;
    //研究
    private Item research;
    

    public int getFloor(){
	return floor;
    }
    

    public boolean setFloor(int f){
	if(f <= MAX_FLOOR){
	    this.floor++;
	    return true;
	}
	else return false;
    }
    
    public Item getResearch(){
	return research;
    }
    //TODO add research item , event to constructor
    public Lab(String name,Player owner,int price,Item item,Point map_coor,Rectangle pic_coor,String[] filename){
    	super(name,owner,price,map_coor,pic_coor,filename);
    	this.research = item ;
    	/*this.tolls = new int[MAX_FLOOR];
    	for(int i=0;i<MAX_FLOOR;i++){
    		this.tolls[i] = tolls[i];
    	}*/
    }
    public void land_trigger(GameInfo ginfo,GraphicsEngine gengine,Player p){
    	//((labEvent)event).apply(ginfo,gengine,p);
    }
    
}
