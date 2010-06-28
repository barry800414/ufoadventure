package game;

import java.awt.Point;
import java.awt.Rectangle;

public class Building extends Land{
    
    //最高層數
    public static final int MAX_FLOOR = 5;
    private int floor = 0;
    private int[] toll_rate;  //toll rate
    
    public int getFloor(){
    	return floor;
    }
    public boolean setFloor(int f){
    	if(f <= MAX_FLOOR){
    		this.floor++;
    		return true;
    	}
    	else 
    		return false;
    }
    
    public int getToll(){
    	return getLandPrice() * toll_rate[floor] / 100;
    }
     
    public Building(int index,String name,Player owner,int price,Point map_coor,Rectangle pic_coor,String[] filename){
    	super(index,name,owner,price,map_coor,pic_coor,filename);
    	toll_rate = new int[MAX_FLOOR + 1];
    	for(int i=0;i<toll_rate.length;i++){
    	    toll_rate[i] = 10 + i*10;
    	}
    	
    }
    public void land_trigger(GameObject origin,GameObject target){
    	event.apply(origin,target);
    }

    
}
