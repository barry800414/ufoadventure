package game;

import java.awt.Point;
import java.awt.Rectangle;

public abstract class Land extends GameObject {
    
    
    private String name;  //名字
    private Player owner;  //擁有者
    private int price;  //價格
    private String explanation; //說明()
    //protected int ID;  //編號
    private Event event;
    
    public Land(String name,String explanation,Player owner,int price,Event event,String filename,Point map_coor,Rectangle pic_coor){
    	super(filename,map_coor,pic_coor);
    	this.name = name ;
    	this.explanation = explanation ;
    	this.owner = owner ;
    	this.price = price ; 
    	this.event = event ;
    }
    
    public abstract void land_trigger(GraphicsEngine gengine,Player p);

    public String getName(){
    	return name;
    }
    public Player getOwner(){
    	return owner;
    }
    public int 
    
}
