package game;

import java.awt.Point;
import java.awt.Rectangle;

public class GameObject {
	
	private Point map_coor;
	private Rectangle pic_coor;
	private String pic_filename;
	
	public GameObject(String filename,Point map_coor,Rectangle pic_coor){
		this.map_coor = new Point();
		this.pic_coor = new Rectangle();
		setMapCoor(map_coor);
		System.out.print(" " + map_coor.x + " " + map_coor.y +" ");
		setPicCoor(pic_coor);
		System.out.print(" " + pic_coor.x + " " + pic_coor.y + " " + pic_coor.height + " " + pic_coor.width + " " );
		this.pic_filename = filename;
	}
	
	public Point getMapCoor(){
		return map_coor;
	}
	public Rectangle getPicCoor(){
		return pic_coor;
	}
	public String getPicFilename(){
		return pic_filename;
	}
	
	//TODO : add the map constraint
	public void setMapCoor(int x,int y){
		this.map_coor.x = x;
		this.map_coor.y = y;
	}
	public void setMapCoor(Point d){
		this.map_coor.x = d.x;
		this.map_coor.y = d.y;
	}
	
	public void setPicCoor(Rectangle r){
		this.pic_coor.x = r.x;
		this.pic_coor.y = r.y;
		this.pic_coor.height = r.height;
		this.pic_coor.width = r.width;
	}
	public void setPicCoor(int x ,int y ,int width,int height){
		this.pic_coor.x = x ;
		this.pic_coor.y = y ;
		this.pic_coor.width = width;
		this.pic_coor.height = height;
	}
	
	
}
