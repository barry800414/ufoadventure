package game;

import java.awt.Point;
import java.awt.Rectangle;

public class Building extends Land{
    
    //最高層數
    public static final int MAX_FLOOR = 5;
    private int floor;
    private int[] toll_rate;  //toll rate
    private Event event;
    
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
    
    public int getToll(){
    	return getLandPrice() * toll_rate[floor] / 100;
    }
     
    public Building(String name,Player owner,int price,Point map_coor,Rectangle pic_coor,String[] filename){
    	super(name,owner,price,map_coor,pic_coor,filename);
    	toll_rate = new int[MAX_FLOOR + 1];
    	int tmp = 1;
    	for(int i=0;i<toll_rate.length;i++){
    	    for(int j=0;j<i/2;j++)
    	    	tmp = tmp * 10;
    	    toll_rate[i] = (2 + i % 2 * 3) * tmp;
    	}
    }
    public void land_trigger(GameObject origin,GameObject target){
    	event.apply(origin,target);
    }

    
}
