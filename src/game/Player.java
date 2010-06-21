package game;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.*;

public class Player extends GameObject{
	
    public static int MAX_TYPE = 1;
    public static final int MAX_STATE = 20;
    
    private GameInfo ginfo;
    private int ID;
    private int cash;                                          //現金
    private int deposit;                                       //存款
    private String name;                                       //名字
    private int career;                                        //職業
    private int dice_num;                                      //骰子數
    private boolean[] state = new boolean[MAX_STATE];          //狀態
    private int location;                                      //位置
    private int point;                                         //點數
    private int property;                                      //總財產
    private ArrayList<Item> item = new ArrayList<Item>(0);     //道具
    private ArrayList<Land> house = new ArrayList<Land>(0);    //房屋   to be repaired
    
    
    //to do : Item[] item  , int[] house , Career , Road start
    public Player(GameInfo ginfo,int ID,String name,int cash,int deposit,int dice_num,int point,int location,Point map_coor,Rectangle pic_coor,String[] filename){
    	super(map_coor,pic_coor,filename);
    	this.ID = ID;
    	this.location = location;
    	this.ginfo = ginfo;
    	this.cash = cash ;
    	this.deposit = deposit;
    	this.name = name ;
    	this.dice_num = dice_num;
    	this.point = point;
    	setPicCoor();
    	
    }
    public void Update(){
	
    }
    
    public int getID(){  return ID;  }
    public int getCash(){  return cash;  }
    public int getDeposit(){  return deposit;  }
    public String getName(){  return name;     }
    public int getCareer(){   return career;   }
    public int getDicenum(){  return dice_num; }
    public boolean[] getState(){  return state;    }
    public int getLocation(){  return location;  }
    public int getPoint() {   return point;  }
    public int getProperty() { return property;  }
    public Land[] getHouseList(){
    	Land[] houselist = new Land[0];
    	return house.toArray(houselist);
    }
    public Item[] getItemList(){
    	Item[] itemlist = new Item[0];
    	return item.toArray(itemlist);
    }
    
    public void setCash(int cash){
    	if(cash < 0)
    		setDeposit(this.deposit - cash);
    	else
    		this.cash = cash;
    }
    public void setDeposit(int deposit){
    	this.deposit = deposit >= 0 ? deposit : 0;
    }
    
    public void setName(String name){
    	if(name != null)
    		this.name = name;
    }
    public boolean setCareer(int career){
    	if(career >=2 || career <=6){
    		if(this.career ==1){
    			this.career = career;
    			return true;
    		}
    		else 
    			return false;
    	}
    	else if(career == 1){
    		if(this.career == 0){
    			this.career = career ;
    			return true;
    		}
    		else
    			return false;
    	}
    	else 
    		return false;
    }
    public void setDicenum(int dice_num){
    	if(dice_num <= 4 && dice_num >0)
    		this.dice_num = dice_num;
    }
    public void setState(int index ,boolean open){
    	if(index >=0 && index < MAX_STATE){
    		this.state[index] = open;
    	}
    }
    public void setLocation(int location){
    	if(location >= GameInfo.MAX_ROAD)
    		this.location = location % GameInfo.MAX_ROAD;
    	else if(location < 0){
    		this.location = (((((-1)*location)/GameInfo.MAX_ROAD)+1)*GameInfo.MAX_ROAD + location)%GameInfo.MAX_ROAD ;
    	}
    	else
    		this.location = location;
    	
    	setPicCoor();
    }
    
    public void setPoint(int point){
    	if(point <= 9999 && point >= 0)
    		this.point = point;
    }
    
    public void setPicCoor(){
    	Rectangle road = ginfo.roadlist[location].getPicCoor();
    	int x = road.x;
    	int y = road.y + road.height / 2  -  getPicCoor().height ;
    	this.setPicCoor(x , y , getPicCoor().width, getPicCoor().height);
    	System.out.println( y + " mmmmmmm  " +  road.y );
    }
    
    // TODO : calc the building value etc.. 
    public void calcProperty(){
    	this.property = this.cash + this.deposit;
    }
    
    public void addHouse(Land house){
    	this.house.add(house);
    }
    public void addItem(Item item){
    	this.item.add(item);
    }
    public void removeHouse(Land house){
    	this.house.remove(house);
    }
    public void removeItem(Item item){
    	this.item.remove(item);
    }
    /*
     * 0 定時炸彈
     */
	   
}
