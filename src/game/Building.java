package game;

import java.awt.Point;
import java.awt.Rectangle;

public class Building extends Land{
    
    //最高層數
    public static final int MAX_FLOOR = 5;
    private int floor;
    
    
     
    public Building(String name,Player owner,int price,String filename,Point map_coor,Rectangle pic_coor){
    	super(name,owner,price,filename,map_coor,pic_coor);
    	
    }
    
    /*
    public void land_trigger(GameInfo ginfo,GraphicsEngine gengine,Player p){
    	((BuildingEvent)event).apply(ginfo,gengine,p);
    }*/
    
}
