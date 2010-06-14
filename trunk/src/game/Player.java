package game;

import java.util.*;

public class Player extends GameObject{
	//現金
    protected int cash;
    //存款
    protected int deposit;
    //道具
    protected ArrayList<Item> item = new ArrayList<Item>(0);
    //名字
    protected String name;
    //房屋   to be repaired
    protected ArrayList<Land> house = new ArrayList<Land>(0);
    //職業
    protected int career;
    //骰子數
    protected int dice_num;
    //狀態
    protected int[] state;
    //位置
    protected int location;
    //點數
    protected int point;
    //總財產
    protected int property;
 
    //to do : Item[] item  , int[] house , Career , Road start
    public Player(String name,int cash,int deposit,int dice_num,int point){
    	this.cash = cash ;
    	this.deposit = deposit;
    	this.name = name ;
    	this.dice_num = dice_num;
    	this.point = point;
    }
    public void Update(){
	
    }
    
    public Land[] GetHouseList(){
	Land[] houselist = new Land[0];
	return house.toArray(houselist);
    }
	   
}
