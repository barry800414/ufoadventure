package game;

import java.awt.Point;
import java.awt.Rectangle;

public abstract class Land extends GameObject {
    
    
    private String name;  //名字
    private Player owner;  //擁有者
    private int land_price;  //價格
    private String filename;
    //private String info; //說明()
    //protected int ID;  //編號
    private Event event;
    
    //TODO : add event to constructor
    public Land(String name,Player owner,int land_price,Point map_coor,Rectangle pic_coor,String[] filename){
    	super(map_coor,pic_coor,filename);
    	this.name = name ;
    	this.owner = owner ;
    	this.land_price = land_price ; 
    	//this.event = event ;
    }
    
    public abstract void land_trigger(GameInfo ginfo, GraphicsEngine gengine,Player p);

    public String getName(){
    	return name;
    }
    public Player getOwner(){
    	return owner;
    }
    public int getLandPrice(){
    	return land_price;
    }

    public boolean setOwner(Player p){
    	if(p != null){
    	    this.owner = p;
    	    return true;
    	}
    	else return false;
    }
}
