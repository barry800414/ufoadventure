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
    public Land[] landlist;
    
    private int control_state = 0;
    /*control_state is the bridge between GraphicsEngine & Computer
     * control_state:   0 no state
     * 					1 Throw the dice 
     * 					2 yes , ok  b
     * 					3 no 
     * 					4 item column
     */
    public static final int DEFAULT_STATE = 0;
    public static final int THROW_DICE_STATE = 1;
    public static final int YES_OK_STATE = 2;
    public static final int NO_STATE = 3;
    public static final int ITEM_COLUMN = 4;
    
    
    public GameInfo(){
    	round=1;
    	year=2010;
    	month=6;
    	day=10;
    }
    public void GameInfo_Init(){
    	Item_Init("itemlist.txt");
    	Land_Init("landlist.txt");
    	Road_Init("roadlist.txt");
    	Player_Init();
    	
    }
    
    public int get_Control_State(){
    	return control_state;
    }
    public void set_Control_State(int new_state){
    	control_state = new_state;
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
    
    private boolean Item_Init(String filename){
    	
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
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    private boolean Road_Init(String filename){
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
    			roadlist[i] = new Road(i,name,landlist[index],coor,pic,r_pic_filename);
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    private boolean Land_Init(String filename){
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
    			if(type == BUILDING){
    				for(int j=0;j<b_pic_filename.length;j++)
    					b_pic_filename[j] = input.next();
    				landlist[i] = new Building(i,name,null,price,coor,pic,null);
    			}
    			else if(type == LAB){
    				item_index = input.nextInt();
    				for(int j=0;j<l_pic_filename.length;j++)
    					l_pic_filename[j] = input.next();
    				landlist[i] = new Lab(i,name,null,price,itemlist[item_index],coor,pic,null);
    			}
    			else if(type == SPECIAL_LOCATION){
    				//for(int j=0;j<s_pic_filename.length;j++)
    				//	s_pic_filename[j] = input.next();
    				landlist[i] = new SpecialLocation(i,name,null,price,coor,pic,null);
    			}
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
    private void Player_Init(){
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
