package game;

import java.io.*;
import java.util.Scanner;
import java.awt.Point;
import java.awt.Rectangle;

public class GameInfo {
    
    public static final int MAX_ROAD = 90;
    public static final int MAX_PLAYER = 4;
	public static final int BUILDING = 1;
	public static final int LAB = 2;
	public static final int SPECIAL_LOCATION = 3;
    
    public int players_num;
    public int init_cash;
    public int init_deposit;
    public int init_point;
    public int gamemode;
    public int year;
    public int month;
    public int day;
    public int round;
    public Player winner;
    public int loser_num = 0;
    public int current_player;
    
    public int[][] coodinate;
    public Player[] playerlist ;
    public Item[] itemlist;
    public Road[] roadlist;
    public Event[] eventlist;
    public Land[] landlist;
    
    
    public GameInfo(){
    	round=1;
    	year=2010;
    	month=6;
    	day=10;
    	/*
    	playerlist = new Player[players_num];
    	System.out.println(players_num + "  dsadasds");
    	for(int i=0;i<players_num;i++) {
    	    playerlist[i] = new Player("Player " + (i+1),init_cash,init_deposit,1,init_point);
    	    System.out.println("player " + (i+1) + " cash :" + playerlist[i].cash + " deposit :" + playerlist[i].deposit  + " point: " + playerlist[i].point);
    	}
    	coodinate = new int[19][21];
    	*/
    }
    public void Game_Init(){
    	item_init("itemlist.txt");
    	land_init("landlist.txt");
    	road_init("roadlist.txt");
    	player_init();
    	
    }
    
    /*
    public boolean CheckMode(){
	if(gamemode==1){
	    if(loser_num < players_num - 1) return true;
	    else{
		for(int i=0;i<players_num;i++)
		    if(playerlist[i].getCash()+playerlist[i].getDeposit()>0) winner = playerlist[i];
		return false;
	    }
	}
	else if(gamemode==2){
	    int winner_num = 0;
	    for(int i=0;i<players_num;i++)
		if(playerlist[i].getHouseList().length>50){
		    winner_num++;
		    winner = playerlist[i];
		}
	    if(winner_num > 0) return false;
	    else return true;
	}
	else if(gamemode==3){
	    for(int i=0;i<players_num;i++){
		int all_money = playerlist[i].getCash() + playerlist[i].getDeposit();
		for(Land land : playerlist[i].getHouseList()) all_money = all_money + land.get;
		if(all_money>2500000) return false;
	    }
	    return true;
	}
	return false;
    }
    */
    
    private boolean item_init(String filename){
    	
    	try {
    		Scanner input = new Scanner(new FileInputStream(filename));
    		int num , point ;
    		String name , info;
    		num = input.nextInt();
    		
    		itemlist = new Item[num];
    		for(int i=0;i<num;i++){
    			name = input.next();
    			point = input.nextInt();
    			info = input.next();
    			itemlist[i] = new Item(name,point,info);
    			System.out.println(itemlist[i].name + " " + itemlist[i].point + " " + itemlist[i].info);
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    private boolean road_init(String filename){
    	try {
    		Scanner input = new Scanner(new FileInputStream(filename));
    		int num ,index ;
    		String name ;
    		Rectangle pic = new Rectangle();
    		Point coor = new Point();
    		num = input.nextInt();
    		String[] r_pic_filename = new String[2];
    		r_pic_filename[0] = "Road_button1.png";
    		r_pic_filename[1] = "Road_button2.png";
    		
    		
    		roadlist = new Road[num];
    		for(int i=0;i<num;i++){
    			name = input.next();
    			pic.x = input.nextInt();
    			pic.y = input.nextInt();
    			pic.width = input.nextInt();
    			pic.height = input.nextInt();
    			coor.x = input.nextInt();
    			coor.y = input.nextInt();
    			index = input.nextInt();
    			//System.out.println(name + " " + pic.x + " " + pic.y + " " + pic.width + " " + pic.height + " " + coor.x + " " + coor.y + " " + index);
    			roadlist[i] = new Road(name,landlist[index],coor,pic,r_pic_filename);
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    private boolean land_init(String filename){
    	try {
    		Scanner input = new Scanner(new FileInputStream(filename));
    		int num ,type ,price,item_index;
    		String name ;
    		String[] b_pic_filename = new String[6];
    		String[] l_pic_filename = new String[3];
    		String[] s_pic_filename = new String[1];
    		Rectangle pic = new Rectangle();
    		Point coor = new Point();
    		num = input.nextInt();
    		landlist = new Land[num];
    		for(int i=0;i<num;i++){
    			type = input.nextInt();
    			name = input.next();
    			pic.x = input.nextInt();
    			pic.y = input.nextInt();
    			pic.width = input.nextInt();
    			pic.height = input.nextInt();
    			coor.x = input.nextInt();
    			coor.y = input.nextInt();
    			price = input.nextInt();
    			System.out.println(name + " " + pic.x + " " + pic.y + " " + pic.width + " " + pic.height + " " + coor.x + " " + coor.y + " " + price );
    			if(type == BUILDING){
    				for(int j=0;j<b_pic_filename.length;j++)
    					b_pic_filename[j] = input.next();
    				landlist[i] = new Building(name,null,price,coor,pic,null);
    			}
    			else if(type == LAB){
    				item_index = input.nextInt();
    				for(int j=0;j<l_pic_filename.length;j++)
    					l_pic_filename[j] = input.next();
    				landlist[i] = new Lab(name,null,price,itemlist[item_index],coor,pic,null);
    			}
    			else if(type == SPECIAL_LOCATION){
    				//for(int j=0;j<s_pic_filename.length;j++)
    				//	s_pic_filename[j] = input.next();
    				landlist[i] = new SpecialLocation(name,null,price,coor,pic,null);
    			}
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
    private void player_init(){
	
	String[][] b_pic_filename = new String[3][1];
	for(int i=0;i<b_pic_filename.length;i++){
	    b_pic_filename[i][0] = "Player"+i+".png";
	}
	Point coor = new Point();
	coor.x = 13;
	coor.y = 5;
	Rectangle pic = new Rectangle();
	pic.height = 100;
	pic.width = 100;
	pic.x = 2250;
	pic.y = 1250;
	
    	playerlist = new Player[players_num];
    	for(int i=0;i<players_num;i++) {
    	    playerlist[i] = new Player(this,i,"Player " + (i+1),init_cash,init_deposit,1,init_point,0,coor,pic,b_pic_filename[i]);
    	   
    	}
	
    }
}
