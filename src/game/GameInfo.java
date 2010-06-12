package game;

import java.io.*;
import java.util.Scanner;


public class GameInfo {
    
    public int players_num;
    public int init_cash;
    public int init_deposit;
    public int init_point;
    public int gamemode;
    public Player winner;
    public Player[] loser;
    
    public Player[] playerlist ;
    public Item[] itemlist;
    public Land[] landlist;
    public Event[] eventlist;
    
    
    public void init(){
    	
    	playerlist = new Player[players_num];
    	loser = new Player[players_num-1];
    	System.out.println(players_num + "  dsadasds");
    	for(int i=0;i<players_num;i++) {
    	    playerlist[i] = new Player("Player " + (i+1),init_cash,init_deposit,1,init_point);
    	    System.out.println("player " + (i+1) + " cash :" + playerlist[i].cash + " deposit :" + playerlist[i].deposit  + " point: " + playerlist[i].point);
    		
    	}
    }
    public boolean CheckMode(){
	int loser_num = 0;
	if(gamemode==1){
	    for(int i=0;i<players_num;i++)
		if(playerlist[i].career+playerlist[i].cash<=0)
		    loser_num++;
	    if(loser_num<players_num-1)
		return true;
	    else if(loser_num==players_num-1){
		for(int i=0,j=0;i<players_num;i++){
		    if(playerlist[i].career+playerlist[i].cash<=0)
			loser[j++]=playerlist[i];
		    else winner=playerlist[i];
		}
		return false;
	    }
	}
	else if(gamemode==2){
	    for(int i=0;i<players_num;i++)
		if(playerlist[i].house.length<50)
		    loser_num++;
	    if(loser_num<players_num-1)
		return true;
		    
	    else if(loser_num==players_num-1){
		for(int i=0,j=0;i<players_num;i++){
		    if(playerlist[i].house.length<50)
			loser[j++]=playerlist[i];
		    else winner=playerlist[i];
		}
		return false;
	    }
	}
	else if(gamemode==3){
	    for(int i=0;i<players_num;i++)
		if(playerlist[i].house.<50)
		    loser_num++;
	    if(loser_num<players_num-1)
		return true;
		    
	    else if(loser_num==players_num-1){
		for(int i=0,j=0;i<players_num;i++){
		    if(playerlist[i].house.length<50)
			loser[j++]=playerlist[i];
		    else winner=playerlist[i];
		}
		return false;
	    }
	}
	    
		    
	return false;
    }
    	
	    /*
    	Scanner input = null;   	
    	try {
    	    input = new Scanner(new FileInputStream("eventlist"));
    	    
    	    int buf = input.nextInt();
    	} 
    	catch (FileNotFoundException e) {
    		System.out.println("..............");
    	}
    	try {
    		input = new Scanner(new FileInputStream("itemlist.txt"));
    		int buf = input.nextInt();
    		itemlist = new Item[buf];
    		for(int i=0;i<buf;i++) {
    			String name = input.next();
    			int point = input.nextInt();
    			String info = input.next();
    			//int Event = input.next();
    			itemlist[i] = new Item(name, point, info);
    		}
    	}
    	catch (FileNotFoundException e) {
    		System.out.println("..............");
    	}
    	*/

}
