package game;

import java.awt.Point;
import java.awt.Rectangle;

public class SpecialLocation extends Land{
    
	public SpecialLocation(String name,Player owner,int land_price,Point map_coor,Rectangle pic_coor,String[] filename){
		super(name,owner,land_price,map_coor,pic_coor,filename);
	}
	
	public void land_trigger(GameObject origin , GameObject target){
		
	}
    
}
