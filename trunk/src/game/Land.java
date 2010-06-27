package game;

import java.awt.Point;
import java.awt.Rectangle;

public abstract class Land extends GameObject {
    
    
    private String name;  //名字
    private Player owner;  //擁有者
    private int land_price;  //價格
    private String filename;
    private int button_index;
    //private String info; //說明()
    //protected int ID;  //編號
    protected Event event;
    
    //TODO : add event to constructor
    public Land(int index,String name,Player owner,int land_price,Point map_coor,Rectangle pic_coor,String[] filename){
    	super(map_coor,pic_coor,filename);
    	this.button_index = index;
    	this.name = name ;
    	this.owner = owner ;
    	this.land_price = land_price ; 
    	//this.event = event ;
    }
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
    
    public void setEvent(Event event){
    	this.event = event;
    }
    public int get_Button_Index(){
    	return button_index;
    }
    
    
    public abstract void land_trigger(GameObject origin, GameObject target);
}
