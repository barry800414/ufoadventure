package game;

import java.awt.Point;
import java.awt.Rectangle;

public class Building extends Land{
    
    //最高層數
    public static final int MAX_FLOOR = 5;
    private int floor;
    private int[] rate;
    
    public int getFloor(){
	return floor;
    }
    
    public int getToll(){
	return getLandPrice() * rate[floor] / 100;
    }
     
    public Building(String name,Player owner,int price,Point map_coor,Rectangle pic_coor,String[] filename){
    	super(name,owner,price,map_coor,pic_coor,filename);
    	rate = new int[MAX_FLOOR + 1];
    	int tmp = 1;
    	for(int i=0;i<rate.length;i++){
    	    for(int j=0;j<i/2;j++)
    		tmp = tmp * 10;
    	    rate[i] = (2 + i % 2 * 3) * tmp;
    	}
    }
    
    
    public void land_trigger(GameInfo ginfo,GraphicsEngine gengine,Player p){
    	//((BuildingEvent)event).apply(ginfo,gengine,p);
    }
    
}
