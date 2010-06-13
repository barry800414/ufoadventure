package game;

import java.util.*;

public class Computer {
	
	private GameInfo ginfo ;
	private Player[] playerlist;
	public boolean[] playerRound;
	public int year;
	public int month;
	public int day;
	public int round;
	public Computer(GameInfo info){
		ginfo = info ;
		playerlist = ginfo.playerlist;
		playerRound = new boolean[ginfo.players_num];
		ResetPlayerRound();
		round=1;
		year=2010;
		month=6;
		day=10;
	}
	
	/*
	 * move the player by steps
	 */
	public void MovePlayer(Player p,int dicenum){
		Random rnd = new Random();
		int movement = 0;
		for(int i=0;i<dicenum;i++){
		    movement = movement + rnd.nextInt(6) + 1;
		}
		
		
	}
	/*
	 * 
	 */
	public void UseItem(Player use, Player targetp ,Road targetr){
		
	}
	
	public void BuyItem(Player p,int[] item_index,int[] buy_num){
		
	}
	
	public void ChangeCareer(Player p,Career c){
		
	}
	
	public boolean GameContinue(){
	    return ginfo.CheckMode();
	}
	
	public void Run(){
	    Update();
	    for(int i=0;i<ginfo.players_num;i++){
		playerlist[i].Update();
		while(playerRound[i]==true){
		    if(playercontrol==1) MovePlayer(playerlist[i], playerlist[i].dice_num);
		}
	    }
	}
	
	public void Update(){
	    round++;
	    AddDate();
	    ResetPlayerRound();
	}
	public void AddDate(){
	    day++;
	    if(day==32||
		    ((month==4||month==6||month==9||month==11)&&day==31)||
		    (month==2&&(year%400==0||(year%4==0&&year%100!=0))&&day>29)||
		    (month==2&&(year%4!=0||(year%400!=0&&year%100==0))&&day>28)){
		month++;
		day=1;
	    }
	    if(month==13){
		year++;
		month=1;
	    }
	}
	public void ResetPlayerRound(){
	    for(int i=0;i<ginfo.players_num;i++)
		playerRound[i]=true;
	}
	
	
	
	
	
}
