package game;

import java.awt.Point;
import java.awt.Rectangle;

public class Lab extends Land{
    
    public static int MAX_FLOOR = 2;
    //層數
    protected int floor;
    //研究
    protected Item research;
    
    //TODO add research item , event to constructor
    public Lab(String name,Player owner,int price,Item item,Point map_coor,Rectangle pic_coor,String[] filename){
    	super(name,owner,price,map_coor,pic_coor,filename);
    	this.research = item ;
    	/*this.tolls = new int[MAX_FLOOR];
    	for(int i=0;i<MAX_FLOOR;i++){
    		this.tolls[i] = tolls[i];
    	}*/
    }
}
