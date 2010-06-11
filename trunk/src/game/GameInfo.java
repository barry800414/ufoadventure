package game;

import java.io.*;
import java.util.Scanner;


public class GameInfo {
    
    public final int  SCREEN_WIDTH = 800, SCREEN_HEIGHT = 600;
    public Player[] playerlist ;
    public Item[] itemlist;
    public Land[] landlist;
    public Event[] eventlist;
    //public int items_num,events_num,lands_num,players_num;
    
    public void init(int players_num, int init_cash, int init_deposit, int init_point){
    	//items_num = itemclassname.length;
    	//events_num = eventclassname.length;
    	//lands_num = landclassname.length;
    	//itemlist = new Item[items_num];
    	//eventlist = new Event[events_num];
    	//landlist = new Land[lands_num];
	playerlist = new Player[players_num];
	
	//Itemlist a = new Itemlist();
	
	for(int i=0;i<players_num;i++) {
	    
	    playerlist[i].cash = init_cash;
	    playerlist[i].deposit = init_deposit;
	    playerlist[i].point = init_point;
	    
	}
	
    	Scanner input = null;
    	
    	try {
    	    input = new Scanner(new FileInputStream("eventlist"));
    	    
    	    int buf = input.nextInt();
    	} catch (FileNotFoundException e) {
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
	    
	} catch (FileNotFoundException e) {
	    System.out.println("..............");
	}
    }
}
