package game;

import java.awt.Point;
import java.awt.Rectangle;

public abstract class SpecialLocation extends Land{
    
	public SpecialLocation(String name,Player owner,int land_price,String filename,Point map_coor,Rectangle pic_coor){
		super(name,owner,land_price,filename,map_coor,pic_coor);
	}
	
    //protected abstract boolean condition();
    
}
